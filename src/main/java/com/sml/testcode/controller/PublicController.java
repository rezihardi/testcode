package com.sml.testcode.controller;

import com.sml.testcode.model.DataNation;
import com.sml.testcode.model.Mail;
import com.sml.testcode.service.KaryawanService;
import com.sml.testcode.util.AppUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@RestController
@RequestMapping("/ConsumePublic")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PublicController {
    @Autowired
    KaryawanService karyawanService;
    @GetMapping(path = "/get-all-employee", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(" nation API consume ")
    public ResponseEntity findRole() {
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try {
            DataNation dataNation = new DataNation();
            Object object = karyawanService.getFile();
            if (!AppUtil.isObjectEmpty(object)){
                dataNation = karyawanService.responseData(object);
            }
            res.put("message", "success");
            res.put("status", "Ok");
            res.put("data", dataNation.getData());
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "false");
            res.put("message", e.getMessage());

            return ResponseEntity.badRequest()
                    .body(res);
        }
    }

    @PostMapping(path = "/produce", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(" producer ")
    public ResponseEntity producerAPI(@RequestBody Mail mail) {
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try {
            karyawanService.posterRestTemplate(mail);
            res.put("message", "success");
            res.put("status", "Ok");
            return ResponseEntity.ok().body(res);
        } catch (Exception e) {
            e.printStackTrace();
            res.put("status", "false");
            res.put("message", e.getMessage());

            return ResponseEntity.badRequest()
                    .body(res);
        }
    }
}
