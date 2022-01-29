package com.hncfx.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;

import java.io.IOException;

public class PEERS {
    public static void main(String[] args) throws IOException {
        /*
        * 信息
        * */
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("text/plain");
        RequestBody body = RequestBody.create(mediaType, "");
        Request request = new Request.Builder()
                .url("http://127.0.0.1:5001/api/v0/swarm/peers")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        JSONObject object = JSONObject.parseObject(response.body().string());
        JSONArray peers = object.getJSONArray("Peers");
        System.out.println("当前共" + peers.size() + "个peer");
    }
}
