<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head profile="http://www.w3.org/2005/10/profile">


    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,
    initial-scale=1.0">


    <script type="text/javascript">


        var xhr = new XMLHttpRequest();
        var url = 'http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst'; /*URL*/
        var queryParams = '?' + encodeURIComponent('serviceKey') + '='+'7EpF3TCkgMENfaz3eaLHbldfYrPuDMZRi2IEbYu1fGqnoUxT5ZB6xm28C3Xv6TB2IegtMlKzIlLLNExhFq1FsQ%3D%3D'; /*Service Key*/
        queryParams += '&' + encodeURIComponent('pageNo') + '=' + encodeURIComponent('1'); /**/
        queryParams += '&' + encodeURIComponent('numOfRows') + '=' + encodeURIComponent('1000'); /**/
        queryParams += '&' + encodeURIComponent('dataType') + '=' + encodeURIComponent('JSON'); /**/
        queryParams += '&' + encodeURIComponent('base_date') + '=' + encodeURIComponent('20220404'); /**/
        queryParams += '&' + encodeURIComponent('base_time') + '=' + encodeURIComponent('0600'); /**/
        queryParams += '&' + encodeURIComponent('nx') + '=' + encodeURIComponent('55'); /**/
        queryParams += '&' + encodeURIComponent('ny') + '=' + encodeURIComponent('127'); /**/
        xhr.open('GET', url + queryParams);
        xhr.onreadystatechange = function () {
            if (this.readyState == 4) {
                alert('Status: '+this.status+'nHeaders: '+JSON.stringify(this.getAllResponseHeaders())+'nBody: '+this.responseText);
            }
        };

        xhr.send('');
    </script>


    <title>Document</title>
</head>
<body>


</body>
</html>