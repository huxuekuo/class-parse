package org.example.parse;

import lombok.extern.slf4j.Slf4j;
import org.example.parse.handle.ClassFileAnalysis;
import org.example.parse.type.*;
import org.example.parse.type.constant.CONSTANT_Class_info;
import org.example.parse.type.constant.CpInfo;
import org.example.parse.util.ClassAccessFlagUtils;
import org.example.parse.util.ConstantPoolUtils;
import org.example.parse.util.FieldAccessFlagUtils;

import java.io.*;
import java.nio.ByteBuffer;

@Slf4j
public class Main {
    public static void main(String[] args) throws Exception {
        ByteBuffer codeBuf = readFile("/Users/lirui/Desktop/class-parse/target/test-classes/org/example/parse/test/User.class");
        ClassFile analysis = ClassFileAnalysis.analysis(codeBuf);
        for (CpInfo cpInfo : analysis.getCpInfo()) {
            System.out.println(cpInfo.toString());
        }
        ConstantPoolUtils.getCode(analysis);
    }

    public static void all() {
        try {
            ByteBuffer codeBuf = readFile("/Users/lirui/Desktop/class-parse/target/test-classes/org/example/parse/test/Test.class");
            ClassFile analysis = ClassFileAnalysis.analysis(codeBuf);
            log.debug("magic-魔数:{}", analysis.getMagic().toHexString());
            log.debug("minorVersion-次版本:{}", analysis.getMinorVersion().toInt());
            log.debug("majorVersion-主版本:{}", analysis.getMajorVersion().toInt());
            log.debug("constantPoolCount-常量池长度:{}", analysis.getConstantPoolCount().toInt());
            log.debug("constantPoolInfo-常量池内容---start");
            CpInfo[] cpInfo = analysis.getCpInfo();
            for (int i = 0; i < cpInfo.length; i++) {
                log.debug("#{}:{}", i + 1, cpInfo[i].toString());
            }
            log.debug("constantPoolInfo-常量池内容---end");
            log.debug("accessFlags-class文件访问标识:{}", ClassAccessFlagUtils.toClassAccessFlagsString(analysis.getAccessFlags()));
            /**
             * this_class 与 super_class 必须指向一个CONSTANT_Class_info常量项
             */
            String thisClassName = ConstantPoolUtils.byConstantClass((CONSTANT_Class_info) analysis.getCpInfo()[analysis.getThisClass().toInt() - 1], analysis.getCpInfo());
            String SuperClassName = ConstantPoolUtils.byConstantClass((CONSTANT_Class_info) analysis.getCpInfo()[analysis.getSuperClass().toInt() - 1], analysis.getCpInfo());
            log.debug("thisClass-class内容:{}", thisClassName.toString());
            log.debug("superClass-class内容:{}", SuperClassName.toString());
            /**
             * 实现接口信息
             */
            Integer anInt = analysis.getInterfaceCount().toInt();
            log.debug("interfaces-实现接口数量:{}", anInt);
            U2[] interfaces = analysis.getInterfaces();
            for (int i = 0; i < analysis.getInterfaces().length; i++) {
                int constantPoolIndex = interfaces[i].toInt() - 1;
                String interfaceName = ConstantPoolUtils.byConstantClass((CONSTANT_Class_info) analysis.getCpInfo()[constantPoolIndex], analysis.getCpInfo());
                log.debug("interfaces-实现接口:{}", interfaceName);
            }

            log.debug("field_count-class文件字段数量:{}", analysis.getFieldCount().toInt());
            FieldInfo[] fields = analysis.getFields();
            for (int i = 0; i < fields.length; i++) {
                log.debug("field_info - \n字段名称信息:{},\n类型描述符:{},\n访问权限:{}, \n属性数量:{}",
                        cpInfo[fields[i].getNameIndex().toInt() - 1].toString(),
                        cpInfo[fields[i].getDescriptorIndex().toInt() - 1].toString(),
                        FieldAccessFlagUtils.toFieldFlagsString(fields[i].getAccessFlags()),
                        fields[i].getAttributesCount().toInt());
            }

            log.debug("method_count-class文件方法数量:{}", analysis.getMethodCount().toInt());
            MethodInfo[] methodInfoArray = analysis.getMethods();
            for (int i = 0; i < methodInfoArray.length; i++) {
                log.debug("method_info - \n方法名称信息:{},\n类型描述符:{},\n访问权限:{}, \n属性数量:{}",
                        cpInfo[methodInfoArray[i].getName_index().toInt() - 1].toString(),
                        cpInfo[methodInfoArray[i].getDescriptor_index().toInt() - 1].toString(),
                        FieldAccessFlagUtils.toFieldFlagsString(methodInfoArray[i].getAccess_flags()),
                        methodInfoArray[i].getAttributes_count().toInt());
            }

            log.debug(ConstantPoolUtils.getConstantValue(analysis));
            ConstantPoolUtils.getCode(analysis);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private static ByteBuffer readFile(String filePath) throws IOException {

        File file = new File(filePath);
        if (!file.exists()) {
            throw new RuntimeException("file not exists!");
        }

        byte[] byteCodeBuf = new byte[4096];
        int length;
        try (InputStream in = new FileInputStream(file)) {
            length = in.read(byteCodeBuf);
        }

        if (length < 1) {
            throw new RuntimeException("not read byte code");
        }

        return ByteBuffer.wrap(byteCodeBuf, 0, length).asReadOnlyBuffer();
    }
}