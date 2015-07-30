package website.livemarketing.dao;

import org.springframework.stereotype.Repository;

import website.livemarketing.model.Tag;

@Repository("tagDao")
public class TagDao extends SuperDao<Tag,Integer> {
}
