<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<s:include value="header.jsp"></s:include>
<s:include value="menu.jsp"></s:include>
<div class="content">
	<div class="box-l">
		<div class="vdo">
			<!-- this A tag is where your Flowplayer will be placed. it can be anywhere -->
			<a
				href="http://pseudo01.hddn.com/vod/demo.flowplayervod/flowplayer-700.flv"
				style="display: block; width: 380px; height: 320px" id="player">
			</a>

			<!-- this will install flowplayer inside previous A- tag. -->
			<script>
				flowplayer("player", "swf/flowplayer-3.2.11.swf");
				function changeFile(url) {
					document.getElementById('player').href = url;
					flowplayer("player", "swf/flowplayer-3.2.11.swf");
				}
			</script>
		</div>
		<div class="title"><s:text name="Latest.Video"></s:text></div>
		<div class="log-media-v">
			
			<table width="0" border="0">
			<s:if test="%{!#request.video.isEmpty()}">
				<s:iterator value="%{#request.video}">
					<tr>
						<td><a href="#"
							onclick="changeFile('<s:property value="preview"/>')"><s:property
									value="title" /></a></td>
					</tr>
				</s:iterator>
		            <tr>
		            	<td align="right"><a href="audioVideoPreview?type=video&from=media">See More</a></td>
		            </tr>
			</s:if>
			<s:if test="%{#request.video.isEmpty()}">
				No Video files
			</s:if>
			</table>

		</div>
	</div>

	<div class="box">
		<div class="box-l">
			<div class="title"><s:text name="image.of.day.text"></s:text></div>
			<div class="image-of-the-day">
			<s:if test="!#request.imageOftheDay.isEmpty()">
				<a href="imagePreview?type=images&from=media">
					<img src="<s:property value="#request.imageOftheDay"/>" width="248" height="185" />
				</a>
			</s:if>
			<s:if test="#request.imageOftheDay.isEmpty()">
				No Wall paper of the day image 	
			</s:if>			
		</div>
		</div>
		<div class="clear"></div>
		<div class="box-l">
			<div class="title">Presentation of the Day</div>
			<div class="image-of-the-day">
				<s:if test="#request.ppt.isEmpty()">
					No Presentation of the dY Image
				</s:if>
				<s:if test="!#request.ppt.isEmpty()">
				<a href="imagePreview?type=ppt&from=media">
				<img src="<s:property value="#request.ppt"/>" width="248" height="185" />
				</a>
				</s:if>
			</div>
		</div>
	</div>
	<div class="box-l">
		<div class="title"><s:text name="Latest.Music"></s:text></div>
		<div class="log">
			<div class="log-media-a">
				<table width="0" border="0">
				<s:if test="%{!#request.audio.isEmpty()}">
					<s:iterator value="%{#request.audio}">
            			<tr>
                        <td><a href="#" onclick="changeFile('<s:property value="preview"/>')"><s:property value="title"/></a></td>
                      </tr>
            		</s:iterator>
		            <tr>
		            	<td align="right"><a href="audioVideoPreview?type=audio&from=media">See More</a></td>
		            </tr>
				</s:if>
				<s:if test="%{#request.audio.isEmpty()}">
					No Audio files
				</s:if>				
				</table>
			</div>
		</div>
		<div class="ado">
		<div class="title">Template of the day</div>
		<div class="image-of-the-day">
			<s:if test="#request.template.isEmpty()">
					No Template of the day Image
			</s:if>
			<s:if test="!#request.template.isEmpty()">
			<a href="imagePreview?type=tempaltes&from=media">
				<img src="<s:property value="#request.template"/>" width="248" height="185" />
			</a>
			</s:if>
		</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<s:include value="footer.jsp"></s:include>
