package org.icm.action;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.icm.facade.Constants;
import org.icm.facade.IMediaBo;
import org.icm.model.MediaMaster;
import org.springframework.core.io.Resource;

public class MediaAction extends BaseAction  {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MediaAction.class);
	private Resource configLocation;
	private IMediaBo mediaBo;
	
	private String type;
	
	public void init(){
		try {
			super.init();

		} catch (Exception e) {
			logger.error(e);
		}
	}
	public String execute() {
		try{
			setActiveMenuId("media");
			String language = getLanguage();
			System.out.println("Language="+ language);
			Collection<Object> languagesList = null;
			//Get all the languages
			languagesList = mediaBo.getLanguages();
			setLanguages(languagesList);
			
			
			//Get all the required information if its not there in session
				Collection<Object> audios =  mediaBo.getMediass(language,Constants.AUDIO);
				getRequest().setAttribute(Constants.AUDIO, audios);
	
				Collection<Object> videos =  mediaBo.getMediass(language,Constants.VIDEO);
				getRequest().setAttribute(Constants.VIDEO, videos);
	
				MediaMaster wallpapersMaster = null;
				Collection<Object> imageCollection =  mediaBo.getMediass(language,Constants.IMAGES,1);
				if(imageCollection != null){
					Iterator<Object> imageIterator = imageCollection.iterator();
					while(imageIterator.hasNext()){
						wallpapersMaster = (MediaMaster)imageIterator.next();
					}
				}
				getRequest().setAttribute(Constants.IMAGE_OF_THE_DAY, wallpapersMaster != null? wallpapersMaster.getThumbnail():"");
				
				Collection<Object> mediaCollection = null;
				mediaCollection = mediaBo.getMediass(language, Constants.PPT,1);
				getRequest().setAttribute("ppt", getTheImage(mediaCollection));
				mediaCollection = mediaBo.getMediass(language, Constants.TEMPLATES,1);
				getRequest().setAttribute("template", getTheImage(mediaCollection));
				
				return SUCCESS;
		}catch(Exception e){
			logger.error(e);
			return ERROR;
		}
	}
	
	public String getTheImage(Collection<Object> collection){
		Iterator<Object> iterator = null;
		MediaMaster master = null;
		if(collection != null)
			iterator = collection.iterator();
		if(iterator != null){
			while(iterator.hasNext()){
				master = (MediaMaster) iterator.next();
			}
		}
		return master != null ? master.getThumbnail() : ""; 
	}
	
	public void setConfigLocation(Resource configLocation) {
	
		this.configLocation = configLocation;
	}
	public Resource getConfigLocation() {
		return configLocation;
	}
	
	/**
	 * @return the mediaBo
	 */
	public IMediaBo getMediaBo() {
		return mediaBo;
	}
	/**
	 * @param mediaBo the mediaBo to set
	 */
	public void setMediaBo(IMediaBo mediaBo) {
		this.mediaBo = mediaBo;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
