package org.example.parse.type.constant;

import org.example.parse.type.U1;
import org.example.parse.type.U2;
import org.example.parse.type.constant.CpInfo;

import java.nio.ByteBuffer;

/**
 * JAVA SE: 9
 * Class MajorVersion: 53.0
 * tag: 19
 */
public class CONSTANT_Module_Info extends CpInfo {

    /**
     * 该项必须是 Constant_pool 中的 CONSTANT_Utf8_info 保存模块名称
     */
    private U2 name_index;

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_Module_Info(U1 tag) {
        super(tag);
    }

    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        this.name_index = new U2(codeBuf.get(), codeBuf.get());
    }
}
