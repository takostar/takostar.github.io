package com.hncfx.api;

import okhttp3.*;

import java.io.*;

public class ADD {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        MediaType mediaType = MediaType.parse("application/octet-stream");
        File file = new File(ADD.class.getClassLoader().getResource("java.txt").getFile());
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        char []chars = new char[100];
        inputStreamReader.read(chars);
        System.out.println(new String(chars));
        RequestBody filebody = RequestBody.create(mediaType, file);
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                // 使用file为表单键上传文件
                .addFormDataPart("file", file.getName(), filebody)
                .build();
        Request request = new Request.Builder()
                .url("http://127.0.0.1:5001/api/v0/add")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
