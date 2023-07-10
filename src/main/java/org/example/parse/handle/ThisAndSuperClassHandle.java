package org.example.parse.handle;

import org.example.parse.type.ClassFile;
import org.example.parse.type.U2;

import java.nio.ByteBuffer;

public class ThisAndSuperClassHandle implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 4;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setThisClass(new U2(codeBuf.get(), codeBuf.get()));
        classFile.setSuperClass(new U2(codeBuf.get(), codeBuf.get()));
    }
}
