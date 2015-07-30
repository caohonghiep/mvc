package website.livemarketing.dao;

import org.springframework.stereotype.Repository;

import website.livemarketing.model.SortOrder;

@Repository("sortOrderDao")
public class SortOrderDao extends SuperDao<SortOrder,Integer> {
}
