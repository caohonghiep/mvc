package website.livemarketing.service;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.criterion.Criterion;

import website.livemarketing.dao.SuperDao;


@SuppressWarnings("rawtypes")
public class SuperService<D extends SuperDao, T, PK extends Serializable> {

	protected D dao;
	protected Class<T> entityClass;	

	@SuppressWarnings("unchecked")
	public SuperService() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		try {
			this.dao = ((Class<D>) genericSuperclass.getActualTypeArguments()[0]).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[1];
	}

	public T insert(T t) {
		return (T) dao.insert(t);
	}

	public T find(Serializable id) {
		return (T) dao.find(id);
	}

	public T update(T t) {
		return (T) dao.update(t);
	}

	public void delete(T t) {
		dao.delete(t);

	}

	public void deleteById(Serializable id) {
		dao.deleteById(id);
	}

	public List<T> findAll() {
		return dao.findAll();
	}

	public List<T> findByCriteria(Criterion... criterion) {
		return dao.findByCriteria(criterion);
	}

	public List<T> findByCriteria(int firstResult, int maxResults,
			Criterion... criterion) {
		return dao.findByCriteria(firstResult, maxResults, criterion);
	}

	public long countByCriteria(Criterion... criterion) {
		return dao.countByCriteria(criterion);
	}

}
