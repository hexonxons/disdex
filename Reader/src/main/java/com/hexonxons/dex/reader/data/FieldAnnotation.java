package com.hexonxons.dex.reader.data;

public class FieldAnnotation
{
    /**
     * Index into the {@link com.hexonxons.dex.reader.data.FieldIdItem} list for the identity of the field being annotated. <br/>
     * Base type is uint. <br/>
     */
    public int fieldIdx         = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the list of annotations for the field. <br/>
     * The format of the data is specified by {@link com.hexonxons.dex.reader.data.AnnotationSetItem}. <br/>
     * Base type is uint. <br/>
     */
    public int annotationsOff   = Integer.MIN_VALUE;
}
