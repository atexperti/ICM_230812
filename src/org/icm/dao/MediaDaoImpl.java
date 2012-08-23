package org.icm.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.icm.model.MediaMaster;
import org.springframework.transaction.annotation.Transactional;

public class MediaDaoImpl extends BaseDAOImpl implements IMediaDAO{

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getMedias(int size, String category) {
		// TODO Auto-generated method stub
		ArrayList<Object> medias = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<MediaMaster> from = criteriaQuery.from(MediaMaster.class);
			criteriaQuery.select(from);
			
			criteriaQuery.where(criteriaBuilder.and(criteriaBuilder.like(from.get("categoryMaster")
					.<String> get("categoryName"), "%" + category + "%")));
			
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));
			Query q = getEntityManager().createQuery(criteriaQuery);
			if(size != 0)
				q.setMaxResults(size);
			medias = (ArrayList<Object>) q.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return medias;

	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<Object> getMedias(int count, String typep, String languagep, String keywordp) {
		// TODO Auto-generated method stub
		ArrayList<Object> events = null;
		try {

			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<MediaMaster> from = criteriaQuery.from(MediaMaster.class);
			String type = typep;
			String language = languagep;
			String keyword = keywordp;

			System.out.println("Language:======="+ language);
			System.out.println("Category:======="+ type);
			System.out.println("Keyword:========"+ keyword);
			
			Predicate category, languagePredicate;
			
			languagePredicate = criteriaBuilder.like(from.get("languageMaster")
					.<String> get("languageName"), "%" + language + "%");
			category = criteriaBuilder.like(from.get("categoryMaster")
					.<String> get("categoryName"), "%" + type + "%");
			
				
			
			criteriaQuery.select(from);
			criteriaQuery.where(category,languagePredicate);
			
			criteriaQuery.orderBy(criteriaBuilder.desc(from.get("lastModifiedDate")));

			Query q1 = getEntityManager().createQuery(criteriaQuery);
			if(count != 0)
				q1.setMaxResults(count);
			events = (ArrayList<Object>) q1.getResultList();

		} catch (Exception e) {
			System.out.println("error in seacrh database id and keyword: " + e);
			e.printStackTrace();

		}
		return events;
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Collection<MediaMaster> getMedia(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		ArrayList<MediaMaster> medias = null;
		try {
			CriteriaBuilder criteriaBuilder = getEntityManager()
					.getCriteriaBuilder();
			CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery();
			Root<MediaMaster> from = criteriaQuery.from(MediaMaster.class);
			criteriaQuery.select(from);
			List<Predicate> predicates = new ArrayList<Predicate>();
			Set<String> keys = map.keySet();
			for (String key : keys) {
				if ("languageName".equalsIgnoreCase(key)) {
					Predicate predicate = from.get("languageMaster").get(key)
							.in(map.get(key));
					predicates.add(predicate);
				} else if("categoryName".equalsIgnoreCase(key)){
					Predicate predicate = from.get("categoryMaster").get(key)
							.in(map.get(key));
					predicates.add(predicate);
				}else {
					Predicate predicate = from.get(key).in(map.get(key));
					predicates.add(predicate);
				}
			}
			if (predicates.size() == 1)
				criteriaQuery.where(predicates.get(0));
			else
				criteriaQuery.where(criteriaBuilder.and(predicates
						.toArray(new Predicate[0])));
			Query q1 = getEntityManager().createQuery(criteriaQuery);
			medias = (ArrayList<MediaMaster>) q1.getResultList();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return medias;
	}

}
