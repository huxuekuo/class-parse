package org.example.parse.util;

import org.example.parse.type.U2;

import java.util.HashMap;
import java.util.Map;

/**
 * 解析Class文件的访问标识
 * class文件结构中的访问标志项 access_flags 是一个U2类型存储, 也就是2个字节.
 * 用某个bit位的值是否为1 判断该类或者接口的 访问权限, 属性.
 */
public class ClassAccessFlagUtils {

    private static Map<Integer, String> accessFlagMap = new HashMap<>();

    static {
        accessFlagMap.put(0x0001, "public"); // 标识名称 ACC_PUBLIC , 声明为public
        accessFlagMap.put(0x0010, "final"); // 标识名称 ACC_FINAL, 声明为final, 不允许被继承
        accessFlagMap.put(0x0020, "super"); // 标识名称 ACC_SUPER , JDK 1.0.2 以后编译的Class文件都会有此值
        accessFlagMap.put(0x0200, "interface"); // 标识名称 ACC_INTERFACE 声明改class 是接口
        accessFlagMap.put(0x0400, "abstract"); // 标识名称 ACC_ABSTRACT , 声明该class是抽象类
        accessFlagMap.put(0x1000, "synthetic"); // 标识名称 SYNTHETIC , 表示该Class文件并非由java代码编译生产
        accessFlagMap.put(0x2000, "annotation"); // 标识名称 ACC_ANNOTATION , 标志这是一个注解类型
        accessFlagMap.put(0x4000, "enum"); // 标识名称 ACC_ENUM, 标志这是一个枚举类型
    }

    /**
     * 如何判断一个类型都包含表中那些标识?
     * 1. 将 class 文件中 access_flags 的值转换为int值
     * 2. 然转换后的值`算术与`上各个标识值, 判断结果是否等于这个标识值
     *
     * @param flag
     * @return
     */
    public static String toClassAccessFlagsString(U2 flag) {
        Integer flagValue = flag.toInt();
        StringBuilder flagBuilder = new StringBuilder();
        accessFlagMap.keySet().forEach(key -> {
            if ((flagValue & key) == key) {
                flagBuilder.append(accessFlagMap.get(key)).append(",");
            }
        });
        String flagStr = flagBuilder.toString();
        return flagStr.endsWith(",") ? flagStr.substring(0, flagStr.length() - 1) : flagStr;
    }
}
