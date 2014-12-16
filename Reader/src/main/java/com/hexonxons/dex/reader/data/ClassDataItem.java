package com.hexonxons.dex.reader.data;

import com.hexonxons.dex.reader.util.Size;
import com.hexonxons.dex.reader.exception.DexException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class ClassDataItem
{
    /**
     * The number of static fields defined in this item. <br/>
     * Base type is uleb128. <br/>
     */
    public int staticFieldsSize             = Integer.MIN_VALUE;

    /**
     * The number of instance fields defined in this item. <br/>
     * Base type is uleb128. <br/>
     */
    public int instanceFieldsSize           = Integer.MIN_VALUE;

    /**
     * The number of direct methods defined in this item. <br/>
     * Base type is uleb128. <br/>
     */
    public int directMethodsSize            = Integer.MIN_VALUE;

    /**
     * The number of virtual methods defined in this item. <br/>
     * Base type is uleb128. <br/>
     */
    public int virtualMethodsSize           = Integer.MIN_VALUE;

    /**
     * The defined static fields, represented as a sequence of encoded elements. <br/>
     * The fields must be sorted by {@link com.hexonxons.dex.reader.data.EncodedField #fieldIdxDiff} in increasing order. <br/>
     */
    public EncodedField[] staticFields      = null;

    /**
     * The defined instance fields, represented as a sequence of encoded elements. <br/>
     * The fields must be sorted by {@link com.hexonxons.dex.reader.data.EncodedField #fieldIdxDiff} in increasing order. <br/>
     */
    public EncodedField[] instanceFields    = null;

    /**
     * The defined direct (any of static, private, or constructor) methods, represented as a sequence of encoded elements. <br/>
     * The methods must be sorted by {@link com.hexonxons.dex.reader.data.EncodedMethod #methodIdxDiff} in increasing order. <br/>
     */
    public EncodedMethod[] directMethods     = null;

    /**
     * The defined virtual (none of static, private, or constructor) methods, represented as a sequence of encoded elements. <br/>
     * This list should not include inherited methods unless overridden by the class that this item represents. <br/>
     * The methods must be sorted by {@link com.hexonxons.dex.reader.data.EncodedMethod #methodIdxDiff} in increasing order. <br/>
     */
    public EncodedMethod[] virtualMethods    = null;

    public ClassDataItem(RandomAccessFile raf, ByteOrder order) throws DexException, IOException
    {
        byte[] buffer = new byte[Size.UINT];

        if(raf.read(buffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read class data static field size.");
        }

        staticFieldsSize = ByteBuffer.wrap(buffer).order(order).getInt();

        if(raf.read(buffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read class data instance fields size.");
        }

        instanceFieldsSize = ByteBuffer.wrap(buffer).order(order).getInt();

        if(raf.read(buffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read class data direct methods size.");
        }

        directMethodsSize = ByteBuffer.wrap(buffer).order(order).getInt();

        if(raf.read(buffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read class data virtual methods size.");
        }

        virtualMethodsSize = ByteBuffer.wrap(buffer).order(order).getInt();

        staticFields = new EncodedField[staticFieldsSize];
        for(int i = 0; i < staticFieldsSize; ++i)
        {
            staticFields[i] = new EncodedField(raf, order);
        }

        instanceFields = new EncodedField[staticFieldsSize];
        for(int i = 0; i < instanceFieldsSize; ++i)
        {
            instanceFields[i] = new EncodedField(raf, order);
        }

        directMethods = new EncodedMethod[directMethodsSize];
        for(int i = 0; i < directMethodsSize; ++i)
        {
            directMethods[i] = new EncodedMethod(raf, order);
        }

        virtualMethods = new EncodedMethod[virtualMethodsSize];
        for(int i = 0; i < virtualMethodsSize; ++i)
        {
            virtualMethods[i] = new EncodedMethod(raf, order);
        }
    }
}
