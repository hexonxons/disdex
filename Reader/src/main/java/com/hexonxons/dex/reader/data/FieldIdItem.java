package com.hexonxons.dex.reader.data;

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
}
