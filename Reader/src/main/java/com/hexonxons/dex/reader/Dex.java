package com.hexonxons.dex.reader;

import com.hexonxons.dex.reader.data.ClassDefItem;
import com.hexonxons.dex.reader.data.FieldIdItem;
import com.hexonxons.dex.reader.data.HeaderItem;
import com.hexonxons.dex.reader.data.ProtoIdItem;
import com.hexonxons.dex.reader.data.StringDataItem;
import com.hexonxons.dex.reader.data.StringIdItem;
import com.hexonxons.dex.reader.data.TypeIdItem;
import com.hexonxons.dex.reader.exception.DexException;
import com.hexonxons.dex.reader.io.DexRandomAccessFile;
import com.hexonxons.dex.reader.util.Size;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Dex file structure:
 */
public class Dex
{
    /**
     * Dex random access file.
     */
    private DexRandomAccessFile mDexFileStream  = null;

    /**
     * Default byteorder.
     */
    private ByteOrder mByteOrder                = null;

    /**
     * Dex header.
     */
    private HeaderItem mHeaderItem              = null;

    /**
     * String id items array.
     */
    private StringIdItem[] mStringIdItems       = null;

    /**
     * String items array.
     */
    private StringDataItem[] mStringItems       = null;

    /**
     * Type id items array.
     */
    private TypeIdItem[] mTypeIdItems           = null;

    /**
     * Prototype id items array.
     */
    private ProtoIdItem[] mProtoIdItems         = null;

    /**
     * Field id items array.
     */
    private FieldIdItem[] mFieldIdItems         = null;

    /**
     * Class items array.
     */
    private ClassDefItem[] mClassDefItems       = null;

    public Dex()
    {
        mByteOrder = ByteOrder.LITTLE_ENDIAN;
    }

    public void setDexFile(String path) throws FileNotFoundException
    {
        setDexFile(new File(path));
    }

    public void setDexFile(File file) throws FileNotFoundException
    {
        mDexFileStream = new DexRandomAccessFile(file, "r");
    }

    private void readHeaderItem() throws IOException
    {
        // Alloc header item.
        mHeaderItem = new HeaderItem();
        // Alloc default int-sized buffer
        byte[] default4byteBuffer = new byte[Size.UINT];

        // Read magic.
        mHeaderItem.magic = new byte[Size.MAGIC_SIZE];
        if(mDexFileStream.read(mHeaderItem.magic, 0, Size.MAGIC_SIZE) != Size.MAGIC_SIZE)
        {
            throw new DexException("Can't read magic value from header.");
        }

        // Read checksum.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read checksum value from header.");
        }
        mHeaderItem.checksum = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read header signature.
        mHeaderItem.signature = new byte[Size.SIGNATURE_SIZE];
        if(mDexFileStream.read(mHeaderItem.signature, 0, Size.SIGNATURE_SIZE) != Size.SIGNATURE_SIZE)
        {
            throw new DexException("Can't read signature value from header.");
        }

