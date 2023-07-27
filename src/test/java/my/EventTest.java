package my;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.slf4j.Slf4j;
import my.event.AddNumEvent;
import my.event.EventPublisher;
import my.event.StockQueryEvent;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/eventAppContext.xml")
public class EventTest {

	@Autowired
	EventPublisher ep;
	
	
	@Test
	public void testPublishQueryEvent() {
		assertNotNull(ep);
		StockQueryEvent  se = new StockQueryEvent(this);
		ep.publish(se);
		log.info("After processed: {}", se);
		assertNotNull(se.getResult());
		assertEquals("Ok", se.getResult().getResult());
	}
	
	
	@Test
	public void testPublishAddNumEvent() {
		assertNotNull(ep);
		AddNumEvent  se = new AddNumEvent(this);
		ep.publish(se);
		log.info("After processed: {}", se);
		assertNotNull(se.getIntList());
		assertEquals(2, se.getIntList().size());
	}

//	@Configuration
//	public class EventConfig {
//		
//		@Bean
//		public ApplicationListener<StockQueryEvent> two() {
//			return e -> {
//				e.addItem(2);
//			};
//		}
//		
//		@Bean
//		public ApplicationListener<StockQueryEvent> one() {
//			return e -> {
//				e.addItem(1);
//			};
//		}
//	}
 
}
