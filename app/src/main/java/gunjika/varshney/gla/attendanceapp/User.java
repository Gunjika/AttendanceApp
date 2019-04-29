package gunjika.varshney.gla.attendanceapp;

public class User {
    public String name;
    public String Uid;
    public String EmailId;
    public String pass;


    public User(String uid, String name, String emailId,String pass) {
        this.name = name;
        this.Uid = uid;
        this.EmailId = emailId;
        this.pass=pass;

    }

    public String getName() {
        return name;
    }

    public String getUid() {
        return Uid;
    }

    public String getEmailId() {
        return EmailId;
    }

    public String getPass() {
        return pass;
    }
}
