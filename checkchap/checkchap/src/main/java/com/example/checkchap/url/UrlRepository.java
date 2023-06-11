package com.example.checkchap.url;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UrlRepository extends JpaRepository<Url, Long> {
    @Query("SELECT u FROM urls u WHERE u.url = :url")
    Url findByUrl(@Param("url") String url);
}
