package com.hexonxons.dex.reader.data;

public class AnnotationOffItem
{
    /**
     * Offset from the start of the file to an annotation. <br/>
     * The format of the data at that location is specified by {@link com.hexonxons.dex.reader.data.AnnotationItem}. <br/>
     * Base type is uint. <br/>
     */
    public int annotationOff    = Integer.MIN_VALUE;
}
