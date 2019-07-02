package domain;

public class MaterialLineDetails {
    private Integer id;
    private Integer Amount;
    private String type;
    private String receive_date;
    private String ship_date;
    private String customer;
    private String reseller_discount;
    public MaterialLineDetails(Integer id, Integer amount, String type, String receive_date, String ship_date, String customer, String reseller_discount) {
        this.id = id;
        Amount = amount;
        this.type = type;
        this.receive_date = receive_date;
        this.ship_date = ship_date;
        this.customer = customer;
        this.reseller_discount = reseller_discount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReceive_date() {
        return receive_date;
    }

    public void setReceive_date(String receive_date) {
        this.receive_date = receive_date;
    }

    public String getShip_date() {
        return ship_date;
    }

    public void setShip_date(String ship_date) {
        this.ship_date = ship_date;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getReseller_discount() {
        return reseller_discount;
    }

    public void setReseller_discount(String reseller_discount) {
        this.reseller_discount = reseller_discount;
    }


}
