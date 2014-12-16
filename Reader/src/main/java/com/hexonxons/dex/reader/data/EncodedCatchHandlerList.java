package com.hexonxons.dex.reader.data;

public class EncodedCatchHandlerList
{
    /**
     * Size of this list, in entries. <br/>
     * Base type is uleb128. <br/>
     */
    public int size                 = Integer.MIN_VALUE;

    /**
     * Actual list of handler lists, represented directly (not as offsets), and concatenated sequentially. <br/>
     */
    public EncodedCatchHandler list = null;
}
