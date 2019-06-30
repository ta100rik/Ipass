package domain;

public class Users {
    private Integer id;
    private String email;
    private String rol;
    public Users(Integer id, String em,String rol){
        this.id = id;
        this.email = em;
        this.rol = rol;
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
}
