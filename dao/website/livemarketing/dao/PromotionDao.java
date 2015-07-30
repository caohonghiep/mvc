package website.livemarketing.dao;

import org.springframework.stereotype.Repository;

import website.livemarketing.model.Promotion;

@Repository("promotionDao")
public class PromotionDao extends SuperDao<Promotion,Integer> {	
}
