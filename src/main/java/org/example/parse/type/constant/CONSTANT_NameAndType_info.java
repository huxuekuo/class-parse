package org.example.parse.type.constant;

import org.example.parse.type.U1;
import org.example.parse.type.U2;

import java.nio.ByteBuffer;

/**
 * 用于存储字段的名称和字段的类型描述
 * 或者用于存储方法名称和方法描述
 */
public class CONSTANT_NameAndType_info extends CpInfo {

    private U2 name_index;
    private U2 descriptor_index;

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_NameAndType_info(U1 tag) {
        super(tag);
    }

    public void read(ByteBuffer codeBuf) throws Exception {
        // 名称索引
        name_index = new U2(codeBuf.get(), codeBuf.get());
        // 描述符索引
        descriptor_index = new U2(codeBuf.get(), codeBuf.get());
    }

}
