package org.example.parse.handle;

import java.nio.ByteBuffer;

public interface ConstantInfoHandle {

    /**
     * 读取
     * @param codeBuf
     * @throws Exception
     */
    void read(ByteBuffer codeBuf) throws Exception;
}
