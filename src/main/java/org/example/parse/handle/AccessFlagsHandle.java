package org.example.parse.handle;

import org.example.parse.type.ClassFile;
import org.example.parse.type.U2;
import org.example.parse.util.ClassAccessFlagUtils;

import java.nio.ByteBuffer;

public class AccessFlagsHandle implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 3;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setAccessFlags(new U2(codeBuf.get(), codeBuf.get()));
    }
}
