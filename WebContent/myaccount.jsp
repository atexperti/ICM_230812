<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<s:include value="header.jsp"></s:include>
<s:include value="menu.jsp"></s:include>

<script type="text/javascript">
<!--
function enableDisable(field){
	if(field.checked){
		document.getElementById('passwordData').style.display = '';
	}else{
		document.getElementById('passwordData').style.display = 'none';
	}
}
//-->
</script>

<div class="content">
	<div class="left">
		<div class="box" align="center">
				<s:form action="updateCustomerInfo">
					<fieldset>
						<table border="0" width="500">
							<tr>
								<td><strong>Username123</strong></td>
								<td><s:textfield disabled="true" name="userBean.userName"/></td>
							</tr>
							<tr>
								<td><strong>Want to change password</strong></td>
								<td> <s:checkbox onclick="enableDisable(this)" fieldValue="" name="passwordChangeConfirm"></s:checkbox>
								
								</td>
							</tr>
							<tr> 
								<td colspan="2" id="passwordData" style="display:<s:property value="passwordChangeConfirm"/>">
									<table border="0" width="500">
										<tr>
											<td width="260"><strong>Old Password &nbsp;&nbsp;&nbsp;&nbsp;</strong></td>
											<td align="left"><s:password name="oldPassword"></s:password></td>
										</tr>
										<tr>
											<td><strong>Password</strong></td>
											<td align="left"> <s:password name="userBean.password"></s:password></td>
										</tr>
										<tr>
											<td><strong>Confirm Password</strong></td>
											<td align="left"><s:password name="cpassword"/></td>
										</tr>
									</table>
								</td>
							</tr>
							<tr>
								<td><strong>Email</strong></td>
								<td><s:textfield name="userBean.email"></s:textfield></td>
							</tr>
							<tr>
								<td><strong>Church Name</strong></td>
								<td><s:textfield name="userBean.chruchName"></s:textfield></td>
							</tr>
							<tr>
								<td><strong>Address</strong></td>
								<td><s:textfield name="userBean.address1"></s:textfield></td>
							</tr>
							<tr>
								<td><strong>City</strong></td>
								<td><s:textfield name="userBean.address2"></s:textfield></td>
							</tr>
						</table>
					</fieldset>
					<fieldset style="text-align: center">
						<br /> Click on Update button to modify the user information. 
					</fieldset>
					<label class="botton-bg"><input type="submit" value="Update"/></label>
					<br/><br/>
				</s:form>
		</div>
	</div>
	<div class="right-cont"></div>
	<div class="clear"></div>
</div>

<s:include value="footer.jsp"></s:include>
