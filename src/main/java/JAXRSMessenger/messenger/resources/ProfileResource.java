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
import javax.ws.rs.core.MediaType;


import JAXRSMessenger.messenger.model.Profile;
import JAXRSMessenger.messenger.service.ProfileService;


@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
public class ProfileResource {
	
	private ProfileService profileService= new ProfileService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Profile> getProfiles() {
		return profileService.getProfiles();
	}
	
	@GET
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile getProfile(@PathParam("profileName")String profileName) {
		return profileService.getProfile(profileName);
	}
	
	@POST 
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile postProfile(Profile profile) {
		profileService.addProfile(profile);
		return profile;
	}
	
	@PUT
	@Path("/{profileName}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Profile updateProfile(@PathParam("profileName") String profileName,Profile profile ) {
		profile.setProfileName(profileName);
		return profileService.updateProfile(profile);	
	}
	
	@DELETE
	@Path("/{profileName}")
	@Produces(MediaType.APPLICATION_JSON)
	public Profile deleteProfile(@PathParam("profileName")String profileName) {
		
		return profileService.deleteProfile(profileName);
	}
	
	

}
