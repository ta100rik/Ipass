package domain;

public class Users {
    private Integer id;
    private String email;
    private String rol;
    private String vendor;
    public Users(Integer id, String em,String rol,String vn){
        this.id = id;
        this.email = em;
        this.rol = rol;
        this.vendor = vn;
    }
    public Users(Integer id, String em,String rol){
        this.id = id;
        this.email = em;
        this.rol = rol;
        this.vendor = "";
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getRol() {
        return rol;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
}
