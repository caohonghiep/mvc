package website.livemarketing.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import website.livemarketing.config.WebInitializer;

public class SuperDao<T , PK extends Serializable>{
	// http://stackoverflow.com/questions/3888575/single-dao-generic-crud-methods-jpa-hibernate-spring
	// http://www.bejug.org/confluenceBeJUG/display/BeJUG/Generic+DAO+example
	
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;
	
//	private SessionFactory sessionFactory;

	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public SuperDao() {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass()
				.getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass
				.getActualTypeArguments()[0];
		 
	}

	protected Session getSession() {
		if(sessionFactory==null){
			sessionFactory = (SessionFactory) WebInitializer.getBean("sessionFactory");
		}
		return sessionFactory.getCurrentSession();
	}
	
	public T insert(T t) {
		getSession().persist(t);
		return t;
	}

	public T find(PK id) {
		@SuppressWarnings("unchecked")
		T t = (T) getSession().get(entityClass, id);
		return t;
	}

	public T update(T t) {
		getSession().merge(t);
		return t;
	}

	public void delete(T t) {
		getSession().delete(t);
	}

	public void deleteById(PK id) {
		T t = find(id);
		delete(t);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		Criteria criteria = getSession().createCriteria(entityClass);
		List<T> list = (List<T>) criteria.list();
		return list;
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	public List<T> findByCriteria(Criterion... criterion) {
		return findByCriteria(-1, -1, criterion);
	}

	/**
	 * Use this inside subclasses as a convenience method.
	 */
	@SuppressWarnings("unchecked")
	public List<T> findByCriteria(final int firstResult, final int maxResults,
			final Criterion... criterion) {
		Criteria crit = getSession().createCriteria(entityClass);

		for (final Criterion c : criterion) {
			crit.add(c);
		}

		if (firstResult > 0) {
			crit.setFirstResult(firstResult);
		}

		if (maxResults > 0) {
			crit.setMaxResults(maxResults);
		}

		final List<T> result = crit.list();
		return result;
	}

	public long countByCriteria(Criterion... criterion) {
		Criteria crit = getSession().createCriteria(entityClass);
		crit.setProjection(Projections.rowCount());

		for (final Criterion c : criterion) {
			crit.add(c);
		}

		return (Integer) crit.list().get(0);
	}

}
