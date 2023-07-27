package my.event;

import java.util.LinkedList;

import org.springframework.context.ApplicationEvent;

import lombok.Data;

@Data
public class AddNumEvent extends ApplicationEvent {

	public AddNumEvent(Object source) {
		super(source);
	}
	private LinkedList<Integer> intList = new LinkedList<Integer>();
	public void addItem(Integer item) {
		intList.add(item);
	}
}
