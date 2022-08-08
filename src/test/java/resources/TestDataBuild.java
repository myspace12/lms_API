package resources;

import java.util.Map;

public class TestDataBuild {

	public static String userpostPayLoad(Map<String, String> xl) {
		
		String UserPost = "{\n"
				+ "  \"comments\": \""+xl.get("Comments")+"\",\n"
				+ "  \"education_pg\": \""+xl.get("Education_pg")+"\",\n"
				+ "  \"education_ug\": \""+xl.get("Education_ug")+"\",\n"
				+ "  \"linkedin_url\": \""+xl.get("LinkedIn")+"\",\n"
				+ "  \"location\": \""+xl.get("Location")+"\",\n"
				+ "  \"name\": \""+xl.get("Name")+"\",\n"
				+ "  \"phone_number\":\""+xl.get("Phone")+"\",\n"
				+ "  \"time_zone\": \""+xl.get("Zone")+"\",\n"
				+ "  \"visa_status\": \""+xl.get("Visa")+"\"\n"
				+ "}";
		
		return UserPost;
	}

}
