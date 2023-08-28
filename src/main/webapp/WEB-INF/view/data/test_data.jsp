<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<%@ include file="../include/sidebar.jsp" %>
<div class='tableauPlaceholder' id='viz1692942877255' style='position: relative'>
    <noscript><a href='#'><img alt='대시보드 1 '
                               src='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;_1&#47;_16928619530630&#47;1&#47;1_rss.png'
                               style='border: none'/></a></noscript>
    <object class='tableauViz' style='display:none;'>
        <param name='host_url' value='https%3A%2F%2Fpublic.tableau.com%2F'/>
        <param name='embed_code_version' value='3'/>
        <param name='path' value='views&#47;_16928619530630&#47;1?:language=ko-KR&amp;:embed=true&amp;publish=yes'/>
        <param name='toolbar' value='yes'/>
        <param name='static_image'
               value='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;_1&#47;_16928619530630&#47;1&#47;1.png'/>
        <param name='animate_transition' value='yes'/>
        <param name='display_static_image' value='yes'/>
        <param name='display_spinner' value='yes'/>
        <param name='display_overlay' value='yes'/>
        <param name='display_count' value='yes'/>
        <param name='language' value='ko-KR'/>
        <param name='filter' value='publish=yes'/>
    </object>
</div>
<script type='text/javascript'>
    var divElement = document.getElementById('viz1692942877255');
    var vizElement = divElement.getElementsByTagName('object')[0];
    if (divElement.offsetWidth > 800) {
        vizElement.style.minWidth = '420px';
        vizElement.style.maxWidth = '650px';
        vizElement.style.width = '100%';
        vizElement.style.minHeight = '587px';
        vizElement.style.maxHeight = '887px';
        vizElement.style.height = (divElement.offsetWidth * 0.75) + 'px';
    } else if (divElement.offsetWidth > 500) {
        vizElement.style.minWidth = '420px';
        vizElement.style.maxWidth = '650px';
        vizElement.style.width = '100%';
        vizElement.style.minHeight = '587px';
        vizElement.style.maxHeight = '887px';
        vizElement.style.height = (divElement.offsetWidth * 0.75) + 'px';
    } else {
        vizElement.style.width = '100%';
        vizElement.style.height = '1077px';
    }
    var scriptElement = document.createElement('script');
    scriptElement.src = 'https://public.tableau.com/javascripts/api/viz_v1.js';
    vizElement.parentNode.insertBefore(scriptElement, vizElement);
</script>
</body>
</html>