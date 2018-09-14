package JAXRSMessenger.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;


@Path("/login")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class login{
	@GET
	public Response login() {
	NewCookie cookie= new NewCookie("name","invalidquantum");
	return Response.ok("OK").cookie(cookie).build();
	}
}