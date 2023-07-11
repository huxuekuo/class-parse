package org.example.parse.type;

import lombok.Data;
import org.example.parse.type.constant.CpInfo;

/**
 * Class 文件结构, 字段顺序就是文件顺序
 */
@Data
public class ClassFile {

    /**
     * 魔数
     */
    private U4 magic;
    /**
     * 副版本号
     */
    private U2 minorVersion;
    /**
     * 主版本号
     */
    private U2 majorVersion;
    /**
     * 常量池数量
     */
    private U2 constantPoolCount;
    /**
     * 常量池
     */
    private CpInfo[] cpInfo;

    /**
     * 访问标识
     */
    private U2 accessFlags;

    /**
     * 类索引
     */
    private U2 thisClass;

    /**
     * 父类索引
     */
    private U2 superClass;

    /**
     * 接口总数
     */
    private U2 interfaceCount;
    /**
     * 接口总数
     */
    private U2[] interfaces;

    /**
     * 字段总数
     */
    private U2 fieldCount;
    /**
     * 字段信息
     */
    private FieldInfo[] fields;

    /**
     * 方法总数
     */
    private U2 methodCount;

    /**
     * 方法信息
     */
    private MethodInfo[] methods;

    /**
     * 属性总数
     */
    private U2 attributeCount;

    /**
     * 属性信息
     */
    private AttributeInfo[] attributes;
}