        // Read file size.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read file size value from header.");
        }
        mHeaderItem.fileSize = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read header size.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read header size value from header.");
        }
        mHeaderItem.headerSize = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read endian tag.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read endianness tag value from header.");
        }
        mHeaderItem.endianTag = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read link section size.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read link section size value from header.");
        }
        mHeaderItem.linkSize = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read link section offset.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read link section offset value from header.");
        }
        mHeaderItem.linkOff = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read map section offset.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read map section offset value from header.");
        }
        mHeaderItem.mapOff = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read string ids section size.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read string ids section size value from header.");
        }
        mHeaderItem.stringIdsSize = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read string section offset.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read string ids section offset value from header.");
        }
        mHeaderItem.stringIdsOff = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read type ids section size.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read type ids section size value from header.");
        }
        mHeaderItem.typeIdsSize = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read type section offset.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read type ids section offset value from header.");
        }
        mHeaderItem.typeIdsOff = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read prototype ids section size.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read prototype ids section size value from header.");
        }
        mHeaderItem.protoIdsSize = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read prototype section offset.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read prototype ids section offset value from header.");
        }
        mHeaderItem.protoIdsOff = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read field ids section size.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read field ids section size value from header.");
        }
        mHeaderItem.fieldIdsSize = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read field section offset.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read field ids section offset value from header.");
        }
        mHeaderItem.fieldIdsOff = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read method ids section size.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read method ids section size value from header.");
        }
        mHeaderItem.methodIdsSize = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read method section offset.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read method ids section offset value from header.");
        }
        mHeaderItem.methodIdsOff = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read class definitionssection size.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read class definitions section size value from header.");
        }
        mHeaderItem.classDefsSize = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read class definitions offset.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read class definitions section offset value from header.");
        }
        mHeaderItem.classDefsOff = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read data section size.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read data section size value from header.");
        }
        mHeaderItem.dataSize = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();

        // Read data section offset.
        if(mDexFileStream.read(default4byteBuffer, 0, Size.UINT) != Size.UINT)
        {
            throw new DexException("Can't read data section offset value from header.");
        }
        mHeaderItem.dataOff = ByteBuffer.wrap(default4byteBuffer).order(mByteOrder).getInt();
    }

    private void readStringIdItems() throws IOException
    {
        // Seek to strings offset.
        mDexFileStream.seek(mHeaderItem.stringIdsOff);

        // Init buffer.
        byte[] intBuffer = new byte[Size.UINT];

        // Read strings offsets array.
        mStringIdItems = new StringIdItem[mHeaderItem.stringIdsSize];
        for(int i = 0; i < mHeaderItem.stringIdsSize; ++i)
        {
            mStringIdItems[i] = new StringIdItem();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read string offset.");
            }

            mStringIdItems[i].stringDataOff = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();
        }
    }

    private void readStringItems() throws IOException
    {
        // Read strings data.
        mStringItems = new StringDataItem[mHeaderItem.stringIdsSize];
        for(int i = 0; i < mHeaderItem.stringIdsSize; ++i)
        {
            mStringItems[i] = new StringDataItem();

            // Seek to offset.
            mDexFileStream.seek(mStringIdItems[i].stringDataOff);

            // Read string data.
            mStringItems[i].utf16Size = mDexFileStream.readLeb128();
            mStringItems[i].data = mDexFileStream.readUTF();
        }
    }

    private void readTypeIdItems() throws IOException
    {
        // Seek to type id offset.
        mDexFileStream.seek(mHeaderItem.typeIdsOff);

        // Init buffer.
        byte[] intBuffer = new byte[Size.UINT];

        // Read type id array.
        mTypeIdItems = new TypeIdItem[mHeaderItem.typeIdsSize];
        for(int i = 0; i < mHeaderItem.typeIdsSize; ++i)
        {
            mTypeIdItems[i] = new TypeIdItem();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read type descriptor index.");
            }

            mTypeIdItems[i].descriptorIdx = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();
        }
    }

    private void readProtoIdItems() throws IOException
    {
        // Seek to prototype id offset.
        mDexFileStream.seek(mHeaderItem.protoIdsOff);

        // Init buffer.
        byte[] intBuffer = new byte[Size.UINT];

        // Read prototype id array.
        mProtoIdItems = new ProtoIdItem[mHeaderItem.protoIdsSize];
        for(int i = 0; i < mHeaderItem.protoIdsSize; ++i)
        {
            mProtoIdItems[i] = new ProtoIdItem();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read prototype item index.");
            }

            mProtoIdItems[i].shortyIdx = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read prototype item return type.");
            }

            mProtoIdItems[i].returnTypeIdx = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read prototype item parameters offset.");
            }

            mProtoIdItems[i].parametersOff = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();
        }
    }

    private void readFieldIdItems() throws IOException
    {
        // Seek to field offset.
        mDexFileStream.seek(mHeaderItem.fieldIdsOff);

        // Init buffers.
        byte[] intBuffer = new byte[Size.UINT];
        byte[] shortBuffer = new byte[Size.USHORT];

        // Read field id array.
        mFieldIdItems = new FieldIdItem[mHeaderItem.fileSize];

        for(int i = 0; i < mHeaderItem.fileSize; ++i)
        {
            mFieldIdItems[i] = new FieldIdItem();

            if(mDexFileStream.read(shortBuffer, 0, Size.USHORT) != Size.USHORT)
            {
                throw new DexException("Can't read field class index.");
            }

            mFieldIdItems[i].classIdx = ByteBuffer.wrap(shortBuffer).order(mByteOrder).getShort();

            if(mDexFileStream.read(shortBuffer, 0, Size.USHORT) != Size.USHORT)
            {
                throw new DexException("Can't read field type index.");
            }

            mFieldIdItems[i].typeIdx = ByteBuffer.wrap(shortBuffer).order(mByteOrder).getShort();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read field name index.");
            }

            mFieldIdItems[i].nameIdx = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();
        }
    }

    private void readClassDefItems() throws IOException
    {
        // Seek to field offset.
        mDexFileStream.seek(mHeaderItem.classDefsOff);

        // Init buffer.
        byte[] intBuffer = new byte[Size.UINT];

        // Read class def array.
        mClassDefItems = new ClassDefItem[mHeaderItem.classDefsSize];

        for(int i = 0; i < mHeaderItem.classDefsSize; ++i)
        {
            mClassDefItems[i] = new ClassDefItem();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read class index.");
            }

            mClassDefItems[i].classIdx = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read class access flags.");
            }

            mClassDefItems[i].accessFlags = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read class super index.");
            }

            mClassDefItems[i].superclassIdx = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read class interfaces offset.");
            }

            mClassDefItems[i].interfacesOff = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read class source file index.");
            }

            mClassDefItems[i].sourceFileIdx = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read class annotations offset.");
            }

            mClassDefItems[i].annotationsOff = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read class data offset.");
            }

            mClassDefItems[i].classDataOff = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();

            if(mDexFileStream.read(intBuffer, 0, Size.UINT) != Size.UINT)
            {
                throw new DexException("Can't read class static values offset.");
            }

            mClassDefItems[i].staticValuesOff = ByteBuffer.wrap(intBuffer).order(mByteOrder).getInt();
        }
    }
}
