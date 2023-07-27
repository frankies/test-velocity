package my.event;

import org.springframework.context.ApplicationEvent;

public interface EventPublisher {

	<T extends ApplicationEvent> void publish(T event);

}