package org.example.parse.type.constant;

import org.example.parse.type.U1;

/**
 * CONSTANT_Methodref_info 与 CONSTANT_Fieldref_info 一样, 直接集成
 */
public class CONSTANT_Methodref_info extends CONSTANT_Fieldref_info {

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_Methodref_info(U1 tag) {
        super(tag);
    }
}
