package com.hexonxons.dex.reader.data;

/**
 * An EncodedValue is an encoded piece of (nearly) arbitrary hierarchically structured data. The encoding is meant to be both compact and straightforward to parse.
 */
public class EncodedValue
{
    /**
     * Byte indicating the type of the immediately subsequent value along with an optional clarifying argument in the high-order three bits. <br/>
     * See {@link com.hexonxons.dex.reader.data.Value} for the various value definitions. <br/>
     * In most cases, value argument encodes the length of the immediately-subsequent value in bytes, as (size - 1), e.g., 0 means that the value requires one byte, and 7 means it requires eight bytes; however, there are exceptions. <br/>
     * Base type: ubyte. <br/>
     */
    public byte type    = Byte.MIN_VALUE;

    /**
     * Bytes representing the value, variable in length and interpreted differently for different {@link com.hexonxons.dex.reader.data.Value} bytes, though always little-endian. <br/>
     * Base type: ubyte[]. <br/>
     */
    public byte[] value = null;
}
