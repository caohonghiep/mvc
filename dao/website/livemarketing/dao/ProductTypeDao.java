package website.livemarketing.dao;

import org.springframework.stereotype.Repository;

import website.livemarketing.model.ProductType;

@Repository("productTypeDao")
public class ProductTypeDao extends SuperDao<ProductType,Integer> {
}
