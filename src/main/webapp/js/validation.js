// Validation for Login Form
// validation.js

function validateLogin() {
    var email = document.getElementById("loginEmail").value;
    var password = document.getElementById("loginPassword").value;
    var isValid = true;

    // Clear previous error messages
    document.getElementById("loginEmailError").innerText = "";
    document.getElementById("loginPasswordError").innerText = "";

    // Email validation
    if (email === "") {
        document.getElementById("loginEmailError").innerText = "Email is required.";
        isValid = false;
    }

    // Password validation
    if (password === "") {
        document.getElementById("loginPasswordError").innerText = "Password is required.";
        isValid = false;
    }

    return isValid;
}


// Validation for Sign-Up Form
function validateSignUp() {
    const email = document.getElementById('signupEmail').value;
    const password = document.getElementById('signupPassword').value;
    const confirmPassword = document.getElementById('signupConfirmPassword').value;
    const emailError = document.getElementById('signupEmailError');
    const passwordError = document.getElementById('signupPasswordError');
    const confirmPasswordError = document.getElementById('signupConfirmPasswordError');

    let isValid = true;
    emailError.textContent = '';
    passwordError.textContent = '';
    confirmPasswordError.textContent = '';

    if (!email.includes('@') || !email.includes('.')) {
        emailError.textContent = 'Please enter a valid email address.';
        isValid = false;
    }

    if (password.length < 6) {
        passwordError.textContent = 'Password must be at least 6 characters long.';
        isValid = false;
    }

    if (password !== confirmPassword) {
        confirmPasswordError.textContent = 'Passwords do not match.';
        isValid = false;
    }

    return isValid;
}
