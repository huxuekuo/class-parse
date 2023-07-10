package org.example.parse.handle;

import lombok.extern.slf4j.Slf4j;
import org.example.parse.type.ClassFile;
import org.example.parse.type.U1;
import org.example.parse.type.U2;
import org.example.parse.type.constant.CpInfo;

import java.nio.ByteBuffer;

@Slf4j
public class ConstantPoolHandle implements BaseByteCodeHandler {

    @Override
    public int order() {
        return 2;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        // 获取常量池长度
        U2 cpLen = new U2(codeBuf.get(), codeBuf.get());
        classFile.setConstantPoolCount(cpLen);

        int length = cpLen.toInt() - 1;
        classFile.setCpInfo(new CpInfo[length]);
        for (int i = 0; i < length; i++) {
            U1 tag = new U1(codeBuf.get());

            CpInfo cpInfo = CpInfo.newCpInfo(tag);
            cpInfo.read(codeBuf);
            classFile.getCpInfo()[i] = cpInfo;
        }
    }
}
