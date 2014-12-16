package com.hexonxons.dex.reader.util;

public class Constant
{
    /**
     * Little-endian constant.
     */
    public static final byte[] LITTLE_ENDIAN    = new byte[]{(byte)0x78, (byte)0x56, (byte)0x34, (byte)0x12};

    /**
     * Big-endian constant.
     */
    public static final byte[] BIG_ENDIAN       = new byte[]{(byte)0x12, (byte)0x34, (byte)0x56, (byte)0x78};

    /**
     * The constant NO_INDEX is used to indicate that an index value is absent.
     * Note: This value isn't defined to be 0, because that is in fact typically a valid index.
     * Also Note: The chosen value for NO_INDEX is representable as a single byte in the uleb128p1 encoding.
     */
    public static final int NO_INDEX            = 0xffffffff;
}
