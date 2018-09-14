package JAXRSMessenger.messenger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;



import JAXRSMessenger.messenger.database.DatabaseClass;
import JAXRSMessenger.messenger.model.Profile;

public class ProfileService {

	private Map<String,Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
		profiles.put("Ironman", new Profile(1L,"Ironman","Robert","Downey J.R"));
                profiles.put("Dr. Strange", new Profile(1L,"Dr. Strange","Benedict","Cumberbatch"));
                profiles.put("Hulk", new Profile(1L,"Hulk","Mark","Ruffalo"));
	}
	
	
	//gets all the profiles
	public List<Profile> getProfiles(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	//get a specific profile
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	//update existing profile
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}
		
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size()+1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	

//	private long id;
//	private String profileName;
//	private Date created;
//	private String firstName;
//	private String lastName;
//	
//	
}
