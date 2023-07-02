package model;

public class Order {
	private String id;//상품번호
	private String g_name;//상품이름
	private String c_name;//주문자 이름
	private Integer price;//상품가격
	private String addr;//주문자 주소
	private String phone;//연락처
	private String o_date;//주문일
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getO_date() {
		return o_date;
	}
	public void setO_date(String o_date) {
		this.o_date = o_date;
	}
}
