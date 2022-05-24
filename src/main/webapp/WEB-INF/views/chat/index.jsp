<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>채팅창 입장 및 채팅 리스트</title>
	<script src="/js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript">
		let myChatRoom = "";

		$(window).on('load', function () {
			getRoomList();
		});

		function getRoomList() {
			$.ajax({
				url : "/chat/roomList",
				type : "post",
				dataType : "JSON",
				contentType : "application/json; charset=UTF-8",
				success : function (json) {
					for (let i = 0; i < json.length; i++) {
						$("#roomList").append(json[i] + "</br>");
					}
				}
			})
		}
	</script>
</head>
<body>
	<h1>채팅방 전체 리스트</h1>
</hr>
	<form method="post" action="/chat/intro">
		<label for="room_name">채팅방 이름 : </label><input type="text" name="room_name" id="room_name"/> </br>
		<label for="user_name">유저 이름 : </label><input type="text" name="user_name" id="user_name"/> </br>
		<input type="submit" value="입장"/>
	</form>
</body>
</html>