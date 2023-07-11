package org.example.parse.util;

import org.example.parse.type.*;

import java.nio.ByteBuffer;

public class AttributeUtils {

    public static ConstantValue_attribute processingConstantValue(AttributeInfo info) {
        ConstantValue_attribute attribute = new ConstantValue_attribute();
        attribute.setAttribute_name_index(info.getAttribute_name_index());
        attribute.setAttribute_length(info.getAttribute_length());
        attribute.setConstantValue_index(new U2(info.getInfo()[0], info.getInfo()[1]));
        return attribute;
    }


    public static CodeAttribute processingCode(AttributeInfo info) {
        CodeAttribute code = new CodeAttribute();
        ByteBuffer body = ByteBuffer.wrap(info.getInfo());
        // 操作数栈大小
        code.setMax_stack(new U2(body.get(), body.get()));
        // 局部变量表大小
        code.setMax_locals(new U2(body.get(), body.get()));
        // 字节码数组长度
        code.setCode_length(new U4(body.get(), body.get(), body.get(), body.get()));
        // 解析获取字节码
        byte[] byteCode = new byte[code.getCode_length().toInt()];
        body.get(byteCode, 0, byteCode.length);
        code.setCode(byteCode);
        return code;
    }
}
