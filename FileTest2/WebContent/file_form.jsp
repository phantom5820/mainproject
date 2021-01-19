<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>파일 업로드 폼</title>

		<script>
			$(function(){
				var count = 3;//첨부파일 태그 개수
				$("#plus").click(function(){
					if(count == 5) return;
					count++;
					$("#frm").append("<p><input type='file' name='file'"+count+"'></p>");	
				});
				$("#minus").click(function(){
					if(count == 1) return;
					/* alert($(this).parent().parent().children("p").length); 선택자 확인*/
					/*alert($(this).parent().parent().children("p").last().children().attr("name")); 선택자확인*/
					$(this).parent().parent().children("p").last().remove();
					count--;
				});
			});
		</script>
</head>
<body>
	<form action="upload.do" enctype="multipart/form-data" method="post" id="frm">
		작성자 : <input type="text" name="param"><br>
		<p><input type="text" name="writer"></p> 
		<p><button>전송</button>
		<button type="button" id="plus">+</button>
		<button type="button" id="minus">-</button></p>
		<p><input type="file" name="file1"><br> 
		<p><input type="file" name="file2"><br></p> 
		<p><input type="file" name="file3"><br></p> 
	</form>
</body>
</html>