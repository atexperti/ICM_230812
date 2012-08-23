package org.icm.action;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.icm.facade.IMediaBo;
import org.icm.facade.IUserBo;
import org.icm.model.UserMaster;

import com.opensymphony.xwork2.ActionContext;


/**
 * Acts as a controller to handle actions
 * related to registering a user.
 */

public class MyAccountAction extends BaseAction{
	
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(MyAccountAction.class);
	
	private UserMaster userBean, user;
	private Map<String, Object> session;
	private IUserBo userBo;
	private String capchaCode;
	private IMediaBo mediaBo;
	
	private String confirmusername;
	private String passwordChangeConfirm;
	public String getPasswordChangeConfirm() {
		return passwordChangeConfirm;
	}
	public void setPasswordChangeConfirm(String passwordChangeConfirm) {
		this.passwordChangeConfirm = passwordChangeConfirm;
	}
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	private String oldPassword;
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
		try{
			//Get all the languages
			Collection<Object> languagesList = mediaBo.getLanguages();
			setLanguages(languagesList);
			session = ActionContext.getContext().getSession();
			userBean.setUserId(user.getUserId());
			userBean.setLastModifiedDate(new Date());
			userBean.setUserName(user.getUserName());
			if(!"".equals(getPasswordChangeConfirm())){
				userBean.setPassword(user.getPassword());
			}
			userBo.updateUser(userBean);
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
			
	}
	public String input(){
		//Get all the languages
		Collection<Object> languagesList = mediaBo.getLanguages();
		setLanguages(languagesList);
		setPasswordChangeConfirm("none");
		session = ActionContext.getContext().getSession();
		if(session.get("userId") != null){
			 userBean = userBo.getUser((Integer)session.get("userId"));
			 // getRequest().setAttribute("userBean", userBean);
		}
		return SUCCESS;
	}
	public void validate(){
		Collection<Object> languagesList = mediaBo.getLanguages();
		setLanguages(languagesList);

		clearErrorsAndMessages();
		session = ActionContext.getContext().getSession();
		user = userBo.getUser((Integer)session.get("userId"));
		if(userBean != null){
			userBean.setUserName(user.getUserName());
			if("".equals(getPasswordChangeConfirm())){
				setPasswordChangeConfirm("");
				if(!user.getPassword().equals(getOldPassword())){
					addFieldError("oldPassword", "Old Password is not correct");
				}else{
					if(userBean.getPassword() == null || userBean.getPassword().trim().length() == 0)
						addFieldError("userBean.password", getText("register.password.error"));
					
					if(userBean.getPassword().trim().length() > 8)
						addFieldError("userBean.address2", getText("register.password.length.error"));

					if(userBean.getPassword() != null && userBean.getPassword().trim().length() != 0 && 
							getCpassword() != null && getCpassword().trim().length() !=0 
							&& !userBean.getPassword().equalsIgnoreCase(getCpassword()))
						addFieldError("cpassword", getText("register.password.notEqual"));
				}
			}
			
			
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
