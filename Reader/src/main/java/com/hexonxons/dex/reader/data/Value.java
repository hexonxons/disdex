package com.hexonxons.dex.reader.data;

public class Value
{
    /**
     * Signed one-byte integer value. <br/>
     * Value argument: (none; must be 0) <br/>
     * Value format: ubyte[1] <br/>
     */
    public byte BYTE        = 0x00;

    /**
     * Signed two-byte integer value, sign-extended. <br/>
     * Value argument: size - 1 (0…1) <br/>
     * Value format: ubyte[size] <br/>
     */
    public byte SHORT       = 0x02;

    /**
     * Unsigned two-byte integer value, zero-extended. <br/>
     * Value argument: size - 1 (0…1) <br/>
     * Value format: ubyte[size] <br/>
     */
    public byte CHAR        = 0x03;

    /**
     * Signed four-byte integer value, sign-extended. <br/>
     * Value argument: size - 1 (0…3) <br/>
     * Value format: ubyte[size] <br/>
     */
    public byte INT         = 0x04;

    /**
     * Signed eight-byte integer value, sign-extended. <br/>
     * Value argument: size - 1 (0…7) <br/>
     * Value format: ubyte[size] <br/>
     */
    public byte LONG        = 0x06;

    /**
     * Four-byte bit pattern, zero-extended to the right, and interpreted as an IEEE754 32-bit floating point value. <br/>
     * Value argument: size - 1 (0…3) <br/>
     * Value format: ubyte[size] <br/>
     */
    public byte FLOAT       = 0x10;

    /**
     * Eight-byte bit pattern, zero-extended to the right, and interpreted as an IEEE754 64-bit floating point value. <br/>
     * Value argument: size - 1 (0…7) <br/>
     * Value format: ubyte[size] <br/>
     */
    public byte DOUBLE      = 0x11;

    /**
     * Unsigned (zero-extended) four-byte integer value, interpreted as an index into the {@link com.hexonxons.dex.reader.data.StringIdItem} list section and representing a string value. <br/>
     * Value argument: size - 1 (0…3) <br/>
     * Value format: ubyte[size] <br/>
     */
    public byte STRING      = 0x17;

    /**
     * Unsigned (zero-extended) four-byte integer value, interpreted as an index into the {@link com.hexonxons.dex.reader.data.TypeIdItem} list section and representing a reflective type/class value. <br/>
     * Value argument: size - 1 (0…3) <br/>
     * Value format: ubyte[size] <br/>
     */
    public byte TYPE        = 0x18;

    /**
     * Unsigned (zero-extended) four-byte integer value, interpreted as an index into the {@link com.hexonxons.dex.reader.data.FieldIdItem} list section and representing a reflective field value. <br/>
     * Value argument: size - 1 (0…3) <br/>
     * Value format: ubyte[size] <br/>
     */
    public byte FIELD       = 0x19;

    /**
     * Unsigned (zero-extended) four-byte integer value, interpreted as an index into the {@link com.hexonxons.dex.reader.data.MethodIdItem} list section and representing a reflective method value. <br/>
     * Value argument: size - 1 (0…3) <br/>
     * Value format: ubyte[size] <br/>
     */
    public byte METHOD      = 0x1a;

    /**
     * Unsigned (zero-extended) four-byte integer value, interpreted as an index into the {@link com.hexonxons.dex.reader.data.FieldIdItem} list section and representing the value of an enumerated type constant. <br/>
     * Value argument: size - 1 (0…3) <br/>
     * Value format: ubyte[size] <br/>
     */
    public byte ENUM        = 0x1b;

    /**
     * An array of values, in the format specified by {@link EncodedArray}. The size of the value is implicit in the encoding. <br/>
     * Value argument: (none; must be 0) <br/>
     * Value format: {@link EncodedArray} <br/>
     */
    public byte ARRAY       = 0x1c;

    /**
     * A sub-annotation, in the format specified by {@link com.hexonxons.dex.reader.data.EncodedAnnotation}. The size of the value is implicit in the encoding. <br/>
     * Value argument: (none; must be 0) <br/>
     * Value format: {@link com.hexonxons.dex.reader.data.EncodedAnnotation} <br/>
     */
    public byte ANNOTATION  = 0x1d;

    /**
     * <code>null</code> reference value. <br/>
     * Value argument: (none; must be 0) <br/>
     * Value format: (none) <br/>
     */
    public byte NULL        = 0x1e;

    /**
     * One-bit value; 0 for false and 1 for true. The bit is represented in the value_arg. <br/>
     * Value argument: (none; must be 0) <br/>
     * Value format: (none) <br/>
     */
    public byte BOOLEAN     = 0x1f;
}
