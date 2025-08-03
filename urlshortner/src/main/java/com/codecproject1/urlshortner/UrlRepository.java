package com.codecproject1.urlshortner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends JpaRepository<UrlEntity, Long> {
    Optional<UrlEntity> findByUrlKey(String urlKey);
    Optional<UrlEntity> findByOriginalUrl(String originalUrl);
}