package org.example.parse.type.constant;

import org.example.parse.type.U1;
import org.example.parse.type.U2;
import org.example.parse.type.constant.CpInfo;

import java.nio.ByteBuffer;

/**
 * JAVA SE: 11
 * Class MajorVersion: 55.0
 * tag: 17
 */
public class CONSTANT_Dynamic_Info extends CONSTANT_InvokeDynamic_info {

    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_Dynamic_Info(U1 tag) {
        super(tag);
    }
}
