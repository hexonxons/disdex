package com.hexonxons.dex.reader.data;

public class DebugInfoItem
{
    /**
     * The initial value for the state machine's line register. Does not represent an actual positions entry. <br/>
     * Base type is uleb128. <br/>
     */
    public int lineStart        = Integer.MIN_VALUE;

    /**
     * The number of parameter names that are encoded. <br/>
     * There should be one per method parameter, excluding an instance method's this, if any. <br/>
     * Base type is uleb128. <br/>
     */
    public int parametersSize   = Integer.MIN_VALUE;

    /**
     * String index of the method parameter name. <br/>
     * An encoded value of {@link com.hexonxons.dex.reader.util.Constant#NO_INDEX} indicates that no name is available for the associated parameter. The type descriptor and signature are implied from the method descriptor and signature. <br/>
     * Base type is uleb128p1[parametersSize] <br/>
     */
    public int[] parameterNames = null;

    /**
     * Debug bytecode. <br/>
     */
    public byte[] bytecode      = null;
}
