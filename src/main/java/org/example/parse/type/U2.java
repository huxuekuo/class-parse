package org.example.parse.type;

import org.example.parse.util.ByteToHexConverterUtil;

import java.nio.ByteBuffer;

public class U2 {

    private final byte[] values;

    public U2(byte b1, byte b2) {
        this.values = new byte[]{b1, b2};
    }

    public Integer toInt() {
        int value = 0;
        // 由高位到低位
        for (int i = 0; i < 2; i++) {
            int shift = (2 - 1 - i) * 8;
            value += (this.values[i] & 0x000000FF) << shift;// 往高位游
        }
        return value;
    }

    public String toHexString() {
        return ByteToHexConverterUtil.byteArrayToHexString(this.values);
    }
}
