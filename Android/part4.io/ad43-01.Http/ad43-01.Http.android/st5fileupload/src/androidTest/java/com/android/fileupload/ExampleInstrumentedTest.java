package com.android.fileupload;

import android.content.Context;
import android.os.Environment;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    public static void copyFile(File src, File dst) throws IOException {
        FileChannel inChannel = new FileInputStream(src).getChannel();
        FileChannel outChannel = new FileOutputStream(dst).getChannel();

        try {
            inChannel.transferTo(0, inChannel.size(), outChannel);
        } finally {
            if (inChannel != null)
                inChannel.close();
            if (outChannel != null)
                outChannel.close();
        }
    }

    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
        assertEquals("com.android.fileupload", appContext.getPackageName());

        try {
            // SDCard로 파일 복사.
            String fileName = Environment.getExternalStorageDirectory().getAbsolutePath()+"/test.txt";
            InputStream inputStream = appContext.getResources().openRawResource(R.raw.test );
            File dst = new File(fileName);

            FileOutputStream fileOutputStream = new FileOutputStream( new File(fileName) );

            byte buf[]=new byte[1024];
            int len;
            while((len=inputStream.read(buf))>0) {
                fileOutputStream.write(buf,0,len);
            }

            fileOutputStream.close();
            inputStream.close();


            // http 파일 업로드 테스트
            AndroidUploader gpu = new AndroidUploader("john", "notmyrealpassword");
            AndroidUploader.ReturnCode rc = gpu.uploadPicture(fileName);
            assertEquals(rc, AndroidUploader.ReturnCode.http201);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
