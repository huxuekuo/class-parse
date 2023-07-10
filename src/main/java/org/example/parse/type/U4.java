package org.example.parse.type;

import org.example.parse.util.ByteToHexConverterUtil;

import java.nio.ByteBuffer;

public class U4 {
    private final byte[] values;

    public U4(byte b1, byte b2, byte b3, byte b4) {
        this.values = new byte[]{b1, b2, b3, b4};
    }

    public Integer toInt() {
        int value = 0;
        // 由高位到低位
        for (int i = 0; i < 4; i++) {
            int shift = (4 - 1 - i) * 8;
            value += (this.values[i] & 0x000000FF) << shift;// 往高位游
        }
        return value;
    }

    public String toHexString() {
        return ByteToHexConverterUtil.byteArrayToHexString(this.values);
    }
}
