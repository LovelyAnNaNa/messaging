package com.work.messaging;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.junit.Test;

/**
 * @Auther: wbh
 * @Date: 2019/10/30 12:30
 * @Description:
 */
public class Test11 {

    @Test
    public void test() throws Exception{
        OkHttpClient client = new OkHttpClient();

        RequestBody requestBody = RequestBody.create(new byte[30]);

        Request request = new Request.Builder()
                .url("https://22711a.com/Home/GetCaptchaForLogin")
                .post(requestBody)
                .addHeader("c8763", "vBydvB-OmCdYE_m_l01lanWDchFAaJ1avrkiorcyXLxFiGWG4qXMnbrznO4wO97Rg76zoV7Eb33kEy-CulmOU28l_401")
                .addHeader("cache-control", "no-cache")
                .addHeader("Postman-Token", "a729a52a-b4bd-4041-8bf9-07bede4ea854")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());

    }
}
