package com.kakaomapapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Configuration
public class ApiController {

    private static String KEY;

    @Value("${apikey.kakao}")
    public void setServerUrl(String key) { this.KEY = key; }

    /**
     * 카테고리에 해당하는 정보 검색
     * 경도와 위도의 파라미터 위치가 바뀔경우 요청이 제대로 동작하지 않음
     * 반드시 경도가 먼저 오고 뒤에 위도가 들어가야함
     * @param lon : 경도
     * @param lat : 위도
     * @param categoryCode : 카테고리 코드
     * @return
     */
    public JSONObject search(String lon, String lat, String categoryCode, int radius) {
        // REST API URL
        String apiUrl = "https://dapi.kakao.com/v2/local/search/category.json?category_group_code=" + categoryCode + "&x=" + lon + "&y=" + lat + "&radius=" + radius;

        System.out.println(apiUrl);

        BufferedReader br = null;
        JSONObject obj = new JSONObject();
        ObjectMapper mapper = new ObjectMapper();

        try {
            URL url = new URL(apiUrl);
            URLConnection conn = url.openConnection();
            // REST_API_KEY SETTING
            conn.setRequestProperty("Authorization", "KakaoAK " + KEY);
            br = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            if(br != null) {
                obj = mapper.readValue(br, JSONObject.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return obj;
    }


}
