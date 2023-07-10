package org.example.parse.util;

public class ByteToHexConverterUtil {

    public static void main(String[] args) {
        byte[] bytes = {0x12, 0x34, 0x56, (byte) 0xAB}; // 示例byte数组

        String result = byteArrayToHexString(bytes);
        System.out.println("Converted hex string: " + result);
    }

    public static String byteArrayToHexString(byte[] bytes) {
        StringBuilder hexString = new StringBuilder();

        for (byte b : bytes) {
            // 获取高四位的值
            int highNibble = (b & 0xF0) >>> 4;
            // 获取低四位的值
            int lowNibble = b & 0x0F;

            // 将高四位和低四位分别转换为对应的十六进制字符
            char highHexChar = nibbleToHexChar(highNibble);
            char lowHexChar = nibbleToHexChar(lowNibble);

            // 将两个字符追加到结果字符串
            hexString.append(highHexChar);
            hexString.append(lowHexChar);
        }

        return hexString.toString();
    }

    private static char nibbleToHexChar(int nibble) {
        if (nibble >= 0 && nibble <= 9) {
            return (char) ('0' + nibble); // 数字 0-9
        } else {
            return (char) ('A' + (nibble - 10)); // 字母 A-F
        }
    }

}
