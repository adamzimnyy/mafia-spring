package adamzimny.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by adamz on 05.11.2016.
 */
@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Bean
    public Executor taskScheduler() {
        return Executors.newScheduledThreadPool(10);
    }
}
