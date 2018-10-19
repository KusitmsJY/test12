package com.android.fileupload;

import android.util.Log;
import android.webkit.MimeTypeMap;

import java.io.*;
import java.net.*;

public class AndroidUploader    {
    static String postUrl = "http://10.0.2.1:8080/upload/uploadfileone";
    static String CRLF = "\r\n";
    static String twoHyphens = "--";
    static String boundary = "*****b*o*u*n*d*a*r*y*****";

    private String fileName = null;
    private String userid = null;
    private String password = null;
    private DataOutputStream dataStream = null;

    enum ReturnCode { noPicture, unknown, http201, http400, http401, http403, http404, http500};

    private String TAG = "멀티파트 테스트";

    public AndroidUploader(String userid, String password)         {
        this.userid = userid;
        this.password = password;
    }
    /**
     * File의 MimeType을 알아내기
     * http://susemi99.tistory.com/896
     *
     * @param filePath 파일 경로
     *            Environment.getExternalStoragePublicDirectory(Environment
     *            .DIRECTORY_DOWNLOADS)+"/susemi99.png"
     * @return image/png, video/xxx
     */
    public static String getMimeTypeFromFile(String filePath)
    {
        MimeTypeMap type = MimeTypeMap.getSingleton();
        return type.getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(filePath));
    }



    public ReturnCode uploadPicture(String fileName)        {
        this.fileName = fileName;
        File uploadFile = new File(fileName);

        if (uploadFile.exists())
            try     {
                FileInputStream fileInputStream = new FileInputStream(uploadFile);
                URL connectURL = new URL(postUrl);
                HttpURLConnection conn = (HttpURLConnection)connectURL.openConnection();

                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setUseCaches(false);

                //conn.setRequestProperty("User-Agent", "myFileUploader");
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Connection","Keep-Alive");
                conn.setRequestProperty("Content-Type","multipart/form-data;boundary="+boundary);

                conn.connect();

                dataStream = new DataOutputStream(conn.getOutputStream());

                writeFormField("login"   , userid);
                writeFormField("password", password);
                writeFileField("file"    , uploadFile.getName(), getMimeTypeFromFile(fileName), fileInputStream);

                // final closing boundary line
                dataStream.writeBytes(twoHyphens + boundary + twoHyphens + CRLF);

                fileInputStream.close();
                dataStream.flush();
                dataStream.close();
                dataStream = null;

                Log.d("업로드 테스트", "***********전송완료***********");

                String response = getResponse(conn);
                int responseCode = conn.getResponseCode();

                if (response.contains("uploaded successfully"))
                    return ReturnCode.http201;
                else
                    // for now assume bad userid/password
                    return ReturnCode.http401;
            }
            catch (MalformedURLException mue) {
                Log.e(TAG, "error: " + mue.getMessage(), mue);
                return ReturnCode.http400;
            }
            catch (IOException ioe) {
                Log.e(TAG, "error: " + ioe.getMessage(), ioe);
                return ReturnCode.http500;
            }
            catch (Exception e) {
                Log.e(TAG, "error: " + e.getMessage(), e);
                return ReturnCode.unknown;
            }    else    {
            return ReturnCode.noPicture;
        }
    }

    private String getResponse(HttpURLConnection conn)        {
        try             {
            DataInputStream dis = new DataInputStream(conn.getInputStream());
            byte []        data = new byte[1024];
            int             len = dis.read(data, 0, 1024);

            dis.close();
            int responseCode = conn.getResponseCode();

            if (len > 0)
                return new String(data, 0, len);
            else
                return "";
        }
        catch(Exception e)     {
            //System.out.println("AndroidUploader: "+e);
            Log.e(TAG, "AndroidUploader: "+e);
            return "";
        }
    }

    /**
     *  this mode of reading response no good either
     */
    private String getResponseOrig(HttpURLConnection conn)        {
        InputStream is = null;
        try   {
            is = conn.getInputStream();
            // scoop up the reply from the server
            int ch;
            StringBuffer sb = new StringBuffer();
            while( ( ch = is.read() ) != -1 ) {
                sb.append( (char)ch );
            }
            return sb.toString();   // TODO Auto-generated method stub
        }
        catch(Exception e)   {
            //System.out.println("GeoPictureUploader: biffed it getting HTTPResponse");
            Log.e(TAG, "AndroidUploader: "+e);
        }
        finally   {
            try {
                if (is != null)
                    is.close();
            } catch (Exception e) {}
        }

        return "";
    }

    /**
     * write one form field to dataSream
     * @param fieldName
     * @param fieldValue
     */
    private void writeFormField(String fieldName, String fieldValue)  {
        try  {
            dataStream.writeBytes(twoHyphens + boundary + CRLF);
            dataStream.writeBytes("Content-Disposition: form-data; name=\"" + fieldName + "\"" + CRLF);
            dataStream.writeBytes(CRLF);
            dataStream.writeBytes(fieldValue);
            dataStream.writeBytes(CRLF);
        }    catch(Exception e)   {
            //System.out.println("AndroidUploader.writeFormField: got: " + e.getMessage());
            Log.e(TAG, "AndroidUploader.writeFormField: " + e.getMessage());
        }
    }

    /**
     * write one file field to dataSream
     * @param fieldName - userid of file field
     * @param fieldValue - file userid
     * @param type - mime type
     * @param fis - stream of bytes that get sent up
     */
    private void writeFileField(
            String fieldName,
            String fieldValue,
            String type,
            FileInputStream fis)  {
        try {
            // opening boundary line
            dataStream.writeBytes(twoHyphens + boundary + CRLF);
            dataStream.writeBytes("Content-Disposition: form-data; name=\""
                    + fieldName
                    + "\";filename=\""
                    + fieldValue
                    + "\""
                    + CRLF);
            dataStream.writeBytes("Content-Type: " + type +  CRLF);
            dataStream.writeBytes(CRLF);

            // create a buffer of maximum size
            int bytesAvailable = fis.available();
            int maxBufferSize = 1024;
            int bufferSize = Math.min(bytesAvailable, maxBufferSize);
            byte[] buffer = new byte[bufferSize];
            // read file and write it into form...
            int bytesRead = fis.read(buffer, 0, bufferSize);
            while (bytesRead > 0)   {
                dataStream.write(buffer, 0, bufferSize);
                bytesAvailable = fis.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fis.read(buffer, 0, bufferSize);
            }

            // closing CRLF
            dataStream.writeBytes(CRLF);
        }
        catch(Exception e)  {
            //System.out.println("GeoPictureUploader.writeFormField: got: " + e.getMessage());
            Log.e(TAG, "AndroidUploader.writeFormField: got: " + e.getMessage());
        }
    }
}
