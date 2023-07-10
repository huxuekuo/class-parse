package org.example.parse;

import lombok.extern.slf4j.Slf4j;
import org.example.parse.handle.ClassFileAnalysis;
import org.example.parse.type.ClassFile;
import org.example.parse.type.U2;
import org.example.parse.type.constant.CONSTANT_Class_info;
import org.example.parse.type.constant.CONSTANT_Utf8_info;
import org.example.parse.type.constant.CpInfo;
import org.example.parse.util.ClassAccessFlagUtils;
import org.example.parse.util.ConstantPoolUtils;

import java.io.*;
import java.nio.ByteBuffer;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            ByteBuffer codeBuf = readFile("/Users/lirui/Desktop/javaproject/aphoto-mall/yc-admin-api/target/classes/com/qiguliuxing/dts/admin/api/IErrorCode.class");
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

            Integer anInt = analysis.getInterfaceCount().toInt();
            log.debug("interfaces-实现接口数量:{}", anInt);
            if (anInt > 0) {
                U2[] interfaces = analysis.getInterfaces();
                for (int i = 0; i < analysis.getInterfaces().length; i++) {
                    String interfaceName = ConstantPoolUtils.byConstantClass((CONSTANT_Class_info) analysis.getCpInfo()[interfaces[i].toInt() - 1], analysis.getCpInfo());
                    log.debug("interfaces-实现接口:{}", interfaceName);
                }
            }

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