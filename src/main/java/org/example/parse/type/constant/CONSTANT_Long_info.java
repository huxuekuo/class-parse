package org.example.parse.type.constant;

import org.example.parse.type.ClassFile;
import org.example.parse.type.U1;
import org.example.parse.type.U4;

import java.nio.ByteBuffer;

/**
 * CONSTANT_Long_info 使用8个字节存储一个长整型数值
 * 使用两个U4, 分别表示 高32位, 低32位
 */
public class CONSTANT_Long_info extends CpInfo {


    /**
     * 高 32 位
     */
    private U4 hight_bytes;

    /**
     * 低 32 位
     */
    private U4 low_bytes;


    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_Long_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        // 读取 高 32位
        hight_bytes = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
        // 读取 低 32位
        low_bytes = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
    }
}
