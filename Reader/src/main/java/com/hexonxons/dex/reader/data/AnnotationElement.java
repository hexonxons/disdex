package com.hexonxons.dex.reader.data;

public class AnnotationElement
{
    /**
     * Element name, represented as an index into the {@link com.hexonxons.dex.reader.data.StringIdItem} list. <br/>
     * Base type is uleb128. <br/>
     */
    public int nameIdx          = Integer.MIN_VALUE;

    /**
     * Element value. <br/>
     */
    public EncodedValue value   = null;
}
