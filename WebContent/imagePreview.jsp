<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<s:include value="header.jsp"></s:include>
	<s:include value="menu.jsp"></s:include>
	<s:form action="imagePreview?type=%{#request.categoryName}%{#request.pageFrom}">

	<div class="content">
	<script type="text/javaScript">
		function showImage(src){ 
			document.getElementById("overlay").style.display = '';
			document.getElementById("overlay").innerHTML = '<img src="'+ src +'" width: 200; height: 100"/>';
		}
		
	</script>
		<div class="left-cont">
  			<div class="box-l">
        	<div class="events-select"> 
            <s:select list="%{#request.albumDropdown}" headerValue="Album" headerKey="-1" name="album">
            </s:select> 
            </div>
            <div class="events-select">
            <s:select list="%{#request.artistDropdown}" headerValue="Artist" headerKey="-1" name="artist">
            </s:select> 
            </div>
            <div class="events-select"> 
	            <s:select list="%{#request.languagesDropdown}" headerValue="Language" headerKey="-1" name="spLanguage">
	            </s:select> 
            </div>
            <div class="events-select"> 
	            <s:select list="%{#request.ocassionDropdown}" headerValue="Occasion" headerKey="-1" name="ocassion">
	            </s:select> 
            </div>
            <div class="events-select"> 
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
            </div>
           <div class="events-select">
            <s:textfield name="keyword" type="text" value="Keyword" size="20" maxlength="30" onkeydown="if(event.keyCode == 13) document.forms[0].submit();"/>
           </div>
             <div class="events-select">
            <input name="Sort" type="submit" value="Sort" />
           </div>
         	<div class="clear"></div>  
         </div>
         	<div class="box-l">         
             <table class="conference">
                <tr class="table-header">
                     <td class="table-events">Title</td>
                    <td class="table-events">Occasion</td>
                    <td class="table-disc">Artist</td>
                    <td class="table-date">Album</td>
                    <td class="table-place">Language</td>
                    <td class="table-place"></td>
                </tr>
                <s:if test="%{#request.mediaMasters.isEmpty()}">
                	<tr><td colspan="6" align="center">No Images</td></tr>
				</s:if>
                <s:if test="%{!#request.mediaMasters.isEmpty()}">
                <s:iterator value="%{#request.mediaMasters}">
                <tr>
                    <td class="table-events"><s:property value="title"/></td>
                    <td class="table-events"><s:property value="ocassion"/></td>
                    <td class="table-disc"><s:property value="artist"/></td>
                    <td class="table-date"><s:property value="album"/></td>
                    <td class="table-place"><s:property value="languageMaster.languageName"/></td>
                    <td class="table-place"><a href="javascript:alert(1);showImage('<s:property value="thumbnail"/>');">View Image</a></td>
                </tr>
                </s:iterator>
                </s:if>
            </table>
		</div> 
        	<div class="clear"></div>
		</div>
        <div class="right-cont">
        	<marquee behavior="scroll" direction="down">
        		<s:iterator value="%{#request.mediaMasters}">
        			<img src='<s:property value="thumbnail"/>'/>
        		</s:iterator>
        	</marquee>
        </div>
        <div class="clear"></div>
    </div>
</s:form>
    
<s:include value="footer.jsp"></s:include>    