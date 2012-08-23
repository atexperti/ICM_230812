<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<s:include value="header.jsp"></s:include>
<s:include value="menu.jsp"></s:include>

<script type="text/javascript">
<!--
	function enableDisable(field) {
		if (field.checked) {
			document.getElementById('passwordData').style.display = '';
		} else {
			document.getElementById('passwordData').style.display = 'none';
		}
	}
//-->
</script>

<div class="content">
	<div class="left">
		<div class="box" align="center">
			<s:if test="%{#session.userId ==null}">
				<h1>
					<s:text name="Sign.Up"></s:text>
				</h1>
				<h3>It's free and always will be.</h3>

				<s:form action="registeruser">
					<fieldset>
						<table>
							<tr>
								<td colspan="1"><s:actionerror
										key="register.useremail.exist.error" /> <s:actionmessage
										key="register.success.msg" /></td>
							</tr>
							<tr>
								<td><strong>Username</strong></td>
								<td><s:textfield name="userBean.userName" /></td>
							</tr>
							<tr>
								<td><strong>Confirm username</strong></td>
								<td><s:textfield name="confirmusername" /></td>
							</tr>
							<tr>
								<td><strong>Password</strong></td>
								<td><s:password name="userBean.password"></s:password></td>
							</tr>
							<tr>
								<td><strong>Confirm Password</strong></td>
								<td><s:password name="cpassword" /></td>
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
							<tr>
								<td><strong>Captcha</strong></td>
								<td><s:textfield name="capchaCode" maxlength="6" /></td>
							</tr>
							<tr>
								
								<td colspan="2" align="center"><img src="<%=request.getContextPath()%>/captchaimage" width="90"
								height="50" /></td>
							</tr>
						</table>
						</fieldset>

					<fieldset style="text-align: center">
						<br /> By clicking Sign Up, you agree to our Terms and that you
						have read and understand our Data Use Policy
					</fieldset>
					<label class="botton-bg"><input type="submit"
						value="Signup" /></label>
					<br />
					<br />
				</s:form>
			</s:if>
		</div>
	</div>
	<div class="right-cont"></div>
	<div class="clear"></div>
</div>

<s:include value="footer.jsp"></s:include>
