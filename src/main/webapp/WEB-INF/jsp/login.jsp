<%@ page language="java" contentType="text/html; charset=windows-1256"
    pageEncoding="windows-1256"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="windows-1256">
<title>Login Page</title>
<style>
/* CSS styles */
body {
  background-color: #f2f2f2;
}
.container {
  margin: auto;
  width: 50%;
  padding: 10px;
  background-color: white;
  border-radius: 5px;
  box-shadow: 0px 0px 5px 0px rgba(0,0,0,0.2);
}
h1 {
  text-align: center;
  color: #555;
}
form {
  display: flex;
  flex-direction: column;
  align-items: center;
}
input[type="text"], input[type="password"] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  box-sizing: border-box;
  border: none;
  border-bottom: 2px solid #ccc;
}
input[type="submit"] {
  background-color: #4CAF50;
  color: white;
  padding: 12px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}
input[type="submit"]:hover {
  background-color: #45a049;
}
</style>
</head>
<body>
  <div class="container">
    <h1>Login</h1>
    ${message}
    <form method="post" action="login">
      <label for="username"><b>Username</b></label>
      <input type="text" placeholder="Enter Username" name="id" required>

      <label for="password"><b>Password</b></label>
      <input type="password" placeholder="Enter Password" name="pwd" required>

      <input type="submit" value="connecter">
    </form>
  </div>
</body>
</html>





