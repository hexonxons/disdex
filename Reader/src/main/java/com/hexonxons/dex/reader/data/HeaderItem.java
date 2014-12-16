package com.hexonxons.dex.reader.data;

/**
 * Header structure.
 */
public class HeaderItem
{
    /**
     * Magic value. <br/>
     * Base type is ubyte[8]. <br/>
     */
    public byte[] magic         = null;

    /**
     * adler32 checksum of the rest of the file (everything but magic and this field); used to detect file corruption. <br/>
     * Base type is uint. <br/>
     */
    public int checksum         = Integer.MIN_VALUE;

    /**
     * SHA-1 signature (hash) of the rest of the file (everything but magic, checksum, and this field); used to uniquely identify files. <br/>
     * Base type is ubyte[20]. <br/>
     */
    public byte[] signature     = null;

    /**
     * Size of the entire file (including the header), in bytes. <br/>
     * Base type is uint. <br/>
     */
    public int fileSize         = Integer.MIN_VALUE;

    /**
     * Size of the header (this entire section), in bytes. <br/>
     * This allows for at least a limited amount of backwards/forwards compatibility without invalidating the format. <br/>
     * Base type is uint. 0x70 <br/>
     */
    public int headerSize       = Integer.MIN_VALUE;

    /**
     * Endianness tag. See {@link com.hexonxons.dex.reader.util.Constant#LITTLE_ENDIAN} and {@link com.hexonxons.dex.reader.util.Constant#BIG_ENDIAN}.
     * Base type is uint. <br/>
     */
    public int endianTag        = Integer.MIN_VALUE;

    /**
     * Size of the link section, or 0 if this file isn't statically linked <br/>
     * Base type is uint. <br/>
     */
    public int linkSize         = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the link section, or 0 if {@link #linkSize} == 0. <br/>
     * The format of the data pointed at is left unspecified; this header field (and the previous) are left as hooks for use by runtime implementations. <br/>
     * Base type is uint. <br/>
     */
    public int linkOff          = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the map item, or 0 if this file has no map. <br/>
     * The data should be in the format specified by {@link com.hexonxons.dex.reader.data.MapList}. <br/>
     * Base type is uint. <br/>
     */
    public int mapOff           = Integer.MIN_VALUE;

    /**
     * Count of strings in the string identifiers list. <br/>
     * Base type is uint. <br/>
     */
    public int stringIdsSize    = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the string identifiers list, or 0 if {@link #stringIdsSize} == 0 (admittedly a strange edge case). <br/>
     * Base type is uint. <br/>
     */
    public int stringIdsOff     = Integer.MIN_VALUE;

    /**
     * Count of elements in the type identifiers list. <br/>
     * Base type is uint. <br/>
     */
    public int typeIdsSize      = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the type identifiers list, or 0 if {@link #typeIdsSize} == 0 (admittedly a strange edge case). <br/>
     * Base type is uint. <br/>
     */
    public int typeIdsOff       = Integer.MIN_VALUE;

    /**
     * Count of elements in the prototype identifiers list. <br/>
     * Base type is uint. <br/>
     */
    public int protoIdsSize     = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the prototype identifiers list, or 0 if {@link #protoIdsSize} == 0 (admittedly a strange edge case). <br/>
     * Base type is uint. <br/>
     */
    public int protoIdsOff      = Integer.MIN_VALUE;

    /**
     * Count of elements in the field identifiers list. <br/>
     * Base type is uint. <br/>
     */
    public int fieldIdsSize     = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the field identifiers list, or 0 if {@link #fieldIdsSize} == 0. <br/>
     * Base type is uint. <br/>
     */
    public int fieldIdsOff      = Integer.MIN_VALUE;

    /**
     * Count of elements in the method identifiers list. <br/>
     * Base type is uint. <br/>
     */
    public int methodIdsSize    = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the method identifiers list, or 0 if {@link #methodIdsSize} == 0. <br/>
     * Base type is uint. <br/>
     */
    public int methodIdsOff     = Integer.MIN_VALUE;

    /**
     * Count of elements in the class definitions list. <br/>
     * Base type is uint. <br/>
     */
    public int classDefsSize    = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the class definitions list, or 0 if {@link #classDefsSize} == 0 (admittedly a strange edge case). <br/>
     * Base type is uint. <br/>
     */
    public int classDefsOff     = Integer.MIN_VALUE;

    /**
     * Size of data section in bytes. Must be an even multiple of sizeof(uint). <br/>
     * Base type is uint. <br/>
     */
    public int dataSize         = Integer.MIN_VALUE;

    /**
     * Offset from the start of the file to the start of the data section. <br/>
     * Base type is uint. <br/>
     */
    public int dataOff          = Integer.MIN_VALUE;
}
