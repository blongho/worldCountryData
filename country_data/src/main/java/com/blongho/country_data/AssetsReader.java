/*
 * MIT License
 *
 * Copyright (c) 2019 - 2022 Bernard Longho
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.blongho.country_data;
/*
 * @file AssetsReader
 * @author Bernard Che Longho (blongho)
 * @brief This class reads the contents of any file that is specified in the assets directory
 * @since 2019-02-26
 */


import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.RawRes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

class AssetsReader {

    private static final String TAG = "AssetsReader";

    private AssetsReader() {
    }

    /**
     * Read contents from a file in the raw directory
     *
     * @param context    the application context
     * @param resourceID the file name. The file should should be saved inside the raw folder
     * @return a string the content as a string
     * <p>
     * NB: Call this method in a separate thread if calling from the main thread
     **/
    static String readFromAssets(@NonNull final Context context, @RawRes final int resourceID) {
        BufferedReader bufferedReader = null;
        try {
            final InputStream is = context.getResources().openRawResource(resourceID);
            bufferedReader = new BufferedReader(new InputStreamReader(is, Charset.defaultCharset()));
            int read;

            final StringBuilder stringBuffer = new StringBuilder();

            final char[] charsRead = new char[1024];
            while ((read = bufferedReader.read(charsRead)) != -1) {
                stringBuffer.append(charsRead, 0, read);
            }
            return stringBuffer.toString();

        } catch (IOException ex) {
            Log.e(TAG, ex.getMessage());
            return null;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
