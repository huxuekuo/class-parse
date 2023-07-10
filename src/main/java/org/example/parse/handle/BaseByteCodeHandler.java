package org.example.parse.handle;

import org.example.parse.type.ClassFile;

import java.nio.ByteBuffer;

public interface BaseByteCodeHandler {

    /**
     * 解释器的排序值
     */
    int order();

    /**
     * 读取数据
     *
     * @param codeBuf   代码
     * @param classFile 承载文件
     */
    void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception;
}
