package org.example.parse.util;

import org.example.parse.type.constant.CONSTANT_Class_info;
import org.example.parse.type.constant.CONSTANT_Utf8_info;
import org.example.parse.type.constant.CpInfo;

public class ConstantPoolUtils {


    public static String byConstantClass(CONSTANT_Class_info classInfo, CpInfo[] cpInfo) {
        int classInt = classInfo.getName_index().toInt();
        CONSTANT_Utf8_info className = (CONSTANT_Utf8_info) cpInfo[classInt - 1];
        return className.toString();
    }

}
