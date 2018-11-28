package com.galvanize.badgearamareceptiondesk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

import java.net.URI;
import java.net.URISyntaxException;

import static java.lang.System.getenv;

@SpringBootApplication
//public class BadgeARamaReceptionDeskApplication implements RabbitListenerConfigurer {
public class BadgeARamaReceptionDeskApplication  {
    private static final Logger LOGGER = LoggerFactory.getLogger(BadgeARamaReceptionDeskApplication.class);


//    @Value("${amqp.exchange.name}")
//    private String appExchangeName;
//
//    @Value("${amqp.queue.name}")
//    private String appQueueName;
//
//    @Value("${amqp.routing.key}")
//    private String appRoutingKey;

    public static void main(String[] args) {
        SpringApplication.run(BadgeARamaReceptionDeskApplication.class, args);
    }

//    @Bean
//    public TopicExchange getAppExchange() {
//        return new TopicExchange(appExchangeName);
//    }
//
//    @Bean
//    public Queue getAppQueue() {
//        return new Queue(appQueueName);
//    }
//
//    @Bean
//    public Binding declareBindingApp() {
//        return BindingBuilder.bind(getAppQueue()).to(getAppExchange()).with(appRoutingKey);
//    }
//
//    @Bean
//    public MappingJackson2MessageConverter consumerJackson2MessageConverter() {
//        return new MappingJackson2MessageConverter();
//    }
//
//    @Bean
//    public DefaultMessageHandlerMethodFactory messageHandlerMethodFactory() {
//        DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
//        factory.setMessageConverter(consumerJackson2MessageConverter());
//        return factory;
//    }
//
//    @Override
//    public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
//        registrar.setMessageHandlerMethodFactory(messageHandlerMethodFactory());
//    }
//
    /*
    c2749bc1-4164-4657-a148-c9ac4865966d
    amqp://edghejse:y2cDeFD0MxAKbfPlkzHZZrh_xpF5BIV5@barnacle.rmq.cloudamqp.com/edghejse
     */

//    @Bean
//    public ConnectionFactory connectionFactory() {
//        final URI rabbitMqUrl;
//        try {
//            rabbitMqUrl = new URI(getEnvOrThrow("CLOUDAMQP_URL"));
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        }
//
//        final CachingConnectionFactory factory = new CachingConnectionFactory();
//        factory.setUsername(rabbitMqUrl.getUserInfo().split(":")[0]);
//        factory.setPassword(rabbitMqUrl.getUserInfo().split(":")[1]);
//        factory.setHost(rabbitMqUrl.getHost());
//        factory.setPort(rabbitMqUrl.getPort());
//        factory.setVirtualHost(rabbitMqUrl.getPath().substring(1));
//
//        return factory;
//    }
//
//
//    private static String getEnvOrThrow(String name) {
//        final String env = getenv(name);
//        LOGGER.info("try to find env: {}", name);
//        if (env == null) {
//            throw new IllegalStateException("Environment variable [" + name + "] is not set.");
//        }
//        return env;
//    }

}
