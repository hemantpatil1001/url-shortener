package com.urlytics.shorttrace_service.respository;

import com.urlytics.shorttrace_service.constants.SqlConstants;
import com.urlytics.shorttrace_service.model.ShortUrlEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ShortUrlJdbcRepository {
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int insertUrlHash(ShortUrlEntity shortUrlEntity) {
        String sql = SqlConstants.INSERT_INTO_SHORT_URLS;

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(SqlConstants.PARAM_ORIGINAL_URL, shortUrlEntity.getOriginalUrl());
        params.addValue(SqlConstants.PARAM_SHORT_CODE, shortUrlEntity.getShortCode());
        params.addValue(SqlConstants.PARAM_EXPIRY_AT, shortUrlEntity.getExpiryAt());
        params.addValue(SqlConstants.PARAM_CREATED_BY, shortUrlEntity.getCreatedBy());

        return namedParameterJdbcTemplate.update(sql, params);
    }

    public String getOriginalUrl(String urlHash){
        String sql = "Select * from short_urls where short_code = :urlHash";
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("urlHash",urlHash);
        ShortUrlEntity shortUrlEntity =  namedParameterJdbcTemplate.queryForObject(sql, params,new BeanPropertyRowMapper<>(ShortUrlEntity.class));
        return shortUrlEntity.getOriginalUrl();
    }
}
