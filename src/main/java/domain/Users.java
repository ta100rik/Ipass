package domain;

public class Users {
    private Integer id;
    private String email;
    private String rol;
    private String password;
    public Users(Integer id, String em,String rol, String password){
        this.id = id;
        this.email = em;
        this.rol = rol;
        this.password = password;
    }

}
