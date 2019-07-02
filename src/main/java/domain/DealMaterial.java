package domain;

import java.util.ArrayList;
import java.util.List;

public class DealMaterial {
    private Integer id;
    private String VPN;
    private Float purchasing_price;
    private List<MaterialLineDetails> mld = new ArrayList<MaterialLineDetails>();

    public DealMaterial(Integer id, String VPN, Float purchasing_price) {
        this.id = id;
        this.VPN = VPN;
        this.purchasing_price = purchasing_price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVPN() {
        return VPN;
    }

    public void setVPN(String VPN) {
        this.VPN = VPN;
    }

    public Float getPurchasing_price() {
        return purchasing_price;
    }

    public void setPurchasing_price(Float purchasing_price) {
        this.purchasing_price = purchasing_price;
    }

    public List<MaterialLineDetails> getMld() {
        return mld;
    }

    public void setMld(MaterialLineDetails mld) {
        this.mld.add(mld);
    }
    public void add_details(MaterialLineDetails mld){
        this.mld.add(mld);
    }
}
