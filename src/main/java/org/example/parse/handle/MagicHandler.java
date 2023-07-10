package org.example.parse.handle;

import org.example.parse.type.ClassFile;
import org.example.parse.type.U4;

import java.nio.ByteBuffer;

public class MagicHandler implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 0;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setMagic(new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get()));
    }
}
