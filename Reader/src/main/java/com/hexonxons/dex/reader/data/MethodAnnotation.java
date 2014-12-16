package com.hexonxons.dex.reader.data;

public class MethodAnnotation
{
    /**
     * Index into the {@link com.hexonxons.dex.reader.data.MethodIdItem} list for the identity of the method being annotated. <br/>
     * Base type is uint. <br/>
     */
    public int methodIdx         = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the list of annotations for the method. <br/>
     * The format of the data is specified by {@link com.hexonxons.dex.reader.data.AnnotationSetItem}. <br/>
     * Base type is uint. <br/>
     */
    public int annotationsOff   = Integer.MIN_VALUE;
}
