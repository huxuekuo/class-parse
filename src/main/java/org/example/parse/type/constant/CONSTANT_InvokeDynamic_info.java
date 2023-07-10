package org.example.parse.type.constant;

import org.example.parse.type.U1;
import org.example.parse.type.U2;

import java.nio.ByteBuffer;

/**
 * CONSTANT_InvokeDynamic_info 表示 invokedynamic指令用到引导方法 Bootstrap method
 */
public class CONSTANT_InvokeDynamic_info extends CpInfo {

    private U2 bootstrap_method_attr_index;

    private U2 name_and_type_index;


    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_InvokeDynamic_info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        this.bootstrap_method_attr_index = new U2(codeBuf.get(), codeBuf.get());
        this.name_and_type_index = new U2(codeBuf.get(), codeBuf.get());
    }
}
