package com.hexonxons.dex.reader.data;

import com.hexonxons.dex.reader.util.Size;
import com.hexonxons.dex.reader.exception.DexException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class FieldIdItem
{
    /**
     * Index into the {@link com.hexonxons.dex.reader.data.TypeIdItem} list for the definer of this field. <br/>
     * This must be a class type, and not an array or primitive type. <br/>
     * Base type is ushort. <br/>
     */
    public short classIdx   = Short.MIN_VALUE;

    /**
     * Index into the {@link com.hexonxons.dex.reader.data.TypeIdItem} list for the type of this field. <br/>
     * Base type is ushort. <br/>
     */
    public short typeIdx    = Short.MIN_VALUE;

    /**
     * Index into the {@link com.hexonxons.dex.reader.data.StringIdItem} list for the name of this field. <br/>
     * Base type is uint. <br/>
     */
    public int nameIdx      = Integer.MIN_VALUE;

    public FieldIdItem(RandomAccessFile raf, ByteOrder order) throws DexException, IOException
    {
        byte[] buffer = new byte[Size.USHORT];

        if(raf.read(buffer, 0, Size.USHORT) != Size.USHORT)
        {
            throw new DexException("Can't read field class index.");
        }

        classIdx = ByteBuffer.wrap(buffer).order(order).getShort();

        if(raf.read(buffer, 0, Size.USHORT) != Size.USHORT)
        {
            throw new DexException("Can't read field type index.");
        }

        typeIdx = ByteBuffer.wrap(buffer).order(order).getShort();

        buffer = new byte[Size.UINT];

        if(raf.read(buffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read field name.");
        }

        nameIdx = ByteBuffer.wrap(buffer).order(order).getInt();
    }
}
