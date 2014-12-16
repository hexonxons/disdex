package com.hexonxons.dex;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.hexonxons.dex.reader.Reader;
import com.hexonxons.dex.reader.util.Utils;
import com.hexonxons.dex.reader.data.HeaderItem;
import com.hexonxons.dex.reader.data.StringDataItem;
import com.hexonxons.dex.reader.data.StringIdItem;
import com.hexonxons.dex.reader.data.TypeIdItem;
import com.hexonxons.dex.reader.exception.DexException;

import java.io.IOException;
import java.io.RandomAccessFile;

public class MainActivity extends ActionBarActivity
{
    private final int HEADER_FIELDS_COUNT = 23;

    private HeaderItem mHeader          = null;
    private byte[][] mHeaderArray   = null;

    private TextView mTextView      = null;
    private ListView mListView      = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextView = (TextView) findViewById(R.id.hexview);
        mTextView.setTypeface(Typeface.createFromAsset(getAssets(), "Anonymous_Pro.ttf"));

        mListView = (ListView) findViewById(R.id.hexlist);
        mListView.setAdapter(new BaseAdapter()
        {
            private final String[] HEADER_FIELDS = getResources().getStringArray(R.array.header_elements);

            @Override
            public int getCount()
            {
                return HEADER_FIELDS_COUNT;
            }

            @Override
            public Object getItem(int position)
            {
                return HEADER_FIELDS[position];
            }

            @Override
            public long getItemId(int position)
            {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                TextView view = (TextView) convertView;
                if(view == null)
                {
                    view = (TextView) getLayoutInflater().inflate(R.layout.header_element, parent, false);
                }

                view.setText(HEADER_FIELDS[position]);

                return view;
            }
        });

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();

                for(int i = 0; i < HEADER_FIELDS_COUNT; ++i)
                {
                    String hex = Utils.bytesToHex(mHeaderArray[i]);
                    if(i == position)
                    {
                        int start = spannableStringBuilder.length();
                        spannableStringBuilder.append(hex);
                        int end = spannableStringBuilder.length();

                        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);
                        spannableStringBuilder.setSpan(span, start, end, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
                    }
                    else
                    {
                        spannableStringBuilder.append(hex);
                    }


                }

                mTextView.setText(spannableStringBuilder);
            }
        });

        try
        {
            Reader reader = new Reader(new RandomAccessFile("/sdcard/classes.dex", "r"));
            mHeader = reader.readHeader();
            StringIdItem[] stringIds = reader.readStringIds(mHeader);
            StringDataItem[] stringDatas = reader.readStringDatas(mHeader, stringIds);

            TypeIdItem[] typeIds = reader.readTypeIds(mHeader);

            Log.e("a", "a");
        }
        catch(IndexOutOfBoundsException e)
        {
            e.printStackTrace();
        }
        catch(DexException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        if(mHeader != null)
        {
            mHeaderArray = new byte[HEADER_FIELDS_COUNT][];
            mHeaderArray[0] = mHeader.magic;
            mHeaderArray[1] = mHeader.adler32Checksum;
            mHeaderArray[2] = mHeader.signature;
            mHeaderArray[3] = mHeader.fileSize;
            mHeaderArray[4] = mHeader.headerSize;
            mHeaderArray[5] = mHeader.endiannessTag;
            mHeaderArray[6] = mHeader.linkSize;
            mHeaderArray[7] = mHeader.linkOffset;
            mHeaderArray[8] = mHeader.mapOffset;
            mHeaderArray[9] = mHeader.stringIdsSize;
            mHeaderArray[10] = mHeader.stringIdsOffset;
            mHeaderArray[11] = mHeader.typeIdsSize;
            mHeaderArray[12] = mHeader.typeIdsOffset;
            mHeaderArray[13] = mHeader.prototypeIdsSize;
            mHeaderArray[14] = mHeader.prototypeIdsOffset;
            mHeaderArray[15] = mHeader.fieldIdsSize;
            mHeaderArray[16] = mHeader.fieldIdsOffset;
            mHeaderArray[17] = mHeader.methodIdsSize;
            mHeaderArray[18] = mHeader.methodIdsOffset;
            mHeaderArray[19] = mHeader.classDefinitionsSize;
            mHeaderArray[20] = mHeader.classDefinitionsOffset;
            mHeaderArray[21] = mHeader.dataSize;
            mHeaderArray[22] = mHeader.dataOffset;

            String text = new String();

            for(int i = 0; i < HEADER_FIELDS_COUNT; ++i)
            {
                text += Utils.bytesToHex(mHeaderArray[i]);
            }

            mTextView.setText(text);
        }
    }
}
