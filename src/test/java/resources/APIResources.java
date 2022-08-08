package resources;

public enum APIResources {

	PostUser("/Users"),
	DeleteUser("/Users/");

	private String resource;

	 APIResources(String resource) {
      this.resource = resource;
}

	public String getResource() {
		return resource;
	}

}
