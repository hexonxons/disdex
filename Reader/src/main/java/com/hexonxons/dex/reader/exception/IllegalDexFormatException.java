package com.hexonxons.dex.reader.exception;

public class IllegalDexFormatException extends Exception
{
    private String mMessage = null;

    public IllegalDexFormatException(String message)
    {
        mMessage = message;
    }

    @Override
    public String getMessage()
    {
        return mMessage;
    }
}
