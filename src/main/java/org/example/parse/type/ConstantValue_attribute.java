package org.example.parse.type;

import lombok.Data;

/**
 * ConstantValue属性用于 通知虚拟机在类或接口初始化阶段为被标志为ACC_STATIC的字段自动赋值
 * 1. 接口中声明的字段
 * 2. 类中声明的静态常量字段
 *
 * 其他非ACC_STATIC的字段在类的实例化方法中完成
 */
@Data
public class ConstantValue_attribute {
    /**
     * attribute_name_index指向常量池中某个CONSTANT_Utf8_info常量,该常量表示的字符串为“ConstantValue”
     */
    private U2 attribute_name_index;
    /**
     * 长度
     */
    private U4 attribute_length;
    /**
     * constantValue_index指向基本数据类型或String类型常量。
     */
    private U2 constantValue_index;

}
