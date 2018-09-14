package JAXRSMessenger.messenger.resources;

import JAXRSMessenger.messenger.model.Comment;
import JAXRSMessenger.messenger.service.CommentService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class CommentResource {
    
    private CommentService commentService = new CommentService();
	
	@GET
	public List<Comment> getAllComments(@PathParam("messageId") long messageId) {
		return commentService.getAllComments(messageId);
	}
	
	@POST
	public Comment addComment(@PathParam("messageId") long messageId, Comment comment) {
		return commentService.addComment(messageId, comment);
	}
	
	@PUT
	@Path("/{commentId}")
	public Comment updateComment(@PathParam("messageId") long messageId, @PathParam("commentId") long id, Comment comment) {
		comment.setId(id);
		return commentService.updateComment(messageId, comment);
	}
	
	@DELETE
	@Path("/{commentId}")
	public void deleteComment(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		commentService.removeComment(messageId, commentId);
	}
        
	@GET
	@Path("/{commentId}")
	public Comment getMessage(@PathParam("messageId") long messageId, @PathParam("commentId") long commentId) {
		return commentService.getComment(messageId, commentId);
	}
    
    
    
    
    /*
	@GET
	public String test() {
		//localhost:8080/messenger/webapi/messages/1/comments ->
			//I am now in commentresource
		return "I am now in commentResource";
	}
	
	@GET
	@Path("/{commentId}")
	public String test2(@PathParam("commentId") Long commentId, @PathParam("messageid") Long messageid) {
		//return "I am now in commentResource sub path commentid "+ commentId;
		return "I am in commentResource accesing both commentid "+commentId+" and messageid "+messageid; 
	}
	//localhost:8080/messenger/webapi/messages/1/comments/1 -> I am now in commentResource sub path commentid 1
	//localhost:8080/messenger/webapi/messages/1/comments/1 -> I am in commentResource accesing both commentid 1 and messageid 1
    */
}
