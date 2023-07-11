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

}
