package org.icm.dao;

import java.util.Collection;
import java.util.HashMap;

import org.icm.model.MediaMaster;

public interface IMediaDAO {
	Collection<Object> getMedias(int size, String category);
	Collection<Object> getMedias(int count, String type, String language, String keyword);
	public Collection<MediaMaster> getMedia(HashMap<String, String> map);
}
