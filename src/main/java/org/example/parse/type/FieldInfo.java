package org.example.parse.type;

import lombok.Data;

/**
 *
 */
@Data
public class FieldInfo {

    /**
     * 访问标志
     * 标志名: ACC_PUBLIC  16: 0x0001 说明: 声明为public
     * 标志名: ACC_PRIVATE  16: 0x0002 说明: 声明为private
     * 标志名: ACC_PROTECTED  16: 0x0004 说明: 声明为protected
     * 标志名: ACC_STATIC  16: 0x0008 说明: 声明为static
     * 标志名: ACC_FINAL  16: 0x0010 说明: 声明为final
     * 标志名: ACC_VOLATILE  16: 0x0040 说明: 声明为volatile
     * 标志名: ACC_TRANSIENT  16: 0x0080 说明: 声明为transient
     * 标志名: ACC_SYNTHTIC  16: 0x1000 说明: 该标志由编译器生成, 不在源码中
     * 标志名: ACC_ENUM  16: 0x4000 说明: 声明为枚举类型的成员
     */
    private U2 accessFlags;
    /**
     * 字段名, 指向常量池中某个常量索引
     */
    private U2 nameIndex;
    /**
     * 类型描述符,指向常量池中某个常量索引
     */
    private U2 descriptorIndex;
    /**
     * 属性总数
     */
    private U2 attributesCount;
    /**
     * 属性
     */
    private AttributeInfo[] attributes;
}
