package com.android.mylibrary;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


public class ImageHelper {

    /**
     * Image File --> Byte Array
     * @param file
     * @return
     */
    public static byte[] convertFromFileToByteArray(File file) {

        byte[] bytes = null;
        try {
            FileInputStream fileInputStreamReader = new FileInputStream(file.getPath());
            bytes = new byte[(int)file.length()];
            fileInputStreamReader.read(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bytes;
    }

    /**
     * Image File --> Byte Array --> String
     * @param file
     * @return
     */
    public static String convertFromImagefileToString(File file) {

        String encodedstring = null;
        try {
            byte[] bytes = convertFromFileToByteArray( file );
            encodedstring = new String(org.apache.commons.codec.binary.Base64.encodeBase64(bytes), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encodedstring;
    }


    /**
     * Bitmap --> String
     * https://stackoverflow.com/questions/34915150/how-to-convert-bitmap-to-base64-string
     * @param image
     * @return
     */
    public static String convertFromBitmapToString(Bitmap image) {

        String imageEncoded = null;

        try {
            Bitmap immagex=image;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            immagex.compress(Bitmap.CompressFormat.PNG, 100, baos);
            byte[] bytes = baos.toByteArray();
            imageEncoded = new String(org.apache.commons.codec.binary.Base64.encodeBase64(bytes), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return imageEncoded;
    }



    /**
     * String --> Byte Array
     * https://stackoverflow.com/questions/11465081/convert-base64-string-to-byte-code-in-java
     * @param image
     * @return
     */
    public static byte[] convertFromStringToByteArray(String image){
        byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(image.getBytes());
        return decoded;
    }


    /**
     * https://stackoverflow.com/questions/3585009/convert-string-to-drawable
     * @param context
     * @param id
     * @return
     */
    public static Drawable getDrawable(Context context, @DrawableRes int id) {
        Drawable myDrawable = null;
        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP){
            myDrawable = context.getResources().getDrawable(id, context.getTheme());
        } else {
            myDrawable = context.getResources().getDrawable(id);
        }

        return myDrawable;
    }

    /**
     * bitmap --> drawable
     * http://jwandroid.tistory.com/353
     * @param bitmap
     * @return
     */
    public static Drawable getDrawable(Bitmap bitmap) {
        Drawable myDrawable = null;

        Drawable drawable = new BitmapDrawable(bitmap);

        return myDrawable;
    }

    /**
     * base 64 decode string --> bitmap --> drawable
     * @param image
     * @return
     */
    public static Drawable getDrawable(String image) {
        Drawable myDrawable = null;
        Bitmap bitmap       = getBitmap(image);
        Drawable drawable   = getDrawable(bitmap);
        return myDrawable;
    }

    /**
     * Drawable --> Bitmap
     * http://corochann.com/convert-between-bitmap-and-drawable-313.html
     * @param drawable
     * @return
     */
    public static Bitmap getBitmap(Drawable drawable) {
        Bitmap bitmap = null;

        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if(bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }

        if(drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);

        return bitmap;
    }


    /**
     * String --> Byte Array --> Bitmap Image
     * @param image
     * @return
     */
    public static Bitmap getBitmap(String image){
        try{
            byte[] encodeByte=org.apache.commons.codec.binary.Base64.decodeBase64(image.getBytes());
            Bitmap bitmap=BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        }catch(Exception e){
            e.getMessage();
            return null;
        }
    }

    /**
     * File Save:  String --> File
     * @param outfile
     * @param textdata
     */
    public static void saveTextFile(String textdata, File outfile) {

        try {
            FileWriter fw = new FileWriter(outfile);
            fw.write(textdata);
            fw.close();
        } catch (IOException ex) {
            //do stuff with exception
            ex.printStackTrace();
        }
    }

    /**
     * Image String --> Byte Array --> Image File
     * https://stackoverflow.com/questions/20879639/write-base64-encoded-image-to-file
     * @param imagedata
     * @return
     */
    public static void saveImageFile(String imagedata, File outfile){
        byte dearr[] = org.apache.commons.codec.binary.Base64.decodeBase64(imagedata);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream( outfile );
            fos.write(dearr);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
            }
        }
    }


    /**
     * save a bitmap to file
     * https://stackoverflow.com/questions/11274715/save-bitmap-to-file-function
     * @param bitmap
     * @param outfile
     */
    public static boolean saveBitmapFile(Bitmap bitmap, File outfile) {

        boolean result = false;

        if (bitmap != null) {
            FileOutputStream outputStream = null;

            try {
                File dir = new File( outfile.getPath() );

                if (!dir.exists())
                    dir.mkdirs();

                //here is set your file path where you want to save or also here you can set file object directly
                outputStream = new FileOutputStream(outfile);

                // bitmap is your Bitmap instance, if you want to compress it you can compress reduce percentage
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);

                // PNG is a lossless format, the compression factor (100) is ignored
                result = true;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.flush();
                        outputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}