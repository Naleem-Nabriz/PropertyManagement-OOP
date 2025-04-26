<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Items Display</title>
    <style>
        /* Optional styling for the items container */
        #itemsContainer {
            margin: 20px;
            padding: 10px;
        }
    </style>
</head>
<body>


<div id="itemsContainer">
    <!-- Loaded items will be inserted here -->
    <p>Loading items...</p>
</div>

<script>
    // Function to load items from the server
    function loadItems() {
        fetch('displayproperties') // Adjust the URL according to your server setup
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                return response.text();
            })
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

</body>
</html>
