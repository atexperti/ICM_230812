package org.icm.action;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.icm.facade.IMediaBo;
import org.icm.facade.IUserBo;
import org.icm.model.UserMaster;
import org.icm.token.AuthenticationTokenCache;
import org.icm.token.Token;


/**
 * Acts as a controller to handle actions
 * related to registering a user.
 */

public class RegisterAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(RegisterAction.class);
	
	private UserMaster userBean, user;
	
	private IUserBo userBo;
	private String capchaCode;
	private IMediaBo mediaBo;
	
	private String confirmusername;
	public String getConfirmusername() {
		return confirmusername;
	}
	public void setConfirmusername(String confirmusername) {
		this.confirmusername = confirmusername;
	}
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	private String cpassword;
	
	
	public IMediaBo getMediaBo() {
		return mediaBo;
	}
	public void setMediaBo(IMediaBo mediaBo) {
		this.mediaBo = mediaBo;
	}
	@Override
	public String execute() {
		//Get all the languages
		Collection<Object> languagesList = mediaBo.getLanguages();
		setLanguages(languagesList);

		input();
		// Check that username is not existed
		user = userBo.checkUser(userBean.getUserName(),userBean.getEmail());
		logger.info("inside register action"+ user);
		if(user == null){
			userBean.setLastModifiedDate(new Date());
			userBean.setStatus(0);
			int id	= userBo.addUser(userBean);
			logger.info("user inserted id" + id);
			if(id != 0)
				addActionError("register.success.msg");
			 return INPUT;
		}
		else{
			 if(userBean.getUserName().equals(user.getUserName())){
				 addActionError(getText("register.username.exist.error"));
			 }
			 else if(userBean.getEmail().equals(user.getEmail())){
				 addActionError(getText("register.useremail.exist.error"));
			 }
			
			return INPUT;
		}
		
		
	}
	public String input(){
		//Get all the languages
		Collection<Object> languagesList = mediaBo.getLanguages();
		setLanguages(languagesList);
		return SUCCESS;
	}
	public void validate(){
		input();
		clearErrorsAndMessages();
		if(userBean != null){
			if(userBean.getUserName() == null || userBean.getUserName().trim().length() == 0)
				 addFieldError("userBean.userName", getText("register.username.error"));
			
			if(userBean.getPassword() == null || userBean.getPassword().trim().length() == 0)
				addFieldError("userBean.password", getText("register.password.error"));
			
			if(userBean.getPassword().trim().length() > 8)
				addFieldError("userBean.password", getText("register.password.length.error"));
			
			if(userBean.getEmail() == null || userBean.getEmail().trim().length() == 0)
				 addFieldError("userBean.email", getText("register.email.error"));
			else{
				String  expression="^[\\w\\-]([\\.\\w])+[\\w]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
	            CharSequence inputStr = userBean.getEmail();
	            Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
	            Matcher matcher = pattern.matcher(inputStr);
	            if(!matcher.matches())
	                addFieldError("userBean.email",getText("register.email.invalid"));
			}
            
			if(userBean.getUserName() != null && userBean.getUserName().trim().length() != 0 && 
					getConfirmusername() != null && getConfirmusername().trim().length() !=0 
					&& !userBean.getUserName().equalsIgnoreCase(getConfirmusername()))
				addFieldError("confirmusername", getText("register.userName.notEqual"));
			
			if(userBean.getPassword() != null && userBean.getPassword().trim().length() != 0 && 
					getCpassword() != null && getCpassword().trim().length() !=0 
					&& !userBean.getPassword().equalsIgnoreCase(getCpassword()))
				addFieldError("cpassword", getText("register.password.notEqual"));

			if(getCapchaCode() == null || getCapchaCode().trim().length() == 0){
				addFieldError("capchaCode", getText("register.captcha.error"));
			}
			
		if(getCapchaCode() != null && getCapchaCode().trim().length() > 0){
			String sessionId = null;
			Token token = null;
			HttpSession s = null;
			// create a session if required
			s = getRequest().getSession(false);
			sessionId = s.getId();
			token = (Token) AuthenticationTokenCache.getInstance().getSessionToken(sessionId);
			if(!token.validateResponse(getCapchaCode())){
				addFieldError("capchaCode", getText("register.captcha.incorrect.error"));
			}
		}
			
		}
		
	}
	public UserMaster getUserBean() {
		return userBean;
	}
	public void setUserBean(UserMaster userBean) {
		this.userBean = userBean;
	}
	public IUserBo getUserBo() {
		return userBo;
	}
	public void setUserBo(IUserBo userBo) {
		this.userBo = userBo;
	}
	public String getCapchaCode() {
		return capchaCode;
	}
	public void setCapchaCode(String capchaCode) {
		this.capchaCode = capchaCode;
	}
	
}
