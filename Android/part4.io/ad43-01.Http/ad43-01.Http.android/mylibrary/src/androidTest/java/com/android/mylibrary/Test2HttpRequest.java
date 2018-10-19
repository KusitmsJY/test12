package com.android.mylibrary;

import com.android.mylibrary.model.ModelPerson;
import com.android.mylibrary.network.HttpRequest;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;


public class Test2HttpRequest {

    /**
     *
     * android ---전송(값0개)---> spring ---반환(값1개)--->andorid
     * 1. 안드로이드 ---> 스프링     : 안드로이드는 값을 1개 스프링 서버로 전송한다.
     * 2. 스프링     ---> 안드로이드 : 안드로이드는 값을 1개 스프링 서버로부터 반환 받는다.
     */
    @Test
    public void test01_currentversion(){
        String weburl = "http://10.0.2.1:8080/rest/currentversion";

        HttpRequest request  = null;
        String      response = "";

        try {
            request = new HttpRequest(weburl).addHeader("charset", "utf-8");
            int httpCode = request.get();

            if(HttpURLConnection.HTTP_OK == httpCode ) { // HttpURLConnection.HTTP_OK == 200
                response = request.getStringResponse();  // 서버 값이 리턴된다.
            }
            else {
                // error
            }

            assertTrue( !response.isEmpty() );
            assertNotEquals(response, "1" );
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }
    }


    /**
     * android ---전송(값2개)---> spring ---반환(값1개)--->andorid
     * 1. 안드로이드 ---> 스프링     : 안드로이드는 값을 2개 스프링 서버로 전송한다.
     * 2. 스프링     ---> 안드로이드 : 안드로이드는 값을 1개 스프링 서버로부터 반환 받는다.
     */
    @Test
    public void test02_login_success() {
        String weburl = "http://10.0.2.1:8080/rest/login";

        HttpRequest request = null;
        String response = "";

        try {
            request = new HttpRequest(weburl).addHeader("charset", "utf-8");
            request.addParameter("id","test1id");
            request.addParameter("pw","test1pw");
            int httpCode = request.post();

            if( httpCode == HttpURLConnection.HTTP_OK ){
                response = request.getStringResponse();
            }
            else {
                // error
            }
            assertEquals("1", response);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }
    }

    /**
     * android ---전송(값1개)---> spring ---반환(json:JSONObject)--->andorid
     * 1. 안드로이드 ---> 스프링     : 안드로이드는 값을 1개 스프링 서버로 전송한다.
     * 2. 스프링     ---> 안드로이드 : 안드로이드는 Json(JSONObject)을 스프링으로부터 반환 받는다.
     */
    @Test
    public void test03_get_person_one(){
        String weburl = "http://10.0.2.1:8080/rest/personone";

        HttpRequest request = null;
        JSONObject response = null;
        try {
            request = new HttpRequest(weburl).addHeader("charset","utf-8");
            request.addParameter("name","test3id");

            int httpCode = request.post();

            if (httpCode == HttpURLConnection.HTTP_OK){
                response = request.getJSONObjectResponse();

            }else{
                //error
            }

            assertEquals("valid"   , response.getString("id"   ));
            assertEquals("valname" , response.getString("name" ));
            assertEquals("valemail", response.getString("email"));
            assertEquals("valpw"   , response.getString("pw"   ));

            //json을 model 객체로 변환
            String jsonInString = response.toString();
            Gson gson = new Gson();
            ModelPerson person = gson.fromJson(jsonInString, ModelPerson.class);

            assertEquals("valid"   , person.getId()   );
            assertEquals("valname" , person.getName() );
            assertEquals("valemail", person.getEmail());
            assertEquals("valpw"   , person.getPw()   );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }
    }


