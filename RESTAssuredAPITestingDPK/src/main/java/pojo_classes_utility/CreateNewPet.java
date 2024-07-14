package pojo_classes_utility;

import java.util.List;

public class CreateNewPet {

	private long id;
	private Category category;
	private String name;
	private List<String> photoUrls;
	private List<Tags> tags;
	private String status;
	
	
	
	
	public CreateNewPet() {
		super();
	}




	public CreateNewPet(long id, Category category, String name, List<String> photoUrls, List<Tags> tags,
			String status) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.photoUrls = photoUrls;
		this.tags = tags;
		this.status = status;
	}




	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public Category getCategory() {
		return category;
	}




	public void setCategory(Category category) {
		this.category = category;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public List<String> getPhotoUrls() {
		return photoUrls;
	}




	public void setPhotoUrls(List<String> photoUrls) {
		this.photoUrls = photoUrls;
	}




	public List<Tags> getTags() {
		return tags;
	}




	public void setTags(List<Tags> tags) {
		this.tags = tags;
	}




	public String getStatus() {
		return status;
	}




	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
}
