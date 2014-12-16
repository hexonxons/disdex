package com.hexonxons.dex.reader.data;

public class AnnotationItem
{
    /**
     * Intended visibility of this annotation. See {@link com.hexonxons.dex.reader.data.Visibility}. <br/>
     * Base type is ubyte. <br/>
     */
    public byte visibility              = Byte.MIN_VALUE;

    /**
     * Encoded annotation contents, in the format described by {@link com.hexonxons.dex.reader.data.EncodedAnnotation}. <br/>
     */
    public EncodedAnnotation annotation = null;
}
