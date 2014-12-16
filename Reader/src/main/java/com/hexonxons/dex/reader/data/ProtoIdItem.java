package com.hexonxons.dex.reader.data;

import com.hexonxons.dex.reader.util.Size;
import com.hexonxons.dex.reader.exception.DexException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ProtoIdItem
{
    /**
     * Index into the {@link com.hexonxons.dex.reader.data.StringIdItem} list for the short-form descriptor string of this prototype. <br/>
     * Base type is uint. <br/>
     */
    public int shortyIdx        = Integer.MIN_VALUE;

    /**
     * Index into the {@link com.hexonxons.dex.reader.data.TypeIdItem} list for the return type of this prototype. <br/>
     * Base type is uint. <br/>
     */
    public int returnTypeIdx    = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the list of parameter types for this prototype, or 0 if this prototype has no parameters. <br/>
     * The data there should be in the format specified by {@link com.hexonxons.dex.reader.data.TypeList}. <br/>
     * Additionally, there should be no reference to the type void in the list. <br/>
     * Base type is uint. <br/>
     */
    public int parametersOff    = Integer.MIN_VALUE;

    public ProtoIdItem(RandomAccessFile raf, ByteOrder order) throws DexException, IOException
    {
        byte[] buffer = new byte[Size.UINT];

        if(raf.read(buffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read proto item index.");
        }

        shortyIdx = ByteBuffer.wrap(buffer).order(order).getInt();

        if(raf.read(buffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read proto item return type.");
        }

        returnTypeIdx = ByteBuffer.wrap(buffer).order(order).getInt();

        if(raf.read(buffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read proto item parameters offset.");
        }

        parametersOff = ByteBuffer.wrap(buffer).order(order).getInt();
    }
}
