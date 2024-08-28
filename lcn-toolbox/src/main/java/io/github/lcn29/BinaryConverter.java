package io.github.lcn29;

/**
 * 二进制和十进制转换
 *
 * @author canxin.li
 * @date 2024-08-28 09:37:23
 */
public class BinaryConverter {

    private final static int MAX_BINARY = 32;

    private final static int BINARY_STEP = 8;

    private final static String EMPTY_SPACE = " ";

    public static void main(String[] args) {
        int number = 123456;
        String binaryString = "00000000 00000000 00000001 11000000";
    }

    /**
     * 将整数转换为二进制字符串
     *
     * @param number 整数
     * @return 二进制字符串
     */
    private static String intToBinaryString(int number) {
        // 32 位二进制字符串
        String binaryString = String.format("%32s", Integer.toBinaryString(number))
            .replace(' ', '0');
        // 每 8 位二进制字符串之间加一个空格, 会导致字符串长度增加 4, 同时最后一位是一个空格
        StringBuilder formattedBinary = new StringBuilder();
        for (int i = 0; i < MAX_BINARY; i += BINARY_STEP) {
            formattedBinary.append(binaryString, i, i + BINARY_STEP).append(EMPTY_SPACE);
        }
        // 去除最后一个空格
        return formattedBinary.toString().trim();
    }

    /**
     * 将二进制字符串转换为整数
     *
     * @param binaryString 二进制字符串
     * @return 整数
     */
    private static int binaryStringToInt(String binaryString) {
        return Integer.parseInt(binaryString.replaceAll(EMPTY_SPACE, ""), 2);
    }


}
