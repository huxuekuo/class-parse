package org.example.parse.handle;

import org.example.parse.type.*;

import java.nio.ByteBuffer;

public class FieldHandle implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 6;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setFieldCount(new U2(codeBuf.get(), codeBuf.get()));
        Integer fieldCount = classFile.getFieldCount().toInt();
        FieldInfo[] fieldInfos = new FieldInfo[fieldCount];
        for (Integer i = 0; i < fieldCount; i++) {
            FieldInfo info = new FieldInfo();
            info.setAccessFlags(new U2(codeBuf.get(), codeBuf.get()));
            info.setNameIndex(new U2(codeBuf.get(), codeBuf.get()));
            info.setDescriptorIndex(new U2(codeBuf.get(), codeBuf.get()));
            info.setAttributesCount(new U2(codeBuf.get(), codeBuf.get()));

            Integer attributeCount = info.getAttributesCount().toInt();
            AttributeInfo[] attributes = new AttributeInfo[attributeCount];
            for (Integer integer = 0; integer < attributeCount; integer++) {
                AttributeInfo aInfo = new AttributeInfo();
                aInfo.setAttribute_name_index(new U2(codeBuf.get(), codeBuf.get()));
                aInfo.setAttribute_length(new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get()));

                Integer anInt = aInfo.getAttribute_length().toInt();
                byte[] aValue = new byte[anInt];
                codeBuf.get(aValue, 0, aValue.length);
                aInfo.setInfo(aValue);
                attributes[integer] = aInfo;
            }
            info.setAttributes(attributes);
            fieldInfos[i] = info;
        }
        classFile.setFields(fieldInfos);
    }
}
