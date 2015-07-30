package website.livemarketing.dao;

import org.springframework.stereotype.Repository;

import website.livemarketing.model.Price;

@Repository("priceDao")
public class PriceDao extends SuperDao<Price,Integer> {
}
