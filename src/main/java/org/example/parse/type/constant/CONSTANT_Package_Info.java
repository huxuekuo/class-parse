package org.example.parse.type.constant;

import org.example.parse.type.U1;
import org.example.parse.type.constant.CpInfo;

import java.nio.ByteBuffer;

/**
 * JAVA SE: 9
 * Class MajorVersion: 53.0
 * tag: 20
 *
 * CONSTANT_package_Info 与 CONSTANT_Module_Info 结构一致
 * 只是Package_Info 的name_index 存放的是 包名称
 *
 */
public class CONSTANT_Package_Info extends CONSTANT_Module_Info {
    /**
     * info 字节数组存储的内容和长度由tag值决定
     *
     * @param tag
     */
    public CONSTANT_Package_Info(U1 tag) {
        super(tag);
    }
}
