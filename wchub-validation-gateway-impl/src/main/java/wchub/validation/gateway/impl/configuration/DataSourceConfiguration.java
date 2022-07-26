package wchub.validation.gateway.impl.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

    @Bean(name = "validation")
    @ConfigurationProperties(prefix = "spring.validation.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "validation_jdbc")
    public JdbcTemplate validationJdbcTemplate(@Qualifier("validation") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}
