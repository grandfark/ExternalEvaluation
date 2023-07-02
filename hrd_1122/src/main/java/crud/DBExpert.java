package crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Goods;
import model.GoodsOrder;
import model.Order;

public class DBExpert {
	private String driver="oracle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@//localhost:1521/orcl";
	private Connection con=null;
	private PreparedStatement pstmt = null;
	private ResultSet rs=null;
	//상품번호(id)와 고객번호(no)로 주문정보 삭제
	public void deleteOrderInfo(GoodsOrder go) {
		String delete="delete from goods_guests "
				+ "where id=? and no=?";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(delete);
			pstmt.setString(1, go.getId());
			pstmt.setInt(2, go.getNo());
			pstmt.executeUpdate();//delete실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
	}
	
	//상품번호로 주문정보(id,no)를 검색
	public ArrayList<GoodsOrder> getGoodsOrder(String id){
		String select="select id,no from goods_guests "
				+ "where id=?";
		ArrayList<GoodsOrder> list =
				new ArrayList<GoodsOrder>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();//select 실행
			while(rs.next()) {
				GoodsOrder go = new GoodsOrder();
				go.setId(rs.getString(1));
				go.setNo(rs.getInt(2));
				list.add(go);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	
	public void deleteGoods(String id) {
		String delete ="delete from goods_info "
				+ "where id=?";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(delete);
			pstmt.setString(1, id);
			pstmt.executeUpdate();//delete실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {pstmt.close();con.close();}
			catch(Exception e) {}
		}
	}
	
	public ArrayList<Goods> getGoodsList(){
		String select="select id,name,price,made "
				+ "from goods_info";
		ArrayList<Goods> list = new ArrayList<Goods>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Goods g = new Goods();
				g.setId(rs.getString(1));
				g.setName(rs.getString(2));
				g.setPrice(rs.getInt(3));
				g.setMade(rs.getString(4));
				list.add(g);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
	public void registerGoods(Goods g) {
		String insert="insert into goods_info values(?,?,?,?)";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setString(1, g.getId());
			pstmt.setString(2, g.getName());
			pstmt.setInt(3, g.getPrice());
			pstmt.setString(4, g.getMade());
			pstmt.executeUpdate();//insert실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
	}
	
	public void updateGoods(Goods g) {
		String update="update goods_info set name=?, "
				+ "price=?, made=? where id=?";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(update);
			pstmt.setString(1, g.getName());
			pstmt.setInt(2, g.getPrice());
			pstmt.setString(3, g.getMade());
			pstmt.setString(4, g.getId());
			pstmt.executeUpdate();//update실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {pstmt.close(); con.close();
			}catch(Exception e) {}
		}
	}
	
	public Goods getGoodsById(String id) {
		String select="select id,name,price,made "
				+ "from goods_info where id=?";
		Goods goods = null;//조회결과 저장을 위한 변수 선언
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				goods = new Goods();
				goods.setId(rs.getString(1));//상품번호
				goods.setName(rs.getString(2));//상품이름
				goods.setPrice(rs.getInt(3));//상품가격
				goods.setMade(rs.getString(4));//원산지
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();pstmt.close();con.close();
			}catch(Exception e) {}
		}
		return goods;
	}
	
	public ArrayList<String> getNations(){
		String select = "select distinct made from goods_info";
		ArrayList<String> nations = new ArrayList<String>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				nations.add(name);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return nations;
	}
	
	public void deleteOrder(String id,Integer no,String date) {
		String delete="delete from goods_guests "
				+ "where id=? and no=? and o_date=?";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(delete);
			pstmt.setString(1, id);
			pstmt.setInt(2, no);
			pstmt.setString(3, date);
			pstmt.executeUpdate();//delete쿼리 실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
	}
	
	public Integer getGuestNo(String name) {
		String select="select no from guests_info "
				+ "where name=?";
		Integer no = null;
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();//select실행
			if(rs.next()) no = rs.getInt(1);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return no;
	}
	
	public void putOrder(String id,String no,String date) {
		String insert="insert into goods_guests values(?,?,?)";
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(insert);
			pstmt.setString(1, id);
			pstmt.setInt(2, Integer.parseInt(no));
			pstmt.setString(3, date);
			pstmt.executeUpdate();//insert실행
			con.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmt.close(); con.close();
			}catch(Exception e) {}
		}
	}
	
	public ArrayList<Integer> getGuestNo(){
		String select = "select no from guests_info";
		ArrayList<Integer> noList = new ArrayList<Integer>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Integer no = rs.getInt(1);
				noList.add(no);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return noList;
	}
	
	public ArrayList<String> getGoodsId(){
		String select = "select id from goods_info";
		ArrayList<String> idList = new ArrayList<String>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString(1);
				idList.add(id);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return idList;
	}
	
	public ArrayList<Order> getOrderList(){
		String select="select g.id, g.name, u.name, "
			+ "g.price, u.address, u.phone, gg.o_date "
			+ "from goods_info g, guests_info u, "
			+ "goods_guests gg "
			+ "where g.id = gg.id and u.no = gg.no";
		ArrayList<Order> list = new ArrayList<Order>();
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url,"hr","hr");
			pstmt=con.prepareStatement(select);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				Order order = new Order();
				order.setId(rs.getString(1));//상품번호
				order.setG_name(rs.getString(2));//상품이름
				order.setC_name(rs.getString(3));//주문자명
				order.setPrice(rs.getInt(4));//가격
				order.setAddr(rs.getString(5));//주소
				order.setPhone(rs.getString(6));//연락처
				order.setO_date(rs.getString(7));//주문일
				list.add(order);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close(); pstmt.close(); con.close();
			}catch(Exception e) {}
		}
		return list;
	}
	
}





