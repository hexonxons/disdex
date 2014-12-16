package com.hexonxons.dex.reader.data;

public class EncodedAnnotation
{
    /**
     * Type of the annotation. This must be a class (not array or primitive) type. <br/>
     * Base type is uleb128. <br/>
     */
    public int typeIdx  = Integer.MIN_VALUE;

    /**
     * Number of name-value mappings in this annotation. <br/>
     * Base type is uleb128. <br/>
     */
    public int size  = Integer.MIN_VALUE;

    /**
     * Elements of the annotataion, represented directly in-line (not as offsets). Elements must be sorted in increasing order by {@link com.hexonxons.dex.reader.data.AnnotationElement #nameIdx} index. <br/>
     */
    public AnnotationElement[] elements  = null;
}
