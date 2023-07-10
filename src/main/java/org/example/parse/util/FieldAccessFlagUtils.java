package org.example.parse.util;

import org.example.parse.type.U2;

import java.util.HashMap;
import java.util.Map;


public class FieldAccessFlagUtils {

    private static Map<Integer, String> accessFlagMap = new HashMap<>();

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
    static {
        accessFlagMap.put(0x0001, "public");
        accessFlagMap.put(0x0002, "private");
        accessFlagMap.put(0x0004, "protected");
        accessFlagMap.put(0x0008, "static");
        accessFlagMap.put(0x0010, "final");
        accessFlagMap.put(0x0040, "volatile");
        accessFlagMap.put(0x0080, "transient");
        accessFlagMap.put(0x1000, "该标志由编译器生成, 不在源码中");
        accessFlagMap.put(0x4000, "枚举类型的成员");
    }

    /**
     * 如何判断一个类型都包含表中那些标识?
     * 1. 将 class 文件中 access_flags 的值转换为int值
     * 2. 然转换后的值`算术与`上各个标识值, 判断结果是否等于这个标识值
     *
     * @param flag
     * @return
     */
    public static String toFieldFlagsString(U2 flag) {
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
