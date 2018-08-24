public class Config {
    public String getUrl() {
        return "jdbc:mysql://localhost/adLister_db?serverTimezone=UTC&useSSL=false";
    }
    public String getUsername() {
        return "ad_user";
    }
    public String getPassword() {
        return "px";
    }
}
