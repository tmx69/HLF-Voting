package Models;

public class EnrollUser {
    private String name;
    private String secret;
    private String org;

    public EnrollUser(String name, String secret, String org, String msp){
        this.name = name;
        this.secret = secret;
        this.org = org;
    }

    public String getName() { return this.name; }
    public String getSecret() { return this.secret; }
    public String getOrg() { return this.org; }
}
