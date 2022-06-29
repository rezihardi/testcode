package com.sml.testcode.mapper;

import com.sml.testcode.model.Karyawan;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface KaryawanMapper {
    List<Karyawan> getAllKaryawan ();
}
