package service;

import domain.Deal;
import persistence.DealMysqlDao;

import java.util.List;
/*
 *   here we specify where the deal data comes from
 * */
public class DealServiceProvider {
    public DealMysqlDao DMD = new DealMysqlDao();
    public List<Deal> getDeals(){
        return DMD.getDeals();
    }
    public Deal getDeal(String id){return DMD.getDeal(id);};
}
