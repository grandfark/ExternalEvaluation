package model;

public class Goods {
	private String id;//��ǰ��ȣ
	private String name;//��ǰ��
	private Integer price;//����
	private String made;//������
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getMade() {
		return made;
	}
	public void setMade(String made) {
		this.made = made;
	}
}
