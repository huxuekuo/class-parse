package org.example.parse.type.constant;

import org.example.parse.type.ClassFile;
import org.example.parse.type.U1;
import org.example.parse.type.U2;

import java.nio.ByteBuffer;

/**
 * CONSTANT_Fieldref_info 存储字段的符号信息
 */
public class CONSTANT_Fieldref_info extends CpInfo {


    /**
     * 必须指向 CONSTANT_Class_info 常量, 表示当前字段所在类的类名
     */
    private U2 class_index;

    /**
     * 必须指向 CONSTANT_NameAndType_info常量, 表示当前字段的名字和类型描述
     */
    private U2 name_and_type_index;

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_Fieldref_info(U1 tag) {
        super(tag);
    }


    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        class_index = new U2(codeBuf.get(), codeBuf.get());
        name_and_type_index = new U2(codeBuf.get(), codeBuf.get());
    }
}
