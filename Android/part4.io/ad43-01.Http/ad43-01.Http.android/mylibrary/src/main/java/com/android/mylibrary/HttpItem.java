package com.android.mylibrary;

import com.android.mylibrary.model.ModelItem;
import com.android.mylibrary.network.HttpRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

public class HttpItem {
    private final String URL_ITEMLIST   = "http://192.168.25.100:8080/rest/itemlist";
    private final String URL_ITEMVIEW   = "http://192.168.25.100:8080/rest/itemview";

    // /rest/itemlist
    public List<ModelItem> itemlist(Integer start, Integer end) {
        HttpRequest request = null;
        JSONArray response = null;

        List<ModelItem> result = new ArrayList<>();

        try {
            request = new HttpRequest(URL_ITEMLIST).addHeader("charset", "utf-8");
            request.addParameter("start", String.valueOf(start) );
            request.addParameter("end"  , String.valueOf(end  ) );

            int httpCode = request.post();

            if( httpCode == HttpURLConnection.HTTP_OK ){
                response = request.getJSONArrayResponse();
            }
            else {
                // error
            }

            //JSONArray를 List<ModelItem> 객체로 변환
            if (response != null) {
                for (int i=0;i<response.length();i++){
                    JSONObject obj=(JSONObject)response.get(i);
                    ModelItem item = new ModelItem();
                    item.setDataItem01( obj.getString("dataItem01"));
                    item.setDataItem02( obj.getString("dataItem02"));
                    item.setDataItem03( obj.getString("dataItem03"));
                    item.setIconItem  ( obj.getString("iconItem"  ));

                    result.add( item );
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }

        return result;
    }
    
    // /rest/itemone
    public String itemone(String dataItemID) {
        HttpRequest request = null;
        String response = "";

        try {
            request = new HttpRequest(URL_ITEMVIEW).addHeader("charset", "utf-8");
            request.addParameter("dataItemID", dataItemID );
            int httpCode = request.post();

            if( httpCode == HttpURLConnection.HTTP_OK ){
                response = request.getStringResponse();
            }
            else {
                // error
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            request.close();
        }

        return response;
    }


}
