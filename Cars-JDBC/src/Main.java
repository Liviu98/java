import java.sql.*;

public class Main {
	
	public static void UpdateCars(Statement statement) throws Exception {
		 statement.executeUpdate("update cars set model = 'Octavia', marca = 'Skoda' where id = 4");
	}
	
	public static void InsertCar(PreparedStatement statement, int id, String model, String marca, int pret) throws SQLException{
		statement.setInt(1, id);
		statement.setString(2, marca);
		statement.setString(3, model);
		statement.setInt(4, pret);
	}

	public static void main(String[] args) {
		
		String user = "liviu";
		String password = "Adiacenta98#";
		
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/liviudb",user,password);
			
			PreparedStatement pst = con.prepareStatement("insert into cars values(?,?,?,?)");
			InsertCar(pst, 5, "Vectra C", "Opel", 3500);
			//pst.execute();
			
			Statement st = con.createStatement();
			//UpdateCars(st);
			ResultSet result = st.executeQuery("select * from cars");
			
			//result.absolute(3);
			while(result.next()) {
				System.out.println(result.getString(3) + " " + result.getString(2) + " " + result.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
