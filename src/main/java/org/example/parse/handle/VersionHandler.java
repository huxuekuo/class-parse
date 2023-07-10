package org.example.parse.handle;

import org.example.parse.type.ClassFile;
import org.example.parse.type.U2;

import java.nio.ByteBuffer;

public class VersionHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 1;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setMinorVersion(new U2(codeBuf.get(), codeBuf.get()));
        classFile.setMajorVersion(new U2(codeBuf.get(), codeBuf.get()));
    }
}
