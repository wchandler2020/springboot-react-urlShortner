package com.tiltedhat.urlShortnerAPI.repository;

import com.tiltedhat.urlShortnerAPI.model.UrlMapping;
import com.tiltedhat.urlShortnerAPI.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UrlMappingRepository extends JpaRepository<UrlMapping, Long> {
    UrlMapping findByShortUrl(String shortUrl);
    List<UrlMapping> findByUser(User user);
}
