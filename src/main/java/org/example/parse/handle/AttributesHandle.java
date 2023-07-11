package org.example.parse.handle;

import org.example.parse.type.AttributeInfo;
import org.example.parse.type.ClassFile;
import org.example.parse.type.U2;
import org.example.parse.type.U4;

import java.nio.ByteBuffer;

public class AttributesHandle implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 8;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setAttributeCount(new U2(codeBuf.get(), codeBuf.get()));
        int attributeLen = classFile.getAttributeCount().toInt();
        AttributeInfo[] attArray = new AttributeInfo[attributeLen];
        for (int i = 0; i < attributeLen; i++) {
            AttributeInfo info = new AttributeInfo();
            info.setAttribute_name_index(new U2(codeBuf.get(), codeBuf.get()));
            info.setAttribute_length(new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get()));

            int attributeInfoLen = info.getAttribute_length().toInt();
            byte[] bytes = new byte[attributeInfoLen];
            codeBuf.get(bytes, 0, bytes.length);
            info.setInfo(bytes);
            attArray[i] = info;
        }
        classFile.setAttributes(attArray);
    }
}
