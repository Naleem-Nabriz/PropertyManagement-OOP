<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - PropertyHub</title>
    <link rel="stylesheet" href="css/homeStyle.css">
</head>
<body>
    <header>
        <div class="logo">
            <h1>PropertyHub</h1>
        </div>
        <nav>
            <ul>
                <li><a href="home.jsp">Home</a></li>
                <li><a href="aboutUs.jsp">About Us</a></li>
                <li><a href="login.jsp">Login</a></li>
                <li><a href="signup.jsp">Sign Up</a></li>
            </ul>
        </nav>
    </header>

    <div class="form-container">
        <h2>Login</h2>
        <form id="loginForm" onsubmit="return validateLogin();">
            <div class="form-group">
                <label for="loginEmail">Email</label>
                <input type="email" id="loginEmail" name="loginEmail" placeholder="Enter your email" required>
                <p class="error-message" id="loginEmailError"></p>
            </div>
            <div class="form-group">
                <label for="loginPassword">Password</label>
                <input type="password" id="loginPassword" name="loginPassword" placeholder="Enter your password" required>
                <p class="error-message" id="loginPasswordError"></p>
            </div>
            <button type="submit" class="btn-primary">Login</button>
            <p>Don't have an account? <a href="signup.jsp">Sign Up</a></p>
        </form>
    </div>

    <script src="js/validation.js"></script>
</body>
</html>
