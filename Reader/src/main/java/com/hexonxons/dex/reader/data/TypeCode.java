package com.hexonxons.dex.reader.data;

public class TypeCode
{
    /**
     * {@link com.hexonxons.dex.reader.data.HeaderItem} <br/>
     * Value: 0x0000 <br/>
     * Item size in bytes: 0x70 <br/>
     */
    public short HEADER_ITEM                = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.StringIdItem} <br/>
     * Value: 0x0001 <br/>
     * Item size in bytes: 0x04 <br/>
     */
    public short STRING_ID_ITEM             = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.TypeIdItem} <br/>
     * Value: 0x0002 <br/>
     * Item size in bytes: 0x04 <br/>
     */
    public short TYPE_ID_ITEM               = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.ProtoIdItem} <br/>
     * Value: 0x0003 <br/>
     * Item size in bytes: 0x0C <br/>
     */
    public short PROTO_ID_ITEM              = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.FieldIdItem} <br/>
     * Value: 0x0004 <br/>
     * Item size in bytes: 0x08 <br/>
     */
    public short FIELD_ID_ITEM              = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.MethodIdItem} <br/>
     * Value: 0x0005 <br/>
     * Item size in bytes: 0x08 <br/>
     */
    public short METHOD_ID_ITEM             = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.ClassDefItem} <br/>
     * Value: 0x0006 <br/>
     * Item size in bytes: 0x20 <br/>
     */
    public short CLASS_DEF_ITEM             = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.MapList} <br/>
     * Value: 0x1000 <br/>
     * Item size in bytes: 4 + ({@link com.hexonxons.dex.reader.data.MapList#size} * 12) <br/>
     */
    public short MAP_LIST                   = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.TypeList} <br/>
     * Value: 0x1001 <br/>
     * Item size in bytes: 4 + ({@link com.hexonxons.dex.reader.data.TypeList#size} * 12) <br/>
     */
    public short TYPE_LIST                  = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.AnnotationSetRefList} <br/>
     * Value: 0x1002 <br/>
     * Item size in bytes: 4 + ({@link com.hexonxons.dex.reader.data.AnnotationSetRefList#size} * 4) <br/>
     */
    public short ANNOTATION_SET_REF_LIST    = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.AnnotationSetItem} <br/>
     * Value: 0x1003 <br/>
     * Item size in bytes: 4 + ({@link com.hexonxons.dex.reader.data.AnnotationSetItem#size} * 4) <br/>
     */
    public short ANNOTATION_SET_ITEM        = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.ClassDataItem} <br/>
     * Value: 0x2000 <br/>
     * Item size in bytes: implicit; must parse <br/>
     */
    public short CLASS_DATA_ITEM            = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.CodeItem} <br/>
     * Value: 0x2001 <br/>
     * Item size in bytes: implicit; must parse <br/>
     */
    public short CODE_ITEM                  = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.StringDataItem} <br/>
     * Value: 0x2002 <br/>
     * Item size in bytes: implicit; must parse <br/>
     */
    public short STRING_DATA_ITEM           = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.DebugInfoItem} <br/>
     * Value: 0x2003 <br/>
     * Item size in bytes: implicit; must parse <br/>
     */
    public short DEBUG_INFO_ITEM            = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.AnnotationItem} <br/>
     * Value: 0x2004 <br/>
     * Item size in bytes: implicit; must parse <br/>
     */
    public short ANNOTATION_ITEM            = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.EncodedArray} <br/>
     * Value: 0x2005 <br/>
     * Item size in bytes: implicit; must parse <br/>
     */
    public short ENCODED_ARRAY_ITEM         = Short.MIN_VALUE;

    /**
     * {@link com.hexonxons.dex.reader.data.AnnotationsDirectoryItem} <br/>
     * Value: 0x2006 <br/>
     * Item size in bytes: implicit; must parse <br/>
     */
    public short ANNOTATIONS_DIRECTORY_ITEM = Short.MIN_VALUE;
}
