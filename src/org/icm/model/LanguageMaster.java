package org.icm.model;

// Generated 5 Jun, 2012 5:27:43 PM by Hibernate Tools 3.2.1.GA

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * LanguageMaster generated by hbm2java
 */
@Entity
@Table(name = "language_master", catalog = "icmcom_main")
public class LanguageMaster implements java.io.Serializable {

	private Integer languageId;
	private String languageName;
	private Date lastModifiedDate;
	private Set<MediaMaster> videoMasters = new HashSet<MediaMaster>(0);
	private Set<EventMaster> eventMasters = new HashSet<EventMaster>(0);
	private Set<ChristianNeedsMaster> christianNeedsMasters = new HashSet<ChristianNeedsMaster>(0);
	private Set<ArticleMaster> articleMasters = new HashSet<ArticleMaster>(0);
	private Set<LyricsMaster> lyricsMasters = new HashSet<LyricsMaster>(0);

	public LanguageMaster() {
	}

	public LanguageMaster(String languageName, Date lastModifiedDate) {
		this.languageName = languageName;
		this.lastModifiedDate = lastModifiedDate;
	}

	public LanguageMaster(String languageName, Date lastModifiedDate,
			Set videoMasters, Set audioMasters, Set eventMasters,
			Set pptMasters, Set christianNeedsMasters, Set articleMasters,
			Set lyricsMasters, Set wallpapersMasters, Set websiteTemplateMasters) {
		this.languageName = languageName;
		this.lastModifiedDate = lastModifiedDate;
		this.videoMasters = videoMasters;
		this.eventMasters = eventMasters;
		this.christianNeedsMasters = christianNeedsMasters;
		this.articleMasters = articleMasters;
		this.lyricsMasters = lyricsMasters;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "languageId", unique = true, nullable = false)
	public Integer getLanguageId() {
		return this.languageId;
	}

	public void setLanguageId(Integer languageId) {
		this.languageId = languageId;
	}

	@Column(name = "languageName", nullable = false, length = 50)
	public String getLanguageName() {
		return this.languageName;
	}

	public void setLanguageName(String languageName) {
		this.languageName = languageName;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastModifiedDate", nullable = false, length = 19)
	public Date getLastModifiedDate() {
		return this.lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "languageMaster")
	public Set<MediaMaster> getVideoMasters() {
		return this.videoMasters;
	}

	public void setVideoMasters(Set<MediaMaster> videoMasters) {
		this.videoMasters = videoMasters;
	}

	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "languageMaster")
	public Set<EventMaster> getEventMasters() {
		return this.eventMasters;
	}

	public void setEventMasters(Set<EventMaster> eventMasters) {
		this.eventMasters = eventMasters;
	}

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "languageMaster")
	public Set<ChristianNeedsMaster> getChristianNeedsMasters() {
		return this.christianNeedsMasters;
	}

	public void setChristianNeedsMasters(Set<ChristianNeedsMaster> christianNeedsMasters) {
		this.christianNeedsMasters = christianNeedsMasters;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "languageMaster")
	public Set<ArticleMaster> getArticleMasters() {
		return this.articleMasters;
	}

	public void setArticleMasters(Set<ArticleMaster> articleMasters) {
		this.articleMasters = articleMasters;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "languageMaster")
	public Set<LyricsMaster> getLyricsMasters() {
		return this.lyricsMasters;
	}

	public void setLyricsMasters(Set<LyricsMaster> lyricsMasters) {
		this.lyricsMasters = lyricsMasters;
	}

	
}
