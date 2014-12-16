package com.hexonxons.dex.reader;

import com.hexonxons.dex.reader.data.AccessFlags;
import com.hexonxons.dex.reader.data.ClassDefItem;
import com.hexonxons.dex.reader.data.FieldIdItem;
import com.hexonxons.dex.reader.data.HeaderItem;
import com.hexonxons.dex.reader.data.MethodIdItem;
import com.hexonxons.dex.reader.data.ProtoIdItem;
import com.hexonxons.dex.reader.data.StringDataItem;
import com.hexonxons.dex.reader.data.StringIdItem;
import com.hexonxons.dex.reader.data.TypeIdItem;
import com.hexonxons.dex.reader.exception.DexException;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class Reader
{
    private static final String TAG = "Reader";

    // Dex file input stream.
    private RandomAccessFile mRandomAccessFile = null;

    public Reader(RandomAccessFile is)
    {
        mRandomAccessFile = is;
    }

    public HeaderItem readHeader() throws IndexOutOfBoundsException, DexException, IOException
    {
        // Create header object.
        HeaderItem header = new HeaderItem();

        // Read magic.
        header.magic = new byte[HeaderItem.MAGIC_SIZE];
        if(mRandomAccessFile.read(header.magic, 0, HeaderItem.MAGIC_SIZE) != HeaderItem.MAGIC_SIZE)
        {
            throw new DexException("Can't read header magic value from header.");
        }

        // Read adler32 checksum.
        header.adler32Checksum = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.adler32Checksum, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read adler32 checksum from header.");
        }

        // Read SHA-1 checksum.
        header.signature = new byte[HeaderItem.SIGNATURE_SIZE];
        if(mRandomAccessFile.read(header.signature, 0, HeaderItem.SIGNATURE_SIZE) != HeaderItem.SIGNATURE_SIZE)
        {
            throw new DexException("Can't read sha-1 checksum from header.");
        }

        // Read file size.
        header.fileSize = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.fileSize, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read file size from header.");
        }

        // Read file size.
        header.headerSize = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.headerSize, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read header size from header.");
        }

        // Read endianness tag.
        header.endiannessTag = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.endiannessTag, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read endianness tag from header.");
        }

        // Read link size.
        header.linkSize = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.linkSize, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read link section size from header.");
        }

        // Read link offset.
        header.linkOffset = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.linkOffset, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read link section offset from header.");
        }

        // Read map item offset.
        header.mapOffset = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.mapOffset, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read map item offset from header.");
        }

        // Read count of strings in the string identifiers list.
        header.stringIdsSize = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.stringIdsSize, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read count of strings in the string identifiers list from header.");
        }

        // Read string identifiers list offset.
        header.stringIdsOffset = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.stringIdsOffset, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read string identifiers list offset from header.");
        }

        // Read count of elements in the type identifiers list.
        header.typeIdsSize = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.typeIdsSize, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read count of types in the type identifiers list from header.");
        }

        // Read type identifiers list offset.
        header.typeIdsOffset = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.typeIdsOffset, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read type identifiers list offset from header.");
        }

        // Read count of elements in the type identifiers list.
        header.prototypeIdsSize = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.prototypeIdsSize, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read count of prototypes in the prototype identifiers list from header.");
        }

        // Read type identifiers list offset.
        header.prototypeIdsOffset = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.prototypeIdsOffset, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read prototype identifiers list offset from header.");
        }

        // Read count of elements in the field identifiers list.
        header.fieldIdsSize = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.fieldIdsSize, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read count of fields in the field identifiers list from header.");
        }

        // Read field identifiers list offset.
        header.fieldIdsOffset = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.fieldIdsOffset, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read field identifiers list offset from header.");
        }

        // Read count of elements in the method identifiers list.
        header.methodIdsSize = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.methodIdsSize, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read count of methods in the method identifiers list from header.");
        }

        // Read method identifiers list offset.
        header.methodIdsOffset = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.methodIdsOffset, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read method identifiers list offset from header.");
        }

        // Read count of elements in the class definitions list.
        header.classDefinitionsSize = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.classDefinitionsSize, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read count of class definitions in the class definitions list from header.");
        }

        // Read class definitions list offset.
        header.classDefinitionsOffset = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.classDefinitionsOffset, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read class definitions list offset from header.");
        }

        // Read size of data section.
        header.dataSize = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.dataSize, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read size of data section from header.");
        }

        // Read data section list offset.
        header.dataOffset = new byte[HeaderItem.DEFAULT_SIZE];
        if(mRandomAccessFile.read(header.dataOffset, 0, HeaderItem.DEFAULT_SIZE) != HeaderItem.DEFAULT_SIZE)
        {
            throw new DexException("Can't read data section offset from header.");
        }

        return header;
    }

    public StringIdItem[] readStringIds(final HeaderItem header) throws IndexOutOfBoundsException, DexException, IOException
    {
        // Check for dex byte order.
        ByteOrder byteOrder = Arrays.equals(header.endiannessTag, HeaderItem.LITTLE_ENDIAN) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;

        // Read strings count and section offset.
        int offset = ByteBuffer.wrap(header.stringIdsOffset).order(byteOrder).getInt();
        int count = ByteBuffer.wrap(header.stringIdsSize).order(byteOrder).getInt();

        // Seek to offset.
        mRandomAccessFile.seek(offset);

        // Read strings offsets array.
        StringIdItem[] ids = new StringIdItem[count];
        for(int i = 0; i < count; ++i)
        {
            ids[i] = new StringIdItem(mRandomAccessFile, byteOrder);
        }

        return ids;
    }

    public StringDataItem[] readStringDatas(final HeaderItem header, final StringIdItem[] stringIds) throws IndexOutOfBoundsException, DexException, IOException
    {
        // Check for dex byte order.
        ByteOrder byteOrder = Arrays.equals(header.endiannessTag, HeaderItem.LITTLE_ENDIAN) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;

        // Read strings data.
        StringDataItem[] stringsData = new StringDataItem[stringIds.length];
        for(int i = 0; i < stringIds.length; ++i)
        {
            // Seek to offset.
            mRandomAccessFile.seek(stringIds[i].stringDataOff);
            // Read string data.
            stringsData[i] = new StringDataItem(mRandomAccessFile, byteOrder);
        }

        return stringsData;
    }

    public TypeIdItem[] readTypeIds(final HeaderItem header) throws IndexOutOfBoundsException, DexException, IOException
    {
        // Check for dex byte order.
        ByteOrder byteOrder = Arrays.equals(header.endiannessTag, HeaderItem.LITTLE_ENDIAN) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;

        // Read types count and section offset.
        int offset = ByteBuffer.wrap(header.typeIdsOffset).order(byteOrder).getInt();
        int count = ByteBuffer.wrap(header.typeIdsSize).order(byteOrder).getInt();

        // Seek to offset.
        mRandomAccessFile.seek(offset);

        // Read types offsets array.
        TypeIdItem[] ids = new TypeIdItem[count];
        for(int i = 0; i < count; ++i)
        {
            ids[i] = new TypeIdItem(mRandomAccessFile, byteOrder);
        }

        return ids;
    }

    public ProtoIdItem[] readProtoIds(final HeaderItem header) throws IndexOutOfBoundsException, DexException, IOException
    {
        // Check for dex byte order.
        ByteOrder byteOrder = Arrays.equals(header.endiannessTag, HeaderItem.LITTLE_ENDIAN) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;

        // Read types count and section offset.
        int offset = ByteBuffer.wrap(header.prototypeIdsOffset).order(byteOrder).getInt();
        int count = ByteBuffer.wrap(header.prototypeIdsSize).order(byteOrder).getInt();

        // Seek to offset.
        mRandomAccessFile.seek(offset);

        // Read types offsets array.
        ProtoIdItem[] ids = new ProtoIdItem[count];
        for(int i = 0; i < count; ++i)
        {
            ids[i] = new ProtoIdItem(mRandomAccessFile, byteOrder);
        }

        return ids;
    }

    public FieldIdItem[] readFieldIds(final HeaderItem header) throws IndexOutOfBoundsException, DexException, IOException
    {
        // Check for dex byte order.
        ByteOrder byteOrder = Arrays.equals(header.endiannessTag, HeaderItem.LITTLE_ENDIAN) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;

        // Read types count and section offset.
        int offset = ByteBuffer.wrap(header.prototypeIdsOffset).order(byteOrder).getInt();
        int count = ByteBuffer.wrap(header.prototypeIdsSize).order(byteOrder).getInt();

        // Seek to offset.
        mRandomAccessFile.seek(offset);

        // Read types offsets array.
        FieldIdItem[] ids = new FieldIdItem[count];
        for(int i = 0; i < count; ++i)
        {
            ids[i] = new FieldIdItem(mRandomAccessFile, byteOrder);
        }

        return ids;
    }

    public MethodIdItem[] readMethodIds(final HeaderItem header) throws IndexOutOfBoundsException, DexException, IOException
    {
        // Check for dex byte order.
        ByteOrder byteOrder = Arrays.equals(header.endiannessTag, HeaderItem.LITTLE_ENDIAN) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;

        // Read types count and section offset.
        int offset = ByteBuffer.wrap(header.prototypeIdsOffset).order(byteOrder).getInt();
        int count = ByteBuffer.wrap(header.prototypeIdsSize).order(byteOrder).getInt();

        // Seek to offset.
        mRandomAccessFile.seek(offset);

        // Read types offsets array.
        MethodIdItem[] ids = new MethodIdItem[count];
        for(int i = 0; i < count; ++i)
        {
            ids[i] = new MethodIdItem(mRandomAccessFile, byteOrder);
        }

        return ids;
    }

    public ClassDefItem[] readClassDefs(final HeaderItem header) throws IndexOutOfBoundsException, DexException, IOException
    {
        // Check for dex byte order.
        ByteOrder byteOrder = Arrays.equals(header.endiannessTag, HeaderItem.LITTLE_ENDIAN) ? ByteOrder.LITTLE_ENDIAN : ByteOrder.BIG_ENDIAN;

        // Read types count and section offset.
        int offset = ByteBuffer.wrap(header.prototypeIdsOffset).order(byteOrder).getInt();
        int count = ByteBuffer.wrap(header.prototypeIdsSize).order(byteOrder).getInt();

        // Seek to offset.
        mRandomAccessFile.seek(offset);

        // Read types offsets array.
        ClassDefItem[] defs = new ClassDefItem[count];
        for(int i = 0; i < count; ++i)
        {
            defs[i] = new ClassDefItem(mRandomAccessFile, byteOrder);
        }

        return defs;
    }
}