    /**
     * android ---전송(값1개)---> spring ---반환(json:JSONArray)--->andorid
     * 1. 안드로이드 ---> 스프링     : 안드로이드는 값을 1개 스프링 서버로 전송한다.
     * 2. 스프링     ---> 안드로이드 : 안드로이드는 Json(JSONArray)을 스프링으로부터 반환 받는다.
     */
    @Test
    public void test04_person_list() {
        String weburl = "http://10.0.2.1:8080/rest/personlist";
        HttpRequest request = null;
        JSONArray response = null;

        try {
            request = new HttpRequest(weburl).addHeader("charset"     , "utf-8");
            int httpCode = request.post();

            if (HttpURLConnection.HTTP_OK == httpCode) {
                try {
                    response = request.getJSONArrayResponse();
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // log error
            }

            assertNotNull( response );
            assertNotEquals(0, response.length() );

            JSONObject json = (JSONObject) response.get(0);
            assertEquals("test1id"   , json.getString("id"   ));
            assertEquals("test1name" , json.getString("name" ));
            assertEquals("test1email", json.getString("email"));
            assertEquals("test1pw"   , json.getString("pw"   ));

            //JSONArray를 List<ModelPerson> 객체로 변환
            String jsonInString = response.toString();
            List<ModelPerson> list = new Gson().fromJson(jsonInString, new TypeToken<List<ModelPerson>>(){}.getType());
            assertEquals("test1id"   , list.get(0).getId()    );
            assertEquals("test1name" , list.get(0).getName()  );
            assertEquals("test1email", list.get(0).getEmail() );
            assertEquals("test1pw"   , list.get(0).getPw()    );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e1) {
            e1.printStackTrace();
        } finally {
            request.close();
        }
    }

    /**
     * android ---전송(json:JSONObject)---> spring ---반환(값1개)--->andorid
     * 1. 안드로이드 ---> 스프링     : 안드로이드는 json을 스프링으로 전송한다.
     * 2. 스프링     ---> 안드로이드 : 안드로이드는 값을 1개 스프링으로부터 반환 받는다.
     */
    @Test
    public void test11_insert_one() {
        String weburl = "http://10.0.2.1:8080/rest/insertone";
        HttpRequest request = null;
        String   response = null;

        int httpCode = 0;
        try {
            // ModelPerson을 json으로 변환
            ModelPerson obj = new ModelPerson("valid", "valpw", "valname", "valemail");
            String data = new Gson().toJson(obj); // Java object to JSON

            request = new HttpRequest(weburl).addHeader("charset"     , "utf-8")
                                             .addHeader("Content-Type", "application/json")
                                             .addHeader("Accept"      , "application/json");

            httpCode = request.post(data);

            if (HttpURLConnection.HTTP_OK == httpCode) {
                try {
                    response = request.getStringResponse();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // log error
            }

            assertNotNull( response );
            assertEquals("1", response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }
    }


    /**
     * android ---전송(json:JSONObject)---> spring ---반환(json:JSONObject)--->andorid
     * 1. 안드로이드 ---> 스프링     : 안드로이드는 json을 스프링으로 전송한다.
     * 2. 스프링     ---> 안드로이드 : 안드로이드는 값을 1개 스프링으로부터 반환 받는다.
     */
    @Test
    public void test13_find_person(){

    }


    /**
     * android ---전송(json:JSONObject)---> spring ---반환(json:JSONArray)--->andorid
     * 1. 안드로이드 ---> 스프링     : 안드로이드는 json을 스프링으로 전송한다.
     * 2. 스프링     ---> 안드로이드 : 안드로이드는 값을 1개 스프링으로부터 반환 받는다.
     */
    @Test
    public void test15_find_persons(){
        String weburl = "http://192.168.25.100:8080/rest/findpersons";

        HttpRequest request = null;
        JSONArray  response = null;

        Gson gson = new Gson();

        try {
            ModelPerson searchvalue = new ModelPerson("valid", "valpw", "valname", "valemail");
            String orderby = "name" ; // Java object to JSON

            // Map을 json으로 변환
            Map<String, Object> map = new HashMap<>();
            map.put("searchvalue", searchvalue );
            map.put("orderby"    , orderby     );

            request = new HttpRequest(weburl).addHeader("charset"     , "utf-8")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept"      , "application/json");

            String data   = new Gson().toJson(map); // Java object to JSON
            int httpCode = request.post( data );

            if (httpCode == HttpURLConnection.HTTP_OK){
                response = request.getJSONArrayResponse();

            }else{
                //error
            }

            JSONObject json = (JSONObject) response.get(0);
            assertEquals("test1id"   , json.getString("id"   ));
            assertEquals("test1name" , json.getString("name" ));
            assertEquals("test1email", json.getString("email"));
            assertEquals("test1pw"   , json.getString("pw"   ));

            //json을 model 객체로 변환
            String jsonInString = response.toString();

            List<ModelPerson> list = gson.fromJson(jsonInString, new TypeToken<List<ModelPerson>>(){}.getType());
            assertEquals("test1id"   , list.get(0).getId   () );
            assertEquals("test1name" , list.get(0).getName () );
            assertEquals("test1email", list.get(0).getEmail() );
            assertEquals("test1pw"   , list.get(0).getPw   () );

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }
    }

    /**
     * android ---전송(json:JSONArray)---> spring ---반환(값1개)--->andorid
     *
     * 1. 안드로이드 ---> 스프링     : 안드로이드는 json을 스프링으로 전송한다.
     * 2. 스프링     ---> 안드로이드 : 안드로이드는 값을 1개 스프링으로부터 반환 받는다.
     */
    @Test
    public void test17_insert_list() {
        String weburl = "http://10.0.2.1:8080/rest/insertlist";
        HttpRequest request = null;
        String   response = null;

        int httpCode = 0;
        try {
            // List를 JSonArray로 변환
            List<ModelPerson> list = new ArrayList<ModelPerson>();
            for( int i=0; i<10; i++){
                String t = new SimpleDateFormat("yyyyMMddHHmmss").format( Calendar.getInstance().getTime() );
                ModelPerson obj = new ModelPerson("valid"+t, "valpw"+t, "valname"+t, "valemail"+t);
                list.add(obj);
            }
            String data = new Gson().toJson(list);

            request = new HttpRequest(weburl).addHeader("charset"     , "utf-8")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Accept"      , "application/json");

            httpCode = request.post(data);

            if (HttpURLConnection.HTTP_OK == httpCode) {
                try {
                    response = request.getStringResponse();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                // log error
            }

            assertNotNull( response );
            assertEquals("10", response);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }
    }


}
