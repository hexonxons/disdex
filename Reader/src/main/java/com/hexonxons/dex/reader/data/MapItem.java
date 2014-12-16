package com.hexonxons.dex.reader.data;

public class MapItem
{
    /**
     * Type of the items. See {@link com.hexonxons.dex.reader.data.TypeCode} <br/>
     * Base type is ushort. <br/>
     */
    public short type   = Short.MIN_VALUE;

    /**
     * Unused.
     * Base type is ushort. <br/>
     */
    public short unused = Short.MIN_VALUE;

    /**
     * Count of the number of items to be found at the indicated offset. <br/>
     * Base type is uint. <br/>
     */
    public int size     = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the items in question. <br/>
     * Base type is uint. <br/>
     */
    public int offset   = Integer.MIN_VALUE;
}
