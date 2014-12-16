package com.hexonxons.dex.reader.data;

/**
 * This is a list of the entire contents of a file, in order. <br/>
 * It contains some redundancy with respect to the {@link com.hexonxons.dex.reader.data.HeaderItem} but is intended to be an easy form to use to iterate over an entire file. <br/>
 * A given type must appear at most once in a map, but there is no restriction on what order types may appear in, other than the restrictions implied by the rest of the format (e.g., a header section must appear first, followed by a {@link com.hexonxons.dex.reader.data.StringIdItem} list section, etc.). <br/>
 * Additionally, the map entries must be ordered by initial offset and must not overlap. <br/>
 */
public class MapList
{
    /**
     * Size of the list, in entries. <br/>
     * Base type is uint. <br/>
     */
    public int size     = Integer.MIN_VALUE;

    /**
     * Elements of the list. <br/>
     */
    public MapItem list = null;
}
