package com.android.mylibrary;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class TestNetwork {

    private static Context appContext = null;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        appContext = InstrumentationRegistry.getTargetContext();
    }

    @Test
    public void test_get_local_ip() throws Exception {

        String ip = new NetworkHelper(appContext).getGatwayIP();
        assertEquals(ip, "" );
    }

}

