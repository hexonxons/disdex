package com.hexonxons.dex.reader.data;

import com.hexonxons.dex.reader.util.Size;
import com.hexonxons.dex.reader.exception.DexException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class TypeIdItem
{
    /**
     * Index into the {@link com.hexonxons.dex.reader.data.StringIdItem} list for the descriptor string of this type. <br/>
     * Base type is uint. <br/>
     */
    public int descriptorIdx    = Integer.MIN_VALUE;
}
