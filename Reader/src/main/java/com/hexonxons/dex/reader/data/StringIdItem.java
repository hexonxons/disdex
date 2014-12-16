package com.hexonxons.dex.reader.data;

import com.hexonxons.dex.reader.util.Size;
import com.hexonxons.dex.reader.exception.DexException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class StringIdItem
{
    /**
     * Offset from the start of the file to the string data for this item. <br/>
     * The data should be in the format specified by {@link com.hexonxons.dex.reader.data.StringDataItem} item. <br/>
     * Base type is uint. <br/>
     */
    public int stringDataOff    = Integer.MIN_VALUE;

    public StringIdItem(RandomAccessFile raf, ByteOrder order) throws DexException, IOException
    {
        byte[] buffer = new byte[Size.UINT];

        if(raf.read(buffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read string offset.");
        }

        stringDataOff = ByteBuffer.wrap(buffer).order(order).getInt();
    }
}
