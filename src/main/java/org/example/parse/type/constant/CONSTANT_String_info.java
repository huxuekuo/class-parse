package org.example.parse.type.constant;

import org.example.parse.type.ClassFile;
import org.example.parse.type.U1;
import org.example.parse.type.U2;

import java.nio.ByteBuffer;

/**
 * CONSTANT_String_info 结构存储java中String类型的常量
 * 除tag字段以后, 必须还有一个U2类型的String_index, 值为常量池中某个常量的索引
 * 该索引指向的常量必须是一个 CONSTANT_Utf8_info
 */
public class CONSTANT_String_info extends CpInfo {

    /**
     * 值为常量池索引, 必须指向的是 CONSTANT_Utf8_info
     */
    private U2 string_index;

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_String_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        string_index = new U2(codeBuf.get(), codeBuf.get());

    }
}
