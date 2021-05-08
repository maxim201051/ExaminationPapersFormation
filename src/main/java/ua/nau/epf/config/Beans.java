package ua.nau.epf.config;

import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.module.SimpleModule;
import javafx.util.Pair;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.nau.epf.util.JavaFXPairCustomDeserializer;

@Configuration
public class Beans {
    @Bean
    public Module dynamoDemoEntityDeserializer() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Pair.class, new JavaFXPairCustomDeserializer());
        return module;
    }
}
