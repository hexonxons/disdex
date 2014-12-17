package com.hexonxons.dex.reader.data;

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
}
