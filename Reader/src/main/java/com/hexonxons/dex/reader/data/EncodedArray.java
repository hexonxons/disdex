package com.hexonxons.dex.reader.data;

public class EncodedArray
{
    /**
     * Number of elements in the array. <br/>
     * Base type is uleb128. <br/>
     */
    public int size                 = Integer.MIN_VALUE;

    /**
     * A series of size {@link com.hexonxons.dex.reader.data.EncodedValue} byte sequences, concatenated sequentially. <br/>
     */
    public EncodedValue[] values    = null;
}
