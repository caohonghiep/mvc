package website.livemarketing.dao;

import org.springframework.stereotype.Repository;

import website.livemarketing.model.TradeMark;

@Repository("tradeMarkDao")
public class TradeMarkDao extends SuperDao<TradeMark,Integer> {
}
