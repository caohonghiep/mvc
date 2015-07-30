package website.livemarketing.dao;

import org.springframework.stereotype.Repository;

import website.livemarketing.model.Product;

@Repository("productDao")
public class ProductDao extends SuperDao<Product,Integer> {
}
