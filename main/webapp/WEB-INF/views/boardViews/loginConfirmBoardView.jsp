<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>로그인 성공</title>
</head>
<body style="text-align: center; margin: 50px;">

    <h2>로그인 성공</h2>
    <form action="loginConfirmBoardView.do" method="post">
        <table style="width: 20%; margin: 0 auto; border: 1px solid gray; border-collapse: collapse;">
            <tr align="center">
                <td colspan="2" style="height: 50px; border: 1px solid gray;">
                    <input type="button" value="전체 회원 리스트보기" onclick="location.href='getBoardList.do';" style="height: 30px;">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
