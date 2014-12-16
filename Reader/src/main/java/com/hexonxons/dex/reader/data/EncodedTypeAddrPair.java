package com.hexonxons.dex.reader.data;

public class EncodedTypeAddrPair
{
    /**
     * Index into the {@link com.hexonxons.dex.reader.data.TypeIdItem} list for the type of the exception to catch. <br/>
     * Base type is uleb128. <br/>
     */
    public int typeIdx  = Integer.MIN_VALUE;

    /**
     * Bytecode address of the associated exception handler. <br/>
     * Base type is uleb128. <br/>
     */
    public int addr     = Integer.MIN_VALUE;
}
