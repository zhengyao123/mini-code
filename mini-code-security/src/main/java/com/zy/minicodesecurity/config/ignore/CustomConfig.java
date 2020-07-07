package com.zy.minicodesecurity.config.ignore;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * date:  2020-07-07 14:58
 *
 * @author zhengyao
 */
@Data
@ConfigurationProperties(prefix = "custom.config")
public class CustomConfig {
    /**
     * 不需要拦截的地址
     */
    private IgnoreConfig ignores;
}
