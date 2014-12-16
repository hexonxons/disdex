package com.hexonxons.dex.reader.data;

import com.hexonxons.dex.reader.util.Size;
import com.hexonxons.dex.reader.exception.DexException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class MethodIdItem
{
    /**
     * Index into the {@link com.hexonxons.dex.reader.data.TypeIdItem} list for the definer of this method. <br/>
     * This must be a class or array type, and not a primitive type. <br/>
     * Base type is ushort. <br/>
     */
    public short classIdx   = Short.MIN_VALUE;

    /**
     * index into the {@link com.hexonxons.dex.reader.data.ProtoIdItem} list for the prototype of this method. <br/>
     * Base type is ushort. <br/>
     */
    public short protoIdx   = Short.MIN_VALUE;

    /**
     * Index into the {@link com.hexonxons.dex.reader.data.StringIdItem} list for the name of this method. <br/>
     * Base type is uint. <br/>
     */
    public int nameIdx      = Integer.MIN_VALUE;

    public MethodIdItem(RandomAccessFile raf, ByteOrder order) throws DexException, IOException
    {
        byte[] buffer = new byte[Size.USHORT];

        if(raf.read(buffer, 0, Size.USHORT) != Size.USHORT)
        {
            throw new DexException("Can't read method class index.");
        }

        classIdx = ByteBuffer.wrap(buffer).order(order).getShort();

        if(raf.read(buffer, 0, Size.USHORT) != Size.USHORT)
        {
            throw new DexException("Can't read method prototype index.");
        }

        protoIdx = ByteBuffer.wrap(buffer).order(order).getShort();

        buffer = new byte[Size.UINT];

        if(raf.read(buffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read method name.");
        }

        nameIdx = ByteBuffer.wrap(buffer).order(order).getInt();
    }
}
