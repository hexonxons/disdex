package com.hexonxons.dex.reader.data;

public class AnnotationsDirectoryItem
{
    /**
     * Offset from the start of the file to the annotations made directly on the class, or 0 if the class has no direct annotations. <br/>
     * The format of the data is specified by {@link com.hexonxons.dex.reader.data.AnnotationSetItem}. <br/>
     * Base type is uint. <br/>
     */
    public int classAnnotationsOff                      = Integer.MIN_VALUE;

    /**
     * Count of fields annotated by this item. <br/>
     * Base type is uint. <br/>
     */
    public int fieldsSize                               = Integer.MIN_VALUE;

    /**
     * Count of methods annotated by this item. <br/>
     * Base type is uint. <br/>
     */
    public int annotatedMethodsSize                     = Integer.MIN_VALUE;

    /**
     * Count of method parameter lists annotated by this item. <br/>
     * Base type is uint. <br/>
     */
    public int annotatedParametersSize                  = Integer.MIN_VALUE;

    /**
     * List of associated field annotations. <br/>
     * The elements of the list must be sorted in increasing order, by {@link com.hexonxons.dex.reader.data.FieldAnnotation #fieldIdx}. <br/>
     */
    public FieldAnnotation[] fieldAnnotation            = null;

    /**
     * List of associated method annotations. <br/>
     * The elements of the list must be sorted in increasing order, by {@link com.hexonxons.dex.reader.data.MethodAnnotation #methodIdx}. <br/>
     */
    public MethodAnnotation[] methodAnnotation          = null;

    /**
     * List of associated method parameter annotations. <br/>
     * The elements of the list must be sorted in increasing order, by {@link com.hexonxons.dex.reader.data.ParameterAnnotation #methodIdx}. <br/>
     */
    public ParameterAnnotation[] parameterAnnotation    = null;
}
