package service;

import domain.Deal;
import persistence.DealMysqlDao;

import java.util.List;

public class DealServiceProvider {
    public DealMysqlDao DMD = new DealMysqlDao();
    public List<Deal> getDeals(){
        return DMD.getDeals();
    }
}
