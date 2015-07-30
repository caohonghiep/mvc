package website.livemarketing.dao;

import org.springframework.stereotype.Repository;

import website.livemarketing.model.Category;

@Repository("categoryDao")
public class CategoryDao extends SuperDao<Category,Integer> {
}
