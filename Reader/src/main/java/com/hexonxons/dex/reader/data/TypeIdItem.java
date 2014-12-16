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

    public TypeIdItem(RandomAccessFile raf, ByteOrder order) throws DexException, IOException
    {
        byte[] buffer = new byte[Size.UINT];

        if(raf.read(buffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read type descriptor index.");
        }

        descriptorIdx = ByteBuffer.wrap(buffer).order(order).getInt();
    }
}
