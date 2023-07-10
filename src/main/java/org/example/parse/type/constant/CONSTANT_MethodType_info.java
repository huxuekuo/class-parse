package org.example.parse.type.constant;

import org.example.parse.type.U1;
import org.example.parse.type.U2;

import java.nio.ByteBuffer;

/**
 * CONSTANT_MethodType_indo 结构表示方法类型, 与 CONSTANT_MethodHandle_info 结构一样,
 * 也是虚拟机调用invokeynamic指令所增加的常量结构
 * <p>
 * 除tag 外, 还必须包含一个descriptor_index , 指向常量池中某一CONSTANT_Utf8_index
 */
public class CONSTANT_MethodType_info extends CpInfo {

    private U2 descriptor_index;

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_MethodType_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        this.descriptor_index = new U2(codeBuf.get(), codeBuf.get());
    }
}
