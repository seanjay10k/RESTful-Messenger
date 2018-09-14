package JAXRSMessenger.messenger.resources;


import java.util.List;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import JAXRSMessenger.messenger.model.Message;
import JAXRSMessenger.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService=new MessageService();
	
	//HOOK to subresource-CommentResource
	//no httpmethod declared here
	//no matter what httpmethod is accesed, what jersey will do is go in hjere and trigger CommentResource instance
	@Path("/{messageid}/comments")
	public CommentResource getCommentResource() {
		return new CommentResource();
	}
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessage(@QueryParam("year") int year,
									@QueryParam("start") int start,
									@QueryParam("size")int size) {//messages?year=2017       messages?start=2&size=10
		if (year>0) {
			return messageService.getAllMessageYear(year);
		}
		if(start>0&size>=0) {
			return messageService.getAllMessagesPaginated(start, size);
		}
		
		return messageService.getAllMessages();
	}
	
		
	
	@DELETE
	@Path("/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message deleteMessage(@PathParam("Id" )Long Id) {//messages/2
		
		return messageService.removeMessage(Id);
	}
	
	
	@PUT
	@Path("/{Id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message putMessage(@PathParam("Id")Long Id,Message message) {//messages/2  and in body of http put request is type Message in json 
		message.setId(Id);
		return messageService.updateMessage(message);
		
	}
	
	@GET
	@Path("/{Id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("Id")long Id) {//messages/2
				
		return messageService.getMessage(Id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message postMessage(Message message) {//messages  and in body of http put request is type Message in json 
		return messageService.addMessage(message);
	}
	
}
