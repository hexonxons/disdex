package com.hexonxons.dex.reader.data;

public class TryItem
{
    /**
     * Start address of the block of code covered by this entry. <br/>
     * The address is a count of 16-bit code units to the start of the first covered instruction. <br/>
     * Base type is uint. <br/>
     */
    public int startAddr    = Integer.MIN_VALUE;

    /**
     * Number of 16-bit code units covered by this entry. The last code unit covered (inclusive) is {@link #startAddr} + {@link #insnCount} - 1. <br/>
     * Base type is ushort. <br/>
     */
    public short insnCount  = Short.MIN_VALUE;

    /**
     * Offset in bytes from the start of the associated {@link com.hexonxons.dex.reader.data.EncodedCatchHandlerList} to the {@link com.hexonxons.dex.reader.data.EncodedCatchHandler} for this entry. <br/>
     * This must be an offset to the start of an {@link com.hexonxons.dex.reader.data.EncodedCatchHandler}. <br/>
     * Base type is ushort. <br/>
     */
    public short handlerOff = Short.MIN_VALUE;
}
