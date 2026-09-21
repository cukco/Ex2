package com.example.library.Repository;

import com.example.library.Model.Supply;
import org.hibernate.annotations.processing.SQL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplyRepo extends JpaRepository<Supply, Long> {

    @Query(value= "select s from Supply s where s.name like %:keyword%")
    List<Supply> findByKeyword(@Param("keyword") String keyword);
}
