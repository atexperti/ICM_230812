package org.icm.jaxb.util;

//
//This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
//See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
//Any modifications to this file will be lost upon recompilation of the source schema. 
//Generated on: 2011.12.12 at 02:23:26 PM IST 
//
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


/**
* <p>Java class for anonymous complex type.
* 
* <p>The following schema fragment specifies the expected content contained within this class.
* 
* <pre>
* &lt;complexType>
*   &lt;complexContent>
*     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
*       &lt;sequence>
*         &lt;element ref="{}dle-type"/>
*         &lt;element ref="{}mime-type"/>
*         &lt;element ref="{}provider-type"/>
*         &lt;element ref="{}resource-id" minOccurs="0"/>
*         &lt;element ref="{}name" minOccurs="0"/>
*         &lt;element ref="{}caption" minOccurs="0"/>
*         &lt;element ref="{}supported-user-agents" minOccurs="0"/>
*         &lt;element ref="{}attribute" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element ref="{}meta" maxOccurs="unbounded" minOccurs="0"/>
*         &lt;element ref="{}file-ref"/>
*         &lt;element ref="{}process-command" maxOccurs="unbounded" minOccurs="0"/>
*       &lt;/sequence>
*     &lt;/restriction>
*   &lt;/complexContent>
* &lt;/complexType>
* </pre>
* 
* 
*/
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "resource")
public class Resource {

 @XmlElement(name = "dle-type", required = true)
 protected String dleType;
 @XmlElement(name = "mime-type", required = true)
 protected String mimeType;
 @XmlElement(name = "provider-type", required = true)
 protected String providerType;
 @XmlElement(name = "resource-id")
 protected String resourceId;
 protected String name;
 protected String caption;
 @XmlElementWrapper(name = "supported-user-agents")
 @XmlElement(name = "supported-user-agent")
 protected List<SupportedUserAgent> supportedUserAgent;
 protected List<Meta> meta;
 @XmlElement(name = "file-ref", required = true)
 protected String fileRef;
 
 /**
  * Gets the value of the dleType property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getDleType() {
     return dleType;
 }

 /**
  * Sets the value of the dleType property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setDleType(String value) {
     this.dleType = value;
 }

 /**
  * Gets the value of the mimeType property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getMimeType() {
     return mimeType;
 }

 /**
  * Sets the value of the mimeType property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setMimeType(String value) {
     this.mimeType = value;
 }

 /**
  * Gets the value of the providerType property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getProviderType() {
     return providerType;
 }

 /**
  * Sets the value of the providerType property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setProviderType(String value) {
     this.providerType = value;
 }

 /**
  * Gets the value of the resourceId property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getResourceId() {
     return resourceId;
 }

 /**
  * Sets the value of the resourceId property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setResourceId(String value) {
     this.resourceId = value;
 }

 /**
  * Gets the value of the name property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getName() {
     return name;
 }

 /**
  * Sets the value of the name property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setName(String value) {
     this.name = value;
 }

 /**
  * Gets the value of the caption property.
  * 
  * @return
  *     possible object is
  *     {@link String }
  *     
  */
 public String getCaption() {
     return caption;
 }

 /**
  * Sets the value of the caption property.
  * 
  * @param value
  *     allowed object is
  *     {@link String }
  *     
  */
 public void setCaption(String value) {
     this.caption = value;
 }

 

 
 /**
  * Gets the value of the meta property.
  * 
  * <p>
  * This accessor method returns a reference to the live list,
  * not a snapshot. Therefore any modification you make to the
  * returned list will be present inside the JAXB object.
  * This is why there is not a <CODE>set</CODE> method for the meta property.
  * 
  * <p>
  * For example, to add a new item, do as follows:
  * <pre>
  *    getMeta().add(newItem);
  * </pre>
  * 
  * 
  * <p>
  * Objects of the following type(s) are allowed in the list
  * {@link Meta }
  * 
  * 
  */
 public List<Meta> getMeta() {
     if (meta == null) {
         meta = new ArrayList<Meta>();
     }
     return this.meta;
 }

 /**
  * Gets the value of the fileRef property.
  * 
  * @return
  *     possible object is
  *     {@link FileRef }
  *     
  */
 public String getFileRef() {
     return fileRef;
 }

 /**
  * Sets the value of the fileRef property.
  * 
  * @param value
  *     allowed object is
  *     {@link FileRef }
  *     
  */
 public void setFileRef(String value) {
     this.fileRef = value;
 }

public List<SupportedUserAgent> getSupportedUserAgent() {
	return supportedUserAgent;
}

public void setSupportedUserAgent(List<SupportedUserAgent> supportedUserAgent) {
	this.supportedUserAgent = supportedUserAgent;
}

public void setMeta(List<Meta> meta) {
	this.meta = meta;
}

 

}