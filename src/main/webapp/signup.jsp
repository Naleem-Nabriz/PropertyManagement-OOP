<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up - PropertyHub</title>
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
        <h2>Sign Up</h2>
        <form id="signupForm" onsubmit="return validateSignUp()">
            <div class="form-group">
                <label for="signupEmail">Email</label>
                <input type="email" id="signupEmail" name="signupEmail" placeholder="Enter your email" required>
                <p class="error-message" id="signupEmailError"></p>
            </div>
            <div class="form-group">
                <label for="signupPassword">Password</label>
                <input type="password" id="signupPassword" name="signupPassword" placeholder="Enter your password" required>
                <p class="error-message" id="signupPasswordError"></p>
            </div>
            <div class="form-group">
                <label for="signupConfirmPassword">Confirm Password</label>
                <input type="password" id="signupConfirmPassword" name="signupConfirmPassword" placeholder="Confirm your password" required>
                <p class="error-message" id="signupConfirmPasswordError"></p>
            </div>
            <button type="submit" class="btn-primary">Sign Up</button>
            <p>Already have an account? <a href="login.jsp">Login</a></p>
        </form>
    </div>

    <script src="./js/validation.js"></script>
</body>
</html>
