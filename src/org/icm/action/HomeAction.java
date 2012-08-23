package org.icm.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.icm.facade.Constants;
import org.icm.facade.IMediaBo;
import org.icm.model.LanguageMaster;
import org.icm.model.MediaMaster;
import org.springframework.core.io.Resource;

public class HomeAction extends BaseAction  {

	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(HomeAction.class);
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
			
			//set to highlight the home menu 
			setActiveMenuId("home");
			
			Collection<Object> audios = new ArrayList<Object>();
			Collection<Object> videos = new ArrayList<Object>();
			Collection<Object> preview = new ArrayList<Object>();
			Collection<Object> slideShowImages = new ArrayList<Object>();
			Collection<Object> languagesList = null;
			//Get all the languages
			languagesList = mediaBo.getLanguages();
			setLanguages(languagesList);
				
			//Get all the required information if its not there in session
			//Get the first two latest updated audio and video files for each language
				Iterator<Object> iterator = languagesList.iterator();
				while(iterator.hasNext()){
					LanguageMaster languageMaster = (LanguageMaster)iterator.next();
					audios.addAll(mediaBo.getMediass(languageMaster.getLanguageName(),Constants.AUDIO,2));
					videos.addAll(mediaBo.getMediass(languageMaster.getLanguageName(),Constants.VIDEO,2));
				}
				
				//Get image of the day 
				Collection<Object> imageCollection =  mediaBo.getMedias(1,Constants.IMAGES);
				Iterator<Object> imageIterator = imageCollection.iterator();
				MediaMaster wallpapersMaster = null;
				while(imageIterator.hasNext()){
					wallpapersMaster = (MediaMaster)imageIterator.next();
				}
				
				//Get preview images data
				preview.addAll(mediaBo.getMedias(1, Constants.AUDIO,"Y"));
				preview.addAll(mediaBo.getMedias(1, Constants.VIDEO,"Y"));
				preview.addAll(mediaBo.getMedias(1, Constants.IMAGES,"Y"));
				preview.addAll(mediaBo.getMedias(1, Constants.PPT,"Y"));
				preview.addAll(mediaBo.getMedias(1, Constants.TEMPLATES,"Y"));
				preview.addAll(mediaBo.getMedias(1, Constants.CHIRSTIANNEEDS));
	
				//slide show for ppt,templetes and christian needs
				slideShowImages.addAll(mediaBo.getMedias(1, Constants.PPT));
				slideShowImages.addAll(mediaBo.getMedias(1, Constants.TEMPLATES));
				slideShowImages.addAll(mediaBo.getMedias(1, Constants.CHIRSTIANNEEDS));
				
				//Set all the information in session
				getRequest().setAttribute(Constants.AUDIO, audios);
				getRequest().setAttribute(Constants.VIDEO, videos);
				getRequest().setAttribute(Constants.IMAGES, preview);
				getRequest().setAttribute("slideShowImages", slideShowImages);
				if(wallpapersMaster != null)
					getRequest().setAttribute(Constants.IMAGE_OF_THE_DAY, wallpapersMaster.getThumbnail());
			return SUCCESS;
		}catch(Exception e){
			logger.error(e);
			return ERROR;
		}
	}
	
	public String imagePreview(){
		try{
			setActiveMenuId("home");
			Collection<Object> languagesList = null;
			//Get all the languages
			languagesList = mediaBo.getLanguages();
			setLanguages(languagesList);
			
			String type = getRequest().getParameter("type");
			Collection<Object> imagePreview = new ArrayList<Object>();
			imagePreview.addAll(mediaBo.getMedias(type!=null?type.toLowerCase():""));
			getRequest().setAttribute("imagePreview", imagePreview);
			return SUCCESS;
		}catch(Exception e){
			//e.printStackTrace();
			return ERROR;
		}
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
