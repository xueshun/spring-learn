package com.xuesran.web.config.open_serach;

import com.aliyun.opensearch.DocumentClient;
import com.aliyun.opensearch.OpenSearchClient;
import com.aliyun.opensearch.sdk.generated.OpenSearch;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The type Open search config.
 *
 * @author xueshun
 */
@Configuration
@EnableConfigurationProperties(OpenSearchProperties.class)
public class OpenSearchConfig {
    private final OpenSearchProperties openSearchProperties;

    public OpenSearchConfig(OpenSearchProperties openSearchProperties) {
        this.openSearchProperties = openSearchProperties;
    }

    @Bean
    public OpenSearchClient openSearchClient() {
        return new OpenSearchClient(new OpenSearch(openSearchProperties.getAccessKey(),
                openSearchProperties.getSecret(),
                openSearchProperties.getHost()));
    }

    @Bean
    public DocumentClient documentClient(){
        return new DocumentClient(openSearchClient());
    }
}
