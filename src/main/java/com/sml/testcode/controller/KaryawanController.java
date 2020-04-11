package com.sml.testcode.controller;

import com.sml.testcode.exception.ResourceNotFoundException;
import com.sml.testcode.model.Karyawan;
import com.sml.testcode.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class KaryawanController {
    @Autowired
    KaryawanRepository karyawanRepository;

    @GetMapping("/getdatakaryawan")
    public List<Karyawan> getAllKaryawan() {
        return karyawanRepository.findAll();
    }

    @GetMapping("/getdatakaryawan/{nik}")
    public ResponseEntity<Karyawan> getKaryawanByNik(@PathVariable(value = "nik") Long karyawanNik)
            throws ResourceNotFoundException {
        Karyawan karyawan = karyawanRepository.findById(karyawanNik)
                .orElseThrow(() -> new ResourceNotFoundException("Nik Karyawan tidak ditemukan :: " + karyawanNik));
        return ResponseEntity.ok().body(karyawan);
    }



    @PostMapping("/postdatakaryawan")
    public Karyawan createKaryawan(@Valid @RequestBody Karyawan karyawan) {
        return karyawanRepository.save(karyawan);
    }

    @PutMapping("/editdatakaryawan/{nik}")
    public ResponseEntity<Karyawan> updateKaryawan(@PathVariable(value = "nik") Long karyawanNik,
                                                   @Valid @RequestBody Karyawan karyawanDetails) throws ResourceNotFoundException {
        Karyawan karyawan = karyawanRepository.findById(karyawanNik)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + karyawanNik));

        karyawan.setNama(karyawanDetails.getNama());
        karyawan.setAlamat(karyawanDetails.getAlamat());
        final Karyawan updatedKaryawan = karyawanRepository.save(karyawan);
        return ResponseEntity.ok(updatedKaryawan);
    }

    @DeleteMapping("/deletedatakaryawan/{nik}")
    public Map<String, Boolean> deleteKaryawan(@PathVariable(value = "nik") Long karyawanNik)
            throws ResourceNotFoundException {
        Karyawan karyawan = karyawanRepository.findById(karyawanNik)
                .orElseThrow(() -> new ResourceNotFoundException("data karyawan not found for this id :: " + karyawanNik));
        karyawanRepository.delete(karyawan);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/karyawans")
    public String showKaryawan() {
        return "karyawan";
    }

}
