package com.hexonxons.dex.reader.data;

public class Visibility
{
    /**
     * Intended only to be visible at build time (e.g., during compilation of other code). <br/>
     */
    public byte BUILD   = 0x00;

    /**
     * Intended to visible at runtime. <br/>
     */
    public byte RUNTIME = 0x01;

    /**
     * Intended to visible at runtime, but only to the underlying system (and not to regular user code). <br/>
     */
    public byte SYSTEM  = 0x02;
}
