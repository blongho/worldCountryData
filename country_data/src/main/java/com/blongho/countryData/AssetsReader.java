/*
 * MIT License
 *
 * Copyright (c) 2019 Bernard Che Longho
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
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.blongho.countryData;
/**
 * @file AssetsReader
 * @author Bernard Che Longho (blongho02@gmail.com)
 * @brief This class reads the contents of any file that is specified in the assets directory
 * @since 2019-02-26
 * <br><b>Last Modified</b>
 * <p><b>2019-05-25</b>
 * - Changed readFromAssets to read using resource id from app/res/raw directory
 * </p>
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
import java.util.concurrent.Callable;

/**
 * The type Assets reader.
 */
class AssetsReader implements Callable<String> {

  private static final String TAG = "AssetsReader";
  private final Context context;
  @RawRes
  private final int rawResourceID;

  /**
   * Instantiates a new Assets reader.
   *
   * @param context the context
   * @param rawResourceID the raw resource id
   */
  AssetsReader(@NonNull final Context context, @RawRes final int rawResourceID) {
    this.context = context;
    this.rawResourceID = rawResourceID;
  }

  /**
   * Computes a result, or throws an exception if unable to do so.
   *
   * @return computed result
   *
   * @throws Exception if unable to compute a result
   */
  @Override
  public String call() throws Exception {
    return readFromAssets(context, rawResourceID);
  }

  /**
   * Read contents from a file in the raw directory
   *
   * @param context the application context
   * @param resourceID the file name. The file should should be saved inside the raw folder
   *
   * @return a string the content as a string
   *   <p>
   *   NB: Call this method in a separate thread if calling from the main thread
   **/
  private String readFromAssets(@NonNull final Context context, @RawRes final int resourceID) {
    BufferedReader bufferedReader = null;
    try {
      final InputStream is = context.getResources().openRawResource(resourceID);
      bufferedReader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
      int read;

      final StringBuilder stringBuffer = new StringBuilder();

      final char[] charsRead = new char[1024];
      while ((read = bufferedReader.read(charsRead)) != -1) {
        stringBuffer.append(charsRead, 0, read);
      }
      return stringBuffer.toString();

    } catch (final IOException ex) {
      Log.e(TAG, ex.getMessage());
      return null;
    } finally {
      if (bufferedReader != null) {
        try {
          bufferedReader.close();
        } catch (final IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
