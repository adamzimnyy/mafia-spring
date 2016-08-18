package adamzimny.util;

import adamzimny.model.json.response.ImgurData;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

public class ImgurAPI {

    public static ImgurData upload(MultipartFile file) {
        ImgurData data = null;
        try {
            System.out.println("Start imgurUpload");
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            headers.put("Authorization", Arrays.asList("Client-ID 9df1a76680eff2a"));
            MultiValueMap<String, Object> parts = new LinkedMultiValueMap<>();
            parts.add("image", file.getBytes());
            HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<>(parts, headers);
            data = restTemplate.postForObject("https://api.imgur.com/3/image", request, ImgurData.class);
         } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
