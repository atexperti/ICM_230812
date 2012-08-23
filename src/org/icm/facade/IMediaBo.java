/**
 * 
 */
package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.MediaMaster;

/**
 * @author nageswararao.vejja
 * 
 */
public interface IMediaBo {
	
	int addMedia(Object media, String type);

	int updateMedia(Object media, String type);

	int deleteMedia(int id, String type);

	Object getMedia(int id, String type);

	Collection<Object> getMedias(String type);

	Collection<Object> getMedias(int count, String type);

	Collection<Object> getMedias(int count, String type,String keyword);

	Collection<Object> getMediass(String language, String type);
	
	Collection<Object> getMediass(String language, String type,int count);
	
	Collection<Object> getMediass(String language, String type,String keyword, int count);

	Collection<Object> getLanguages();

	public Collection<MediaMaster> getMedia(HashMap<String, String> map);
}
