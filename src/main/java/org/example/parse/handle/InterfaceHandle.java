package org.example.parse.handle;

import org.example.parse.type.ClassFile;
import org.example.parse.type.U2;

import java.nio.ByteBuffer;

public class InterfaceHandle implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 5;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setInterfaceCount(new U2(codeBuf.get(), codeBuf.get()));
        // 获取实现接口数量
        Integer anInt = classFile.getInterfaceCount().toInt();

        // 获取实现具体接口信息
        U2[] interfaces = new U2[anInt];
        for (Integer i = 0; i < anInt; i++) {
            interfaces[i] = new U2(codeBuf.get(), codeBuf.get());
        }
        classFile.setInterfaces(interfaces);
    }
}
