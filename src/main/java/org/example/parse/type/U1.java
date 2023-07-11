package org.example.parse.type;

import org.example.parse.util.ByteToHexConverterUtil;

public class U1 {

    private final byte values;

    public U1(byte b1) {
        this.values = b1;
    }

    public Integer toInt() {
        int value = 0;
        // 由高位到低位
        for (int i = 0; i < 1; i++) {
            int shift = (1 - 1 - i) * 8;
            value += (this.values & 0x000000FF) << shift;// 往高位游
        }
        return value;
    }

    public String toHexString() {
        return ByteToHexConverterUtil.byteArrayToHexString(new byte[]{this.values});
    }
}
