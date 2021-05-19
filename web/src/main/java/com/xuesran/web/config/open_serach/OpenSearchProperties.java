package com.xuesran.web.config.open_serach;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * The type Open search properties.
 *
 * @author xueshun
 */
@Data
@ConfigurationProperties(prefix = OpenSearchProperties.PREFIX)
public class OpenSearchProperties {
    /**
     * The constant PREFIX.
     */
    public static final String PREFIX = "open-search";
    private String appName;
    private String accessKey;
    private String secret;
    private String host;
}
