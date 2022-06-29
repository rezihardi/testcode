package com.sml.testcode.controller;

import com.sml.testcode.mapper.KaryawanMapper;
import com.sml.testcode.model.Karyawan;
import com.sml.testcode.util.AppUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequestMapping("batis/karyawan")
public class BatisController {
    @Autowired
    KaryawanMapper karyawanMapper;

    @GetMapping(path = "/get-all-karyawan", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(" test ")
    public ResponseEntity findRole() {
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try {
            System.out.println("teqs1");
            List<Karyawan> karyawans= karyawanMapper.getAllKaryawan();
            res.put("message", "success");
            res.put("status", "Ok");
            res.put("data", karyawans);
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
