package JAXRSMessenger.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import JAXRSMessenger.messenger.database.DatabaseClass;
import JAXRSMessenger.messenger.model.Message;

public class MessageService {
	
	
	private Map<Long,Message> messages= DatabaseClass.getMessages();
	
	public MessageService() {
		messages.put(1L,new Message(1L,"Hello Mars!","Superman"));
		messages.put(2L,new Message(2L,"Hello Earth","Batman"));
	}
	
	
	public List<Message> getAllMessageYear(int year){
		List<Message> messageForYear=new ArrayList<>();
		Calendar cal= Calendar.getInstance();
		
		for(Message msg: messages.values()) {
			cal.setTime(msg.getCreated());
			if(cal.get(Calendar.YEAR)==year) {
				messageForYear.add(msg);
			}
		}
		
				
				return messageForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start,int size){
		 ArrayList<Message> messagesPaginated= new ArrayList<>(messages.values());
		 if(start+size>messages.size()) return new ArrayList<Message>();
		 
		 return messagesPaginated.subList(start, start+size);
	}
	
	
	
	//returns all the massages
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());
		
	}
	
	//given a id, returns a message
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	//given a message, adds the message to the map with automatic proper id and returns the message back as confirmation
	public Message addMessage(Message message) {
		message.setId(messages.size()+1);
		messages.put(message.getId(), message);
		return message;		
	}
	
	//now, to update you need a new message and id of message to access the map
	// put messages/2 "i want this to be updated"--> read the id, create a new message object with this id, and call this method
	public Message updateMessage(Message message) {
		if(message.getId()<=0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	//to remove you just need the id
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
	
	
}
