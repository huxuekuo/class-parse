package org.example.parse.type.constant;

import org.example.parse.type.ClassFile;
import org.example.parse.type.U1;
import org.example.parse.type.U4;

import java.nio.ByteBuffer;

/**
 * CONSTANT_Integer_info 存储一个整形整数值
 * 除tag外, 还必须包含一个U4类型 bytes, bytes转换为10进制就是常量所表示的整数值
 */
public class CONSTANT_Integer_info extends CpInfo {

    /**
     * bytes 转换为10进制就是常数所表示的整数值
     */
    private U4 bytes;

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_Integer_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        bytes = new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get());
    }
}
