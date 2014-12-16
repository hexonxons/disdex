package com.hexonxons.dex.reader.data;

public class AnnotationSetRefItem
{
    /**
     * Offset from the start of the file to the referenced annotation set or 0 if there are no annotations for this element. <br/>
     * The format of the data is specified by {@link com.hexonxons.dex.reader.data.AnnotationSetItem}. <br/>
     */
    public int annotationsOff   = Integer.MIN_VALUE;
}
