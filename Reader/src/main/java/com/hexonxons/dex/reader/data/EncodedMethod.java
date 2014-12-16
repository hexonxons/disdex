package com.hexonxons.dex.reader.data;

import com.hexonxons.dex.reader.util.Utils;
import com.hexonxons.dex.reader.exception.DexException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;

public class EncodedMethod
{
    /**
     * Index into the {@link com.hexonxons.dex.reader.data.MethodIdItem} list for the identity of this method (includes the name and descriptor), represented as a difference from the index of previous element in the list. <br/>
     * The index of the first element in a list is represented directly. <br/>
     * Base type is uleb128. <br/>
     */
    public int methodIdxDiff = Integer.MIN_VALUE;

    /**
     * Access flags for the method (public, final, etc.). See {@link com.hexonxons.dex.reader.data.AccessFlags}. <br/>
     * Base type is uleb128. <br/>
     */
    public int accessFlags  = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the code structure for this method, or 0 if this method is either abstract or native. <br/>
     * The offset should be to a location in the data section. The format of the data is specified by {@link com.hexonxons.dex.reader.data.CodeItem}. <br/>
     * Base type is uleb128. <br/>
     */
    public int codeOff  = Integer.MIN_VALUE;

    public EncodedMethod(RandomAccessFile raf, ByteOrder order) throws DexException, IOException
    {
        methodIdxDiff = Utils.readUleb128(raf);
        accessFlags = Utils.readUleb128(raf);
        codeOff = Utils.readUleb128(raf);
    }
}
