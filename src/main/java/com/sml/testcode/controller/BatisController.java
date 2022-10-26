package com.sml.testcode.controller;

import com.sml.testcode.mapper.KaryawanMapper;
import com.sml.testcode.model.Karyawan;
import com.sml.testcode.repository.KaryawanRepository;
import com.sml.testcode.util.AppUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/batis/karyawan")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BatisController {
    @Autowired
    KaryawanMapper karyawanMapper;

    @Autowired
    KaryawanRepository karyawanRepository;

    @GetMapping(path = "/get-all-karyawan", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(" test ")
    public ResponseEntity findRole() {
        LinkedHashMap<String, Object> res = new LinkedHashMap<>();
        try {
            List<Karyawan> karyawans = karyawanMapper.getAllKaryawan();
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

    @Scheduled(cron = "0 0/1 * 1/1 * ?") //tiap menit
    public void cronJobSch() {

        System.out.println("mulai job");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String strDate = sdf.format(now);
        Karyawan karyawan = new Karyawan();
        Long lastNik = karyawanMapper.findLastId();
        karyawan.setNik(AppUtil.isObjectEmpty(lastNik) ? 1 : lastNik + 1);
        karyawan.setNama("increment");
        karyawan.setAlamat("x-sari");
        karyawanMapper.save(karyawan);
        System.out.println("Java cron job expression:: " + strDate);
    }
}
