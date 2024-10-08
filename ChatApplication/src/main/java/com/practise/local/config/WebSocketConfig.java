package com.practise.local.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.DefaultContentTypeResolver;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

import java.util.List;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
	/**
	 * Configure message broker options.
	 */

	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		registry.enableSimpleBroker("/user");
		registry.setApplicationDestinationPrefixes("/app");
		registry.setUserDestinationPrefix("/user");
		System.out.println("configureMessageBroker ::" + registry);// by fardeen

	}

	/**
	 * Register STOMP endpoints mapping each to a specific URL and (optionally)
	 * enabling and configuring SockJS fallback options.
	 */
	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/ws").withSockJS();
		System.out.println("registerStompEndpoints ::" + registry);// by fardeen
	}

	/**
	 * Configure the message converters to use when extracting the payload of
	 * messages in annotated methods and when sending messages (e.g. through the
	 * "broker" SimpMessagingTemplate).
	 * <p>
	 * The provided list, initially empty, can be used to add message converters
	 * while the boolean return value is used to determine if default message should
	 * be added as well.
	 * 
	 * @param messageConverters the converters to configure (initially an empty
	 *                          list)
	 * @return whether to also add default converter or not
	 */
	@Override
	public boolean configureMessageConverters(List<MessageConverter> messageConverters) {
		DefaultContentTypeResolver resolver = new DefaultContentTypeResolver();
		resolver.setDefaultMimeType(MimeTypeUtils.APPLICATION_JSON);
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setObjectMapper(new ObjectMapper());
		converter.setContentTypeResolver(resolver);
		messageConverters.add(converter);
		System.out.println("configureMessageBroker ::" + messageConverters);// by fardeen
		return false;
	}
}
