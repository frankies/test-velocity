package my.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ResultEventListener implements ApplicationListener<StockQueryEvent> {

	@Override
	public void onApplicationEvent(StockQueryEvent event) {
		log.info("Receive event: {}", event);
		processLogic(event);
	}

	private void processLogic(StockQueryEvent event) {
		event.setResult(ResultModel.builder().result("Ok").build());
	}
	
	
}
