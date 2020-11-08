<%--
  Created by IntelliJ IDEA.
  User: React
  Date: 07.11.2020
  Time: 20:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ua.prog.kiev.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
  <title>Survey</title>
</head>
<body>
<form action="/stat" method="POST">
  First name: <input type="text" name="name"><br>
  Last name: <input type="text" surname="surname"><br>
  Your age: <input type="text" age="age"><br>
  <%QuestionList statements = QuestionServlet.questionList;%>
  <%for(int i = 0; i < QuestionServlet.questionList.size(); i++){%>
    <br/><h3><%=statements.getQuestion(i)%></h3>
    <br/><input type = "radio" name = "answer<%=String.valueOf(i)%>" value = "yes" /> Yes
    <br/><input type = "radio" name = "answer<%=String.valueOf(i)%>" value = "no" /> No
  <%}%>
  <br/>
  <br/><input type="submit" value="Send"> </input>
</form>
</body>
</html>
