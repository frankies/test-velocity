package my.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class DefaultEventPublisher implements ApplicationEventPublisherAware, EventPublisher {

	private ApplicationEventPublisher publisher;
	
	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}
	
	@Override
	public <T extends ApplicationEvent> void publish(T event) {
		this.publisher.publishEvent(event);
	};

}
