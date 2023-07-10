package org.example.parse.type.constant;

import org.example.parse.type.U1;
import org.example.parse.type.U2;

import java.nio.ByteBuffer;

/**
 * CONSTANT_Class_info 常量存储类的符号信息
 * 除tag字段外, 还存储一个指向常量的索引字段 name_index
 * name_index 必须指向一个CONSTANT_Utf8_info常量, 该常量存储Class类名
 */
public class CONSTANT_Class_info extends CpInfo {

    /**
     * 该值指向 CONSTANT_Utf8_info 常量 内容是: Class类型坐标
     */
    private U2 name_index;

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_Class_info(U1 tag) {
        super(tag);
    }

    public void read(ByteBuffer codeBuf) throws Exception {
        this.name_index = new U2(codeBuf.get(), codeBuf.get());
    }
}
