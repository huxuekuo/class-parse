package org.example.parse.type.constant;

import org.example.parse.type.U1;

/**
 * CONSTANT_Double_info 与 CONSTANT_Long_info 结构一致
 * 只是数值表示不同
 */
public class CONSTANT_Double_info extends CONSTANT_Long_info{

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_Double_info(U1 tag) {
        super(tag);
    }
}
