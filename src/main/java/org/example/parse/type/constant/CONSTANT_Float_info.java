package org.example.parse.type.constant;

import org.example.parse.type.U1;

/**
 * CONSTANT_Float_info 与 CONSTANT_Integer_info 结构一致
 * 只是 bytes 存储的内容不同, Float_info 存储的是 浮点数
 */
public class CONSTANT_Float_info extends CONSTANT_Integer_info{

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_Float_info(U1 tag) {
        super(tag);
    }
}
