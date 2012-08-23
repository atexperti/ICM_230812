<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<s:include value="header.jsp"></s:include>
	<s:include value="menu.jsp"></s:include>
	<s:form action="audioVideoPreview?type=%{#request.categoryName}%{#request.pageFrom}" cssClass="content">
		<table style="width: 100%;height: 100%;" border="1">
			<tr>
				<td style="width: 20%;vertical-align: top;" colspan="2">
					<s:iterator value="%{#request.mediaMasters}">
        				&nbsp;&nbsp;<a href="#" onclick="changeFile('<s:property value="preview"/>')"><s:property value="title"/></a>
        			</s:iterator>
				</td>
				<td>
					<table>
						<tr>
							<td>
								<s:select list="%{#request.albumDropdown}" headerValue="Album" headerKey="-1" name="album"></s:select> 
							</td>
							<td>
					            <s:select list="%{#request.artistDropdown}" headerValue="Artist" headerKey="-1" name="artist"></s:select> 
							</td>
							<td>
					            <s:select list="%{#request.languagesDropdown}" headerValue="Language" headerKey="-1" name="spLanguage"></s:select> 
							</td>
							<td>
					            <s:select list="%{#request.ocassionDropdown}" headerValue="Occasion" headerKey="-1" name="ocassion"></s:select> 
							</td>
							<td>
					            <select name="sortBy">
	  								<option>Sort By </option>
	  								 <option>Occasion Desc</option>
	  								  <option>Occasion Asc</option>
	  								 <option>Language Asc</option>
	  								  <option>Language Desc</option>
	  								 <option>Artist Asc</option>
	  								  <option>Artist Desc</option>
	  								 <option>Album Asc</option>
	  								  <option>Album Desc</option>
							  </select> 
							  </td>
							  <td>
				            	<s:textfield name="keyword" type="text" value="Keyword" size="20" maxlength="30" onkeydown="if(event.keyCode == 13) document.forms[0].submit();"/>
							  </td>
						</tr>
						<tr>
							<td>
            					<input name="Sort" type="submit" value="Sort" />
							</td>
						</tr>
						<tr>
							<td colspan="6" align="center">
							<div class="vdo">
								<a href="http://pseudo01.hddn.com/vod/demo.flowplayervod/flowplayer-700.flv"
									style="display: block; width: 380px; height: 320px" id="player">
								</a>
								<script>
											flowplayer("player", "swf/flowplayer-3.2.11.swf");
											function changeFile(url){
							                	document.getElementById('player').href = url;
							                	flowplayer("player", "swf/flowplayer-3.2.11.swf");
							                }
								</script>
							</div>
							</td>
						</tr>
						<tr>
							<td colspan="6">
								&nbsp;
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
</s:form>
    
<s:include value="footer.jsp"></s:include>    