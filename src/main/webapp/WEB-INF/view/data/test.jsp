<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>애호박 데이터</title>
</head>
<body>
<%@ include file="../include/sidebar.jsp" %>
    <div class='tableauPlaceholder' id='viz1692509983928' style='position: relative'>
        <noscript><a href='#'><img alt='대시보드 2 '
                                   src='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;te&#47;test1_16922577486810&#47;2&#47;1_rss.png'
                                   style='border: none'/></a></noscript>
        <object class='tableauViz' style='display:none;'>
            <param name='host_url' value='https%3A%2F%2Fpublic.tableau.com%2F'/>
            <param name='embed_code_version' value='3'/>
            <param name='site_root' value=''/>
            <param name='name' value='test1_16922577486810&#47;2'/>
            <param name='tabs' value='yes'/>
            <param name='toolbar' value='yes'/>
            <param name='static_image'
                   value='https:&#47;&#47;public.tableau.com&#47;static&#47;images&#47;te&#47;test1_16922577486810&#47;2&#47;1.png'/>
            <param name='animate_transition' value='yes'/>
            <param name='display_static_image' value='yes'/>
            <param name='display_spinner' value='yes'/>
            <param name='display_overlay' value='yes'/>
            <param name='display_count' value='yes'/>
            <param name='language' value='ko-KR'/>
        </object>
    </div>
    <script type='text/javascript'>
        var divElement = document.getElementById('viz1692509983928');
        var vizElement = divElement.getElementsByTagName('object')[0];
        if (divElement.offsetWidth > 800) {
            vizElement.style.width = '100%';
            vizElement.style.height = (divElement.offsetWidth * 0.50) + 'px';
        } else if (divElement.offsetWidth > 500) {
            vizElement.style.width = '100%';
            vizElement.style.height = (divElement.offsetWidth * 0.75) + 'px';
        } else {
            vizElement.style.width = '100%';
            vizElement.style.height = '2577px';
        }
        var scriptElement = document.createElement('script');
        scriptElement.src = 'https://public.tableau.com/javascripts/api/viz_v1.js';
        vizElement.parentNode.insertBefore(scriptElement, vizElement);
    </script>
</body>
</html>