package com.hexonxons.dex.reader.data;

public class CodeItem
{
    /**
     * The number of registers used by this code. <br/>
     * Base type is ushort. <br/>
     */
    public short registersSize              = Short.MIN_VALUE;

    /**
     * The number of words of incoming arguments to the method that this code is for. <br/>
     * Base type is ushort. <br/>
     */
    public short insSize                    = Short.MIN_VALUE;

    /**
     * The number of words of outgoing argument space required by this code for method invocation. <br/>
     * Base type is ushort. <br/>
     */
    public short outsSize                   = Short.MIN_VALUE;

    /**
     * The number of {@link com.hexonxons.dex.reader.data.TryItem} for this instance. <br/>
     * If non-zero, then these appear as the <code>tries</code> array just after the <code>insns</code> in this instance. <br/>
     * Base type is ushort. <br/>
     */
    public short triesSize                  = Short.MIN_VALUE;

    /**
     * Offset from the start of the file to the debug info (line numbers + local variable info) sequence for this code, or 0 if there simply is no information. <br/>
     * The format of the data is specified by {@link com.hexonxons.dex.reader.data.DebugInfoItem}. <br/>
     * Base type is uint. <br/>
     */
    public int debugInfoOff                 = Integer.MIN_VALUE;

    /**
     * Wize of the instructions list, in 16-bit code units. <br/>
     * Base type is uint. <br/>
     */
    public int insnsSize                    = Integer.MIN_VALUE;

    /**
     * Actual array of bytecode. The format of code in an insns array is specified by the companion document {@see <a href="https://source.android.com/devices/tech/dalvik/dalvik-bytecode.html">Dalvik bytecode</a>}. <br/>
     * Note that though this is defined as an array of ushorts, there are some internal structures that prefer four-byte alignment. <br/>
     * Also, if this happens to be in an endian-swapped file, then the swapping is only done on individual ushorts and not on the larger internal structures. <br/>
     * Base type is ushort[]. <br/>
     */
    public short[] insns                    = null;

    /**
     * Two bytes of padding to make tries four-byte aligned. This element is only present if {@link #triesSize} is non-zero and {@link #insnsSize} is odd. <br/>
     * Base type is ushort. <br/>
     */
    public short padding                    = Short.MIN_VALUE;

    /**
     * Optional. Array indicating where in the code exceptions are caught and how to handle them. <br/>
     * Elements of the array must be non-overlapping in range and in order from low to high address. <br/>
     * This element is only present if {@link #triesSize} is non-zero. <br/>
     */
    public TryItem[] tries                  = null;

    /**
     * Optional. Bytes representing a list of lists of catch types and associated handler addresses. <br/>
     * Each {@link com.hexonxons.dex.reader.data.TryItem} has a byte-wise offset into this structure. <br/>
     * This element is only present if {@link #triesSize} is non-zero. <br/>
     */
    public EncodedCatchHandlerList handlers = null;
}
