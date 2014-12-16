package com.hexonxons.dex.reader.io;

import com.hexonxons.dex.reader.exception.DexException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Extended RandomAccessFile class.
 * LEB128/ULEB128 types read/write methods added.
 */
public class DexRandomAccessFile extends RandomAccessFile
{
    public DexRandomAccessFile(File file, String mode) throws FileNotFoundException
    {
        super(file, mode);
    }

    public int readLeb128() throws DexException, IOException
    {
        int result = 0;
        int cur;
        int count = 0;
        int signBits = -1;
        do
        {
            cur = read() & 0xff;
            result |= (cur & 0x7f) << (count * 7);
            signBits <<= 7;
            count++;
        }
        while (((cur & 0x80) == 0x80) && count < 5);

        if ((cur & 0x80) == 0x80)
        {
            throw new DexException("Invalid LEB128 sequence");
        }

        // Sign extend if appropriate
        if (((signBits >> 1) & result) != 0 )
        {
            result |= signBits;
        }

        return result;
    }

    public int readUleb128() throws DexException, IOException
    {
        int result = 0;
        int cur;
        int count = 0;
        do
        {
            cur = read() & 0xff;
            result |= (cur & 0x7f) << (count * 7);
            count++;
        }
        while (((cur & 0x80) == 0x80) && count < 5);

        if ((cur & 0x80) == 0x80)
        {
            throw new DexException("Invalid LEB128 sequence");
        }

        return result;
    }
}
