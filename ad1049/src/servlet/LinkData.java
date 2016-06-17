package servlet;
import java.net.URL;
import java.util.Date;
 
import javax.jdo.annotations.*;

public class LinkData {
	@PrimaryKey
    @Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
    private String id;
     
    @Persistent
    private String pass;
     
    
    public LinkData(String id, String pass) {
        super();
        this.id = id;
        this.pass= pass;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getPass() {
        return pass;
    }
 
    public void setPass(String pass) {
        this.id = pass;
    }
}

