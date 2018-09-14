package JAXRSMessenger.messenger.service;

import JAXRSMessenger.messenger.database.DatabaseClass;
import JAXRSMessenger.messenger.model.Comment;
import JAXRSMessenger.messenger.model.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {
    private Map<Long, Message> messages = DatabaseClass.getMessages();
    
    public List<Comment> getAllComments(long messageId) {
       Map<Long, Comment> comments = messages.get(messageId).getComments();
       return new ArrayList<Comment>(comments.values());
    }

    public Comment updateComment(long messageId, Comment comment) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
	comment.setId(comments.size() + 1);
	comments.put(comment.getId(), comment);
	return comment;
    }

    public Comment removeComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
	return comments.remove(commentId);
    }

    public Comment getComment(long messageId, long commentId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
