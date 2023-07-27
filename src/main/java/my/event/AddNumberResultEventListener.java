package my.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class AddNumberResultEventListener implements ApplicationListener<AddNumEvent>,Ordered {

	private Integer num;
	private int order;
	public AddNumberResultEventListener(Integer num, int order) {
		this.num = num;
		this.order = order;
	}
	
	@Override
	public void onApplicationEvent(AddNumEvent event) {
		log.info("{} receive event: {}", this, event);
		processLogic(event);
	}

	private void processLogic(AddNumEvent event) {
		event.addItem(this.num);
	}
	
	@Override
	public int getOrder() {
		return order;
	}
	
	
}
