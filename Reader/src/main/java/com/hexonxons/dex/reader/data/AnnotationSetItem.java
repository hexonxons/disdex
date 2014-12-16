package com.hexonxons.dex.reader.data;

public class AnnotationSetItem
{
    /**
     * Size of the set, in entries. <br/>
     * Base type is uint. <br/>
     */
    public int size                     = Integer.MIN_VALUE;

    /**
     * Elements of the set. The elements must be sorted in increasing order, by {@link com.hexonxons.dex.reader.data.EncodedAnnotation#typeIdx}. <br/>
     */
    public AnnotationOffItem entries    = null;
}
