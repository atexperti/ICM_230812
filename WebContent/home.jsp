<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<s:include value="header.jsp"></s:include>
<s:include value="menu.jsp"></s:include>
<div class="content">
	<div class="box-l">
		<div class="corosel">
			<div id="carousel1">
			<s:iterator value="%{#request.images}">
                     	<a href="" title=""><img src="<s:property value="thumbnail"/>" width="100%"></a>
            </s:iterator> 
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
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
				function changeFile(url){
                	document.getElementById('player').href = url;
                	flowplayer("player", "swf/flowplayer-3.2.11.swf");
                }
				function slideSwitch() {
				    var $active = $('#slideshow IMG.active');

				    if ( $active.length == 0 ) $active = $('#slideshow IMG:last');

				    var $next =  $active.next().length ? $active.next()
				        : $('#slideshow IMG:first');

				    $active.addClass('last-active');

				    $next.css({opacity: 0.0})
				        .addClass('active')
				        .animate({opacity: 1.0}, 1000, function() {
				            $active.removeClass('active last-active');
				        });
				}
				$(function() {
				    setInterval( "slideSwitch()", 8000 );
				});
		</script>
		</div>
		<div class="log-media-v">
			<div class="title"><s:text name="home.latestVideos"></s:text></div>
			<table width="0" border="0">
			<s:if test="%{!#request.video.isEmpty()}">
				<s:iterator value="%{#request.video}">
                     	<tr>
                        	<td><a href="#" onclick="changeFile('<s:property value="preview"/>')"><s:property value="title"/></a></td>
                      	</tr>
                 </s:iterator>
            <tr>
            	<td align="right"><a href="audioVideoPreview?type=video">See More</a></td>
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
			<s:if test="#request.imageOftheDay != null">
				<a href="imagePreview?type=images">
				<img src="<s:property value="#request.imageOftheDay"/>" width="248" height="185" />
				</a>
			</s:if>
			<s:if test="#request.imageOftheDay == null">
				No Wall Paper of the day image
			</s:if>
			</div>
		</div>
		<div class="clear"></div>
		<div class="box-l">
			<div id="slideshow" class="inspiration">
				<s:if test="%{!#request.slideShowImages.isEmpty()}">
				<s:iterator value="%{#request.slideShowImages}" status="start">
					<s:if test="#start.count == 1">
						<a href="imagePreview?type=<s:property value="categoryMaster.categoryName"/>"> <img src="<s:property value="thumbnail"/>" alt="" class="active"/> </a>		
					</s:if>
					<s:if test="#start.count != 1">
						<a href="imagePreview?type=<s:property value="categoryMaster.categoryName"/>"> <img src="<s:property value="thumbnail"/>" onclick="" alt=""/></a>		
					</s:if>
				</s:iterator>
				</s:if>
				<s:if test="%{#request.slideShowImages.isEmpty()}">
					No Latest Presentation and Wall paper images
				</s:if>				 
			</div>
		</div>
	</div>
	<div class="box-l">
		<div class="ado">
			<div class="log-media-a">
				<div class="title"><s:text name="home.latestAudeos"></s:text></div>
				<table width="0" border="0">
				<s:if test="%{!#request.audio.isEmpty()}">
					<s:iterator value="%{#request.audio}">
            			<tr>
                        <td><a href="#" onclick="changeFile('<s:property value="preview"/>')"><s:property value="title"/></a></td>
                      </tr>
            		</s:iterator>
		            <tr>
		            	<td align="right"><a href="audioVideoPreview?type=audio">See More</a></td>
		            </tr>
		        </s:if>
		        <s:if test="%{#request.audio.isEmpty()}">
		        	No Audio files
		        </s:if>
				</table>
			</div>
		</div>
	</div>
	<div class="clear"></div>
</div>
<s:include value="footer.jsp"></s:include>
