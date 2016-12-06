package adamzimny.controller;

import adamzimny.model.json.response.ImgurData;
import adamzimny.service.UserService;
import adamzimny.util.ImgurAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Properties;

/**
 * Created by Adam on 2016-04-16.
 */

public class UploadController {

    @Autowired
    UserService userService;

    public ResponseEntity<?> upload(@RequestBody MultipartFile file) {
        ImgurData imgur;
        if (!file.isEmpty()) {
            try {
                 imgur = ImgurAPI.upload(file);
            } catch (Exception e) {
              return ResponseEntity.badRequest().body(null);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return ResponseEntity.ok(imgur.getData().getId());
    }

}
