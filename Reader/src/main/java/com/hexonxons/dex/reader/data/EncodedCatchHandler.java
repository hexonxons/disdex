package com.hexonxons.dex.reader.data;

public class EncodedCatchHandler
{
    /**
     * Number of catch types in this list. If non-positive, then this is the negative of the number of catch types, and the catches are followed by a catch-all handler. <br/>
     * For example: A size of 0 means that there is a catch-all but no explicitly typed catches. <br/>
     * A size of 2 means that there are two explicitly typed catches and no catch-all. <br/>
     * And a size of -1 means that there is one typed catch along with a catch-all. <br/>
     * Base type is sleb128. <br/>
     */
    public int size                     = Integer.MIN_VALUE;

    /**
     * Stream of abs(size) encoded items, one for each caught type, in the order that the types should be tested. <br/>
     */
    public EncodedTypeAddrPair handlers = null;

    /**
     * Optional. Bytecode address of the catch-all handler. This element is only present if size is non-positive. <br/>
     * Base type is uleb128. <br/>
     */
    public int catchAllAddr             = Integer.MIN_VALUE;
}
