package org.icm.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.icm.model.MediaMaster;

public abstract class SearchAndSortAction extends BaseAction{
	//Form fields start
	private String album;
	private String spLanguage;
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getOcassion() {
		return ocassion;
	}
	public void setOcassion(String ocassion) {
		this.ocassion = ocassion;
	}

	private String sortBy;
	private String keyword;
	private String artist;
	private String ocassion;
	private HashMap<String, String> predicates = new HashMap<String,String>();
	private List<MediaMaster> mediaMasterList = new ArrayList<MediaMaster>();
	public List<MediaMaster> getMediaMasterList() {
		return mediaMasterList;
	}
	public void setMediaMasterList(List<MediaMaster> mediaMasterList) {
		this.mediaMasterList = mediaMasterList;
	}
	public HashMap<String, String> getPredicates() {
		return predicates;
	}
	public void setPredicates(HashMap<String, String> predicates) {
		this.predicates = predicates;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getSortBy() {
		return sortBy;
	}
	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}
	public String getSpLanguage() {
		return spLanguage;
	}
	public void setSpLanguage(String spLanguage) {
		this.spLanguage = spLanguage;
	}
	//Form fields end

public String execute(){

	String from = getRequest().getParameter("from");
	if(from != null && !"".equals(from)){
		getRequest().setAttribute("pageFrom", "&from=media");
		String lag = getSpLanguage();
		if(lag == null)
			setSpLanguage(getLanguage());
	}
	else
		getRequest().setAttribute("pageFrom","");

	//Get all the search fields
	if(album != null && !"-1".equals(album)){
		predicates.put("album", album);
	}
	if(spLanguage != null && !"-1".equals(spLanguage)){
		predicates.put("languageName", spLanguage);
	}
	
	if(keyword != null && !"".equals(keyword) && !"Keyword".equalsIgnoreCase(keyword)){
		predicates.put("keywords", keyword);
	}
	if(ocassion != null && !"-1".equals(ocassion)){
		predicates.put("ocassion", ocassion);
	}
	if(artist != null && !"-1".equals(artist)){
		predicates.put("artist", artist);
	}
	
	databaseCall();
	
	if(sortBy != null && !"-1".equals(sortBy)){
		if("Language Desc".equalsIgnoreCase(sortBy)){
			Collections.sort(mediaMasterList, new languageComparator("Desc"));
		}else if("Language Asc".equalsIgnoreCase(sortBy)){
			Collections.sort(mediaMasterList, new languageComparator("Asc"));
		}else if("Ocassion Desc".equalsIgnoreCase(sortBy)){
			Collections.sort(mediaMasterList, new OcassionComparator("Desc"));
		}else if("Artist Desc".equalsIgnoreCase(sortBy)){
			Collections.sort(mediaMasterList, new ArtistComparator("Desc"));
		}else if("Ocassion Asc".equalsIgnoreCase(sortBy)){
			Collections.sort(mediaMasterList, new OcassionComparator("Asc"));
		}else if("Artist Asc".equalsIgnoreCase(sortBy)){
			Collections.sort(mediaMasterList, new ArtistComparator("Asc"));
		}else if("Album Desc".equalsIgnoreCase(sortBy)){
			Collections.sort(mediaMasterList, new AlbumComparator("Desc"));
		}else if("Album Asc".equalsIgnoreCase(sortBy)){
			Collections.sort(mediaMasterList, new AlbumComparator("Asc"));
		}
	}

	return SUCCESS;
}

class OcassionComparator implements Comparator<MediaMaster>{
	String type;
	OcassionComparator(String type){
		this.type = type;
	}
	@Override
	public int compare(MediaMaster em1, MediaMaster em2) {
		// TODO Auto-generated method stub
		if(em2.getOcassion() != null && em1.getOcassion() != null){
			if("Asc".equalsIgnoreCase(type)){
			return em2.getOcassion().compareTo(em1.getOcassion());
		}
		else{
			return em1.getOcassion().compareTo(em2.getOcassion());
		}
	}
		return 0;
	}	
}

class ArtistComparator implements Comparator<MediaMaster>{
	String type;
	ArtistComparator(String type){
		this.type = type;
	}
	@Override
	public int compare(MediaMaster em1, MediaMaster em2) {
		// TODO Auto-generated method stub
		if(em2.getArtist() != null && em1.getArtist() != null){
			if("Asc".equalsIgnoreCase(type)){
				return em2.getArtist().compareTo(em1.getArtist());
			}else{
				return em1.getArtist().compareTo(em2.getArtist());
			}
		}
		return 0;
	}
	
}
class AlbumComparator implements Comparator<MediaMaster>{
	String type;
	AlbumComparator(String type){
		this.type = type;
	}
	@Override
	public int compare(MediaMaster em1, MediaMaster em2) {
		// TODO Auto-generated method stub
		if(em2.getAlbum() != null && em1.getAlbum() != null){
			if("Asc".equalsIgnoreCase(type)){
				return em2.getAlbum().compareTo(em1.getAlbum());
			}else{
				return em1.getAlbum().compareTo(em2.getAlbum());
			}
		}
		return 0;
	}
	
}
class languageComparator implements Comparator<MediaMaster>{
	String type;
	languageComparator(String type){
		this.type = type;
	}
	@Override
	public int compare(MediaMaster em1, MediaMaster em2) {
		// TODO Auto-generated method stub
			if(em2.getLanguageMaster().getLanguageName() != null && em1.getLanguageMaster().getLanguageName() != null){
				if("Asc".equalsIgnoreCase(type)){
					return em2.getLanguageMaster().getLanguageName().compareTo(em1.getLanguageMaster().getLanguageName());
				}else{
					return em1.getLanguageMaster().getLanguageName().compareTo(em2.getLanguageMaster().getLanguageName());
				}
			}
			return 0;
		}
}

public abstract void databaseCall();
}
