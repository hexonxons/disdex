package com.hexonxons.dex.reader.data;

public class ClassDefItem
{
    /**
     * Index into the {@link com.hexonxons.dex.reader.data.TypeIdItem} list for this class. <br/>
     * This must be a class type, and not an array or primitive type. <br/>
     * Base type is uint. <br/>
     */
    public int classIdx         = Integer.MIN_VALUE;

    /**
     * Access flags for the class (public, final, etc.). See {@link com.hexonxons.dex.reader.data.AccessFlags} for details. <br/>
     * Base type is uint. <br/>
     */
    public int accessFlags      = Integer.MIN_VALUE;

    /**
     * Index into the {@link com.hexonxons.dex.reader.data.TypeIdItem} list for the superclass,
     * or the constant value NO_INDEX if this class has no superclass (i.e., it is a root class such as Object). <br/>
     * If present, this must be a class type, and not an array or primitive type. <br/>
     * Base type is uint. <br/>
     */
    public int superclassIdx    = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the list of interfaces, or 0 if there are none. <br/>
     * The data there should be in the format specified by {@link com.hexonxons.dex.reader.data.TypeList}. <br/>
     * Each of the elements of the list must be a class type (not an array or primitive type), and there must not be any duplicates. <br/>
     * Base type is uint. <br/>
     */
    public int interfacesOff    = Integer.MIN_VALUE;

    /**
     * Index into the string_ids list for the name of the file containing the original source for (at least most of) this class,
     * or the special value NO_INDEX to represent a lack of this information. <br/>
     * The {@link com.hexonxons.dex.reader.data.DebugInfoItem} of any given method may override this source file,
     * but the expectation is that most classes will only come from one source file. <br/>
     * Base type is uint.
     */
    public int sourceFileIdx    = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the annotations structure for this class, or 0 if there are no annotations on this class. <br/>
     * The data there should be in the format specified by {@link com.hexonxons.dex.reader.data.AnnotationsDirectoryItem},
     * with all items referring to this class as the definer. <br/>
     * Base type is uint. <br/>
     */
    public int annotationsOff   = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the associated class data for this item, or 0 if there is no class data for this class.
     * (This may be the case, for example, if this class is a marker interface.) <br/>
     * The data there should be in the format specified by {@link com.hexonxons.dex.reader.data.ClassDataItem},
     * with all items referring to this class as the definer. <br/>
     * Base type is uint. <br/>
     */
    public int classDataOff     = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the list of initial values for static fields, or 0 if there are none (and all static fields are to be initialized with 0 or null). <br/>
     * The data there should be in the format specified by {@link EncodedArray}. <br/>
     * The size of the array must be no larger than the number of static fields declared by this class, and the elements correspond to the static fields in the same order as declared in the corresponding {@link com.hexonxons.dex.reader.data.FieldIdItem} list. <br/>
     * The type of each array element must match the declared type of its corresponding field. If there are fewer elements in the array than there are static fields, then the leftover fields are initialized with a type-appropriate 0 or null. <br/>
     * Base type is uint. <br/>
     */
    public int staticValuesOff  = Integer.MIN_VALUE;
}
