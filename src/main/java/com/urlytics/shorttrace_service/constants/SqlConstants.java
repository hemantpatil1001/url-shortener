package com.urlytics.shorttrace_service.constants;

public class SqlConstants {
    public static final String INSERT_INTO_SHORT_URLS = "INSERT INTO short_urls (original_url, short_code, expiry_at, created_by) VALUES (:originalUrl, :shortCode, :expiryAt, :createdBy)";
    public static final String PARAM_ORIGINAL_URL = "originalUrl";
    public static final String PARAM_SHORT_CODE = "shortCode";
    public static final String PARAM_EXPIRY_AT = "expiryAt";
    public static final String PARAM_CREATED_BY = "createdBy";
}
