package org.example.parse.handle;

import org.example.parse.type.*;

import java.nio.ByteBuffer;

public class MethodHandle implements BaseByteCodeHandler {
    @Override
    public int order() {
        return 7;
    }

    @Override
    public void read(ByteBuffer codeBuf, ClassFile classFile) throws Exception {
        classFile.setMethodCount(new U2(codeBuf.get(), codeBuf.get()));

        int methodCount = classFile.getMethodCount().toInt();
        MethodInfo[] methodInfoArray = new MethodInfo[methodCount];
        for (int i = 0; i < methodCount; i++) {
            MethodInfo info = new MethodInfo();
            info.setAccess_flags(new U2(codeBuf.get(), codeBuf.get()));
            info.setName_index(new U2(codeBuf.get(), codeBuf.get()));
            info.setDescriptor_index(new U2(codeBuf.get(), codeBuf.get()));
            info.setAttributes_count(new U2(codeBuf.get(), codeBuf.get()));

            int attributesCount = info.getAttributes_count().toInt();
            AttributeInfo[] aInfoArray = new AttributeInfo[attributesCount];
            for (int i1 = 0; i1 < attributesCount; i1++) {
                AttributeInfo aInfo = new AttributeInfo();
                aInfo.setAttribute_name_index(new U2(codeBuf.get(), codeBuf.get()));
                aInfo.setAttribute_length(new U4(codeBuf.get(), codeBuf.get(), codeBuf.get(), codeBuf.get()));

                int attributeLength = aInfo.getAttribute_length().toInt();
                byte[] bytes = new byte[attributeLength];
                codeBuf.get(bytes, 0, bytes.length);
                aInfo.setInfo(bytes);
                aInfoArray[i1] = aInfo;
            }
            info.setAttributes(aInfoArray);
            methodInfoArray[i] = info;
        }
        classFile.setMethods(methodInfoArray);
    }
}
