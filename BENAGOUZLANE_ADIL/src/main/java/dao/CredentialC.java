package dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import Entities.student;
import Entities.Book;
import tools.Myconnection;

public class CredentialC {
	
	public static int AddEutdaint(int id,String Nom,String Prenom,int Age,String log,String pass)  {
	
		Myconnection.Connect();
		String sql="insert into etudiant(ide,Nom,Prenom,Age,log,pass) VALUES ('"+id+"','"+Nom+"','"+Prenom+"','"+Age+"','"+log+"','"+pass+"')";
		int nb=Myconnection.Maj(sql);
		Myconnection.disconnect();
		return nb;
		
	}
	public static student Authentification(String l, String p) {
		student u=null;
		Myconnection.Connect();
		String sql= "select * from etudiant where log ='"+l+"' and pass ='"+p+"'";
		ResultSet rs=Myconnection.select(sql);
		try {
			if(rs.next())
			{
			u= new student();
			u.setId(rs.getInt(1));
			u.setNom(rs.getString(2));
			u.setPrenom(rs.getString(3));
			u.setAge(rs.getInt(4));
			u.setLogin(rs.getString(5));
			u.setPass(rs.getString(6));
			}
			else
				return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
}

	public static int AddBook(int id,String titre,String NomA,String categorie,String date) {
		
		Myconnection.Connect();
		String sql="insert into livers(id,titre,Nom_Auteur,categorie,date_edition) VALUES ('"+id+"','"+titre+"','"+NomA+"','"+categorie+"','"+date+"')";
		int nb=Myconnection.Maj(sql);
		Myconnection.disconnect();
		return nb;
		
		}
    
	public static List<Book> allBook() throws SQLException{
        Book b;
    	List<Book> us=new ArrayList<Book>();
    	Myconnection.Connect();
        ResultSet res=Myconnection.select("select * from livers");
        try { 
			while(res.next()) {
				b=new Book();
				b.setIdb(res.getInt(1));
				b.setNoml(res.getString(2));
				b.setAuteur(res.getString(3));
				b.setCategory(res.getString(4));
				b.setDate_edition(res.getString(5));
				us.add(b);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return us;
    }
}
