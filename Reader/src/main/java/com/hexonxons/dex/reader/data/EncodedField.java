package com.hexonxons.dex.reader.data;

import com.hexonxons.dex.reader.util.Utils;
import com.hexonxons.dex.reader.exception.DexException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;

public class EncodedField
{
    /**
     * Index into the {@link com.hexonxons.dex.reader.data.FieldIdItem} list for the identity of this field (includes the name and descriptor), represented as a difference from the index of previous element in the list. <br/>
     * The index of the first element in a list is represented directly. <br/>
     * Base type is uleb128. <br/>
     */
    public int fieldIdxDiff = Integer.MIN_VALUE;

    /**
     * Access flags for the field (public, final, etc.). See {@link com.hexonxons.dex.reader.data.AccessFlags} for details. <br/>
     * Base type is uleb128. <br/>
     */
    public int accessFlags  = Integer.MIN_VALUE;

    public EncodedField(RandomAccessFile raf, ByteOrder order) throws DexException, IOException
    {
        fieldIdxDiff = Utils.readUleb128(raf);
        accessFlags = Utils.readUleb128(raf);
    }
}
