package my.event;

import java.util.LinkedList;

import org.springframework.context.ApplicationEvent;

import lombok.Data;

@Data
public class StockQueryEvent extends ApplicationEvent {

	public StockQueryEvent(Object source) {
		super(source);
	}

	private String warehouseId;
	
	//
	private ResultModel result;  
	
	private LinkedList<Integer> intList = new LinkedList<Integer>();
	
	public void addItem(Integer item) {
		intList.add(item);
	}
}
