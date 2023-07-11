package org.example.parse.util;

import org.example.parse.type.*;
import org.example.parse.type.constant.*;

import java.util.Objects;

public class ConstantPoolUtils {


    public static String byConstantClass(CONSTANT_Class_info classInfo, CpInfo[] cpInfo) {
        int classInt = classInfo.getName_index().toInt();
        CONSTANT_Utf8_info className = (CONSTANT_Utf8_info) cpInfo[classInt - 1];
        return className.toString();
    }

    public static String getConstantValue(ClassFile classFile) {
        FieldInfo[] fields = classFile.getFields();
        for (FieldInfo field : fields) {
            AttributeInfo[] attributes = field.getAttributes();
            if (Objects.isNull(attributes) || attributes.length <= 0) {
                continue;
            }
            for (AttributeInfo attribute : attributes) {
                U2 attributeNameIndex = attribute.getAttribute_name_index();
                CONSTANT_Utf8_info attributeNameInfo = (CONSTANT_Utf8_info) classFile.getCpInfo()[attributeNameIndex.toInt() - 1];
                String attributeName = new String(attributeNameInfo.getBytes());
                if (attributeName.equalsIgnoreCase("ConstantValue")) {
                    ConstantValue_attribute constantValue = AttributeUtils.processingConstantValue(attribute);
                    U2 cv_index = constantValue.getConstantValue_index();
                    Object cv = classFile.getCpInfo()[cv_index.toInt() - 1];
                    if (cv instanceof CONSTANT_Utf8_info) {
                        return "ConstantValue：" + cv.toString();
                    } else if (cv instanceof CONSTANT_Integer_info) {
                        return "ConstantValue：" +
                                ((CONSTANT_Integer_info) cv).getBytes().toInt();
                    } else if (cv instanceof CONSTANT_Float_info) {
                        // todo
                    } else if (cv instanceof CONSTANT_Long_info) {
                        // todo
                    } else if (cv instanceof CONSTANT_Double_info) {
                        // todo
                    }
                }
            }
        }
        return "ConstantValue: parse error";
    }


    public static void getCode(ClassFile classFile) {
        // 获取方法表
        MethodInfo[] methodInfos = classFile.getMethods();
        // 遍历方法表
        for (MethodInfo methodInfo : methodInfos) {
            // 获取方法的属性表
            AttributeInfo[] attributeInfos = methodInfo.getAttributes();
            if (attributeInfos == null || attributeInfos.length == 0) {
                continue;
            }
            System.out.println("方法：" + classFile.getCpInfo()
                    [methodInfo.getName_index().toInt() - 1]);
            // 遍历属性表
            for (AttributeInfo attributeInfo : attributeInfos) {
                // 获取属性的名称
                U2 name_index = attributeInfo.getAttribute_name_index();
                CONSTANT_Utf8_info name_info = (CONSTANT_Utf8_info)
                        classFile.getCpInfo()[name_index.toInt() - 1];
                String name = new String(name_info.getBytes());
                // 对Code属性二次解析
                if (name.equalsIgnoreCase("Code")) {
                    // 属性二次解析
                    CodeAttribute code = AttributeUtils.processingCode(attributeInfo);
                    System.out.println("操作数栈大小：" + code.getMax_stack().toInt());
                    System.out.println("局部变量表大小：" + code.getMax_locals().toInt());
                    System.out.println("字节码数组长度：" + code.getCode_length().toInt());
                    System.out.println("字节码：");
                    for (byte b : code.getCode()) {
                        System.out.print((b & 0xff) + " ");
                    }
                    System.out.println("\n");
                }
            }
        }
    }


}
