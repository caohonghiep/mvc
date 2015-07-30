package website.livemarketing.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import website.livemarketing.dao.CategoryDao;
import website.livemarketing.model.Category;



@Service("categoryService")
@Transactional
public class CategoryService extends SuperService<CategoryDao ,Category, Long>{

}
