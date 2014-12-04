package App;

import java.util.LinkedList;



public class EventDispatchQueue {
	
	private LinkedList<GameEvent> eventQueue;
	private static EventDispatchQueue instance = new EventDispatchQueue();
	
	private EventDispatchQueue(){
		eventQueue = new LinkedList<GameEvent>();
	}
	
	public synchronized void addEvent(GameEvent newEvent){
		System.out.println("New event!");
		eventQueue.add(newEvent);
	}
	
	public synchronized GameEvent getEvent(){
		return eventQueue.removeFirst();
	}
	
	public synchronized boolean isEmpty(){
		return eventQueue.isEmpty();
	}
	
	public static EventDispatchQueue getInstance(){
		return instance;
	}
	
	public static void resetInstance(){
		instance = new EventDispatchQueue();
	}
	
}
