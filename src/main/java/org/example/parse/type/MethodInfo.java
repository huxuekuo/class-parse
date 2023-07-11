package org.example.parse.type;

import lombok.Data;

@Data
public class MethodInfo {


    /**
     * 方法访问标志和属性
     * ACC_PUBLIC 16: 0x0001 说明: 声明方法访问权限为public
     * ACC_PRIVATE 16: 0x0002 说明: 声明方法访问权限为private
     * ACC_PROTECTED 16: 0x0004 说明: 声明方法访问权限为protected
     * ACC_STATIC 16: 0x0008 说明: 声明方法访问权限为static
     * ACC_FINAL 16: 0x0010 说明: 声明方法为final 不允许覆盖
     * ACC_SYNCHRONIZED 16 0x0020 同步方法,多线程调用加锁
     * ACC_BRIDGE 16 0x0040 声明为bridge方法, 由编译器生成
     * ACC_VARARGS 16 0x0080 方法有可变长参数
     * ACC_NATIVE 16 0x0100 native方法
     * ACC_ABSTRACT 16 0x0400 抽象方法
     * ACC_STRICT 16 0x0800 使用FP-strict浮点模式
     * ACC_SYNTHETIC 16 0x1000 非源代码编译出来的
     */
    private U2 access_flags;
    /**
     * 方法名,值为指向常量池中某个常量的索引
     */
    private U2 name_index;
    /**
     * 方法描述符, 值为常量池中某个常量的索引
     */
    private U2 descriptor_index;
    /**
     * 属性总数
     */
    private U2 attributes_count;
    /**
     * 属性表
     */
    private AttributeInfo[] attributes;
}
