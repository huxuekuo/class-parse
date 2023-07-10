package org.example.parse.type.constant;

import org.example.parse.type.ClassFile;
import org.example.parse.type.U1;
import org.example.parse.type.U2;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * CONSTANT_Utf8_info常量用于存储字符串常量
 * 除了必须的tag 和 存储字符串的字节数组外, 还有一个必要字节数组长度
 */
public class CONSTANT_Utf8_info extends CpInfo {

    /**
     * 字节数组长度
     */
    private U2 length;

    /**
     * 存储字符串内容
     */
    private byte[] bytes;

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_Utf8_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        length = new U2(codeBuf.get(), codeBuf.get());
        bytes = new byte[length.toInt()];
        codeBuf.get(bytes, 0, length.toInt());
    }

    public String toString() {
        return super.toString().concat(",length=".concat(String.valueOf(length.toInt()))
                .concat(",str=".concat(new String(bytes, StandardCharsets.UTF_8))));
    }
}
