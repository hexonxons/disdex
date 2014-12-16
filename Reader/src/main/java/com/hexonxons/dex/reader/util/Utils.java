package com.hexonxons.dex.reader.util;

public class Utils
{
    private static final char[] sHexArray = "0123456789ABCDEF".toCharArray();

    public static String bytesToHex(byte[] bytes)
    {
        char[] hexChars = new char[bytes.length * 3];

        for(int j = 0; j < bytes.length; j++)
        {
            int v = bytes[j] & 0xFF;
            hexChars[j * 3] = sHexArray[v >>> 4];
            hexChars[j * 3 + 1] = sHexArray[v & 0x0F];
            hexChars[j * 3 + 2] = ' ';
        }
        return new String(hexChars);
    }
}
