package persistence;

import domain.Deal;

import java.util.List;

public interface DealDao {
    public List<Deal> getDeals();
}
