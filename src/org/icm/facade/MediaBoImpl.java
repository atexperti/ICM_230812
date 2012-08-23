/**
 * 
 */
package org.icm.facade;

import java.util.Collection;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.icm.dao.IChristianNeedsDao;
import org.icm.dao.ILanguageDAO;
import org.icm.dao.IMediaDAO;
import org.icm.model.MediaMaster;

/**
 * @author nageswararao.vejja
 * 
 */
public class MediaBoImpl implements IMediaBo {
	private Logger logger = Logger.getLogger(this.getClass());

	private ILanguageDAO languageDAO;
	private IMediaDAO mediaDao;
	private IChristianNeedsDao christianNeedsDao;


	public IMediaDAO getMediaDao() {
		return mediaDao;
	}

	public void setMediaDao(IMediaDAO mediaDao) {
		this.mediaDao = mediaDao;
	}

	public ILanguageDAO getLanguageDAO() {
		return languageDAO;
	}

	public void setLanguageDAO(ILanguageDAO languageDAO) {
		this.languageDAO = languageDAO;
	}


	public IChristianNeedsDao getChristianNeedsDao() {
		return christianNeedsDao;
	}

	public void setChristianNeedsDao(IChristianNeedsDao christianNeedsDao) {
		this.christianNeedsDao = christianNeedsDao;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.facade.IMediaBo#getMedias()
	 */
	@Override
	public Collection<Object> getMedias(String type) {
		return getMedias(0,type);
	}

	@Override
	public Collection<Object> getMedias(int count, String type, String keyword) {
		// TODO Auto-generated method stub
		return getMediass("", type, keyword, count);
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.facade.IMediaBo#getMedias(int)
	 */
	@Override
	public Collection<Object> getMedias(int count, String type) {
		Collection<Object>  obj = null;
		switch (type) {
		case Constants.AUDIO:

			try {
				obj = mediaDao.getMedias(count,Constants.AUDIO);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.VIDEO:

			try {
				obj = mediaDao.getMedias(count,Constants.VIDEO);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.IMAGES:

			try {
				obj = mediaDao.getMedias(count,Constants.IMAGES);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.TEMPLATES:

			try {
				obj = mediaDao.getMedias(count,Constants.TEMPLATES);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.PPT:

			try {
				obj = mediaDao.getMedias(count,Constants.PPT);;

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
			
		case Constants.CHIRSTIANNEEDS:

			try {
				obj = christianNeedsDao.getChristianNeedss(Constants.CHIRSTIANNEEDS);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
		return obj;
	}

	@Override
	public Collection<Object> getMediass(String language, String type) {
		// TODO Auto-generated method stub
		return getMediass(language, type, 0);
	}
	

	@Override
	public Collection<Object> getMediass(String language, String type, int count) {
		// TODO Auto-generated method stub
		return getMediass(language, type, "", count);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.icm.facade.IMediaBo#getMediass(java.lang.String)
	 */
	@Override
	public Collection<Object> getMediass(String language, String type, String keyword, int count) {
		// TODO Auto-generated method stub
		Collection<Object>  obj = null;
		switch (type) {
		case Constants.AUDIO:

			try {
				obj = mediaDao.getMedias(count,Constants.AUDIO,language,keyword);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.VIDEO:

			try {
				obj = mediaDao.getMedias(count,Constants.VIDEO,language,keyword);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.IMAGES:

			try {
				obj = mediaDao.getMedias(count,Constants.IMAGES,language,keyword);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.TEMPLATES:

			try {
				obj = mediaDao.getMedias(count,Constants.TEMPLATES,language,keyword);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
		case Constants.PPT:

			try {
				obj = mediaDao.getMedias(count,Constants.PPT,language,keyword);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;
			
		case Constants.CHIRSTIANNEEDS:

			try {
				obj = christianNeedsDao.getChristianNeedss(language);

			} catch (Exception e) {
				logger.error("Exception occured while getting promotionalContent "
						+ e);
				e.printStackTrace();
			}
			break;

		default:
			break;
		}
		return obj;
	}

	@Override
	public Collection<Object> getLanguages() {
		// TODO Auto-generated method stub
		return languageDAO.getLanguages();
	}

	@Override
	public int addMedia(Object media, String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMedia(Object media, String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getMedia(int id, String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMedia(int id, String type) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<MediaMaster> getMedia(HashMap<String, String> map) {
		// TODO Auto-generated method stub
		Collection<MediaMaster> media = null;
		try{
			media = mediaDao.getMedia(map);
		}catch(Exception e){
			e.printStackTrace();
		}
		return media;
	}
}
