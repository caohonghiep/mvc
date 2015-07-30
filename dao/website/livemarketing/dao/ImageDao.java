package website.livemarketing.dao;

import org.springframework.stereotype.Repository;

import website.livemarketing.model.Image;

@Repository("imageDao")
public class ImageDao extends SuperDao<Image,Integer> {
}
