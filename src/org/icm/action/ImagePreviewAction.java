package org.icm.action;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.icm.facade.IMediaBo;
import org.icm.model.LanguageMaster;
import org.icm.model.MediaMaster;

public class ImagePreviewAction extends SearchAndSortAction{

	private IMediaBo mediaBo;
	
	public IMediaBo getMediaBo() {
		return mediaBo;
	}

	public void setMediaBo(IMediaBo mediaBo) {
		this.mediaBo = mediaBo;
	}

	@Override
	@SuppressWarnings("all")
	public void databaseCall() {
		// TODO Auto-generated method stub
		try{
			setActiveMenuId("media");
			Collection<Object> languagesList = null;
			
			List<String> languagesDropdown = new ArrayList<String>();
			List<String> ocassionDropdown = new ArrayList<String>();
			List<String> artistDropdown = new ArrayList<String>();
			List<String> albumDropdown = new ArrayList<String>();
			
			List<MediaMaster> mediaMasters = new ArrayList<MediaMaster>();
			//Get all the languages
			languagesList = mediaBo.getLanguages();
			setLanguages(languagesList);
			
			String type = getRequest().getParameter("type");
			getRequest().setAttribute("categoryName", type);

			Collection<Object> imagePreview = new ArrayList<Object>();
			HashMap<String, String> predicates = getPredicates();
			predicates.put("categoryName", type);
			imagePreview.addAll(mediaBo.getMedia(predicates));
			
			Iterator<Object> langiterator = languagesList.iterator();
			while (langiterator.hasNext()) {
				LanguageMaster languageMaster = (LanguageMaster)langiterator.next();
				languagesDropdown.add(languageMaster.getLanguageName());
			}
			
			Iterator iterator = imagePreview.iterator();
			while(iterator.hasNext()){
				MediaMaster master = (MediaMaster)iterator.next();
				if(master.getArtist() != null && !"".equals(master.getArtist())){
					artistDropdown.add(master.getArtist());
				}if(master.getOcassion() != null && !"".equals(master.getOcassion())){
					ocassionDropdown.add(master.getOcassion());
				}if(master.getAlbum() != null && !"".equals(master.getAlbum())){
					albumDropdown.add(master.getAlbum());
				}
				mediaMasters.add(master);
			}
			
			setMediaMasterList(mediaMasters);
			
			getRequest().setAttribute("languagesDropdown", languagesDropdown);
			getRequest().setAttribute("ocassionDropdown", ocassionDropdown);
			getRequest().setAttribute("artistDropdown", artistDropdown);
			getRequest().setAttribute("albumDropdown", albumDropdown);
			
			getRequest().setAttribute("mediaMasters",mediaMasters);
			
	}catch(Exception e){
		e.printStackTrace();
	}
	}
}
