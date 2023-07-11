package org.example.parse.type.constant;

import org.example.parse.type.U1;
import org.example.parse.type.U2;

import java.nio.ByteBuffer;

/**
 * CONSTANT_MethodHandle_info 用于存储方法句柄
 * 这是虚拟机为实现动态调用invokedynamic指令所增加的常量结构
 * <p>
 * 必须包含一个U1类型的字段 reference_kind , 取值范围! 1 ~ 9, 包含1 , 9 表示方法句柄类型
 * 还有一个U1类型的西段 reference_index , 其值为指向常量池中某个常量的索引
 */
public class CONSTANT_MethodHandle_info extends CpInfo{

    /**
     * 1 ERF_getField CONSTANT_Fieldref_info
     * 2 REF_getStatic CONSTANT_Fieldref_info
     * 3 REF_putField CONSTANT_Fieldref_info
     * 4 REF_putField CONSTANT_Fieldref_info
     * 5 REF_invokeVirtual CONSTANT_Methodref_info
     * 6 REF_invokeStatic (CONSTANT_Methodref_info , CONSTANT_InterfaceMethodref_info)
     * 7 REF_invokeSpecial (CONSTANT_Methodref_info , CONSTANT_InterfaceMethodref_info)
     * 8 REF_newInvokeSpecial CONSTANT_Methodref_info
     * 9 REF_invokeInterface CONSTANT_InterfaceMethodref_info
     */
    private U1 reference_kind;
    /**
     * 指向与 reference_kind 类型一直的索引
     */
    private U2 reference_index;

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_MethodHandle_info(U1 tag) {
        super(tag);
    }


    @Override
    public void read(ByteBuffer codeBuf) throws Exception {
        this.reference_kind = new U1(codeBuf.get());
        this.reference_index = new U2(codeBuf.get(),codeBuf.get());
    }
}
