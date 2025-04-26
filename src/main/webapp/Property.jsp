<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>PropertyHub - Properties List</title>
    <link rel="stylesheet" href="css/homeStyle.css"> <!-- Link to external CSS for styles -->

    <!-- Include Font Awesome CDN -->
    <link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css'>
    
    <style>

        header {
            background-color: #ff6f61; /* Primary color for header */
            padding: 20px;
            color: white;
        }
        header .logo h1 {
            margin: 0;
        }
        nav ul {
            list-style-type: none;
            padding: 0;
        }
        nav ul li {
            display: inline;
            margin-right: 20px;
        }
        nav ul li a {
            color: white;
            text-decoration: none;
        }
        .advertisers-service-sec {
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
            padding: 20px;
        }
        .property-card {
            border: 1px solid #ccc;
            border-radius: 8px;
            padding: 20px;
            margin: 10px;
            background-color: white;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2); /* Slightly stronger shadow */
            width: calc(33% - 40px); /* Responsive width */
            box-sizing: border-box; /* Include padding and margin in the width */
            transition: transform 0.3s, box-shadow 0.3s; /* Smooth scaling and shadow on hover */
        }
        .property-card:hover {
            transform: translateY(-5px); /* Slight lift on hover */
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3); /* Deeper shadow on hover */
        }
        .property-header {
            font-size: 1.5em;
            margin-bottom: 10px;
            color: #ff6f61; /* Primary color */
            border-bottom: 2px solid #32dbc2; /* Underline with secondary color */
            padding-bottom: 5px; /* Space below the header */
            transition: color 0.3s; /* Smooth color transition */
        }
        .property-header:hover {
            color: #32dbc2; /* Change color on hover */
        }
        .property-detail {
            margin-bottom: 10px;
            font-size: 1.1em; /* Slightly larger font for details */
            line-height: 1.4; /* Better line spacing */
            opacity: 0.9; /* Slight transparency */
            transition: opacity 0.3s; /* Smooth opacity transition */
        }
        .property-card:hover .property-detail {
            opacity: 1; /* Full opacity on hover */
        }
        .property-icon {
            font-size: 2em;
            color: #32dbc2; /* Customize icon style */
            margin-right: 10px;
        }
        .detail-label {
            font-weight: bold; /* Make labels bold */
            color: #555; /* Slightly darker color for labels */
        }
        .detail-value {
            color: #666; /* Lighter color for values */
        }
        footer {
            text-align: center;
            padding: 20px;
            background-color: #333; /* Dark background for footer */
            color: white;
            position: relative;
            bottom: 0;
            width: 100%;
            margin-top:100px;
        }
    </style>
</head>
<body>

<header>
    <div class="logo">
        <h1>PropertyHub</h1>
    </div>
    <nav>
        <ul>
            <li><a href="home.jsp">Home</a></li>
            <li><a href="Property.jsp">Property</a></li>
            <li><a href="aboutUs.jsp">About Us</a></li>
            <li><a href="login.jsp">Login</a></li>
            <li><a href="signup.jsp">Sign Up</a></li>
        </ul>
    </nav>
</header>

<div id="itemsContainer" class="advertisers-service-sec">
    <!-- The properties will be loaded here -->
</div>

<script>
    // Function to load items from the server
    function loadItems() {
        fetch('properties') // Adjust the URL according to your server setup
            .then(response => response.text())
            .then(data => {
                document.getElementById('itemsContainer').innerHTML = data;
            })
            .catch(error => {
                console.error('Error fetching items:', error);
                document.getElementById('itemsContainer').innerHTML = '<h2>Failed to load items.</h2>';
            });
    }

    // Call the function to load items when the page is loaded
    window.onload = loadItems;
</script>

<footer>
    <p>&copy; 2024 PropertyHub. All rights reserved.</p>
</footer>

</body>
</html>
