package website.livemarketing.dao;

import org.springframework.stereotype.Repository;

import website.livemarketing.model.PromotionType;

@Repository("promotionTypeDao")
public class PromotionTypeDao extends SuperDao<PromotionType,Integer> {
}
