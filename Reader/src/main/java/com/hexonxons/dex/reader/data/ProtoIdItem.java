package com.hexonxons.dex.reader.data;

public class ProtoIdItem
{
    /**
     * Index into the {@link com.hexonxons.dex.reader.data.StringIdItem} list for the short-form descriptor string of this prototype. <br/>
     * Base type is uint. <br/>
     */
    public int shortyIdx        = Integer.MIN_VALUE;

    /**
     * Index into the {@link com.hexonxons.dex.reader.data.TypeIdItem} list for the return type of this prototype. <br/>
     * Base type is uint. <br/>
     */
    public int returnTypeIdx    = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the list of parameter types for this prototype, or 0 if this prototype has no parameters. <br/>
     * The data there should be in the format specified by {@link com.hexonxons.dex.reader.data.TypeList}. <br/>
     * Additionally, there should be no reference to the type void in the list. <br/>
     * Base type is uint. <br/>
     */
    public int parametersOff    = Integer.MIN_VALUE;
}
