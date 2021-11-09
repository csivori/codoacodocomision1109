
public class DB {
    String conn, db, usr, pwd;

    public DB(String db, String usr, String pwd) {
        this.db = db;
        this.usr = usr;
        this.pwd = pwd;
    }
    
    public void execute(String qry){
        if (uppercase(qry.charAt(0)) == "S") {/* stmt.executeUpdate */} else {/* stmt.executeQuery */}
    }
}
