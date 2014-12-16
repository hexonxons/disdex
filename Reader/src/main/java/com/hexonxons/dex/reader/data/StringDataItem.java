package com.hexonxons.dex.reader.data;

import com.hexonxons.dex.reader.util.Utils;
import com.hexonxons.dex.reader.exception.DexException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;

public class StringDataItem
{
    /**
     * Size of this string, in UTF-16 code units (which is the "string length" in many systems). <br/>
     * That is, this is the decoded length of the string. (The encoded length is implied by the position of the 0 byte.) <br/>
     * Base type is uleb128. <br/>
     */
    public int utf16Size    = Integer.MIN_VALUE;

    /**
     * A series of MUTF-8 code units (a.k.a. octets, a.k.a. bytes) followed by a byte of value 0.
     * Note: It is acceptable to have a string which includes (the encoded form of) UTF-16 surrogate code units (that is, U+d800 … U+dfff) either in isolation or out-of-order with respect to the usual encoding of Unicode into UTF-16.
     * It is up to higher-level uses of strings to reject such invalid encodings, if appropriate. <br/>
     * Base type is ubyte[]. <br/>
     */
    public String data      = null;

    public StringDataItem(RandomAccessFile raf, ByteOrder order) throws DexException, IOException
    {
        utf16Size = Utils.readUleb128(raf);
        data = raf.readUTF();
    }
}
