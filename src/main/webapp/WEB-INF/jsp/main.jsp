<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>${title}</title>
    <link href="/css/main.css" rel="stylesheet">
</head>
<body>
<div style="text-align: center">
<a href="/">
    Home
</a>

<a href="/heroes">
    Heroes
</a>

<a href="/comics">
    Comics
</a>
    </div>


<%
    String link= (String) request.getAttribute("link");
    Integer count= (Integer) request.getAttribute("count");

    if (link instanceof String) {
        out.print("<label>Input count of Items</label>");
        out.print("<select data-link=\""+link+"\" onchange=\"chooseCount(this)\">");
        for(int i=1; i<=100; i++){
            if (count instanceof Integer && count==i) {
                out.print("<option selected>" + i + "</option>");
            } else {
                out.print("<option>" + i + "</option>");
            }
        }
        out.print("</select>");
    }

%>
${result}


<script src="/js/main.js"></script>
</body>
</html>