package domain;

public class Deal {
    public int id;
    public String dealname;
    public String one_time_benefit;

    public Deal(int id, String dealname, String one_time_benefit) {
        this.id = id;
        this.dealname = dealname;
        this.one_time_benefit = one_time_benefit;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDealname() {
        return dealname;
    }

    public void setDealname(String dealname) {
        this.dealname = dealname;
    }

    public String getOne_time_benefit() {
        return one_time_benefit;
    }

    public void setOne_time_benefit(String one_time_benefit) {
        this.one_time_benefit = one_time_benefit;
    }
}
