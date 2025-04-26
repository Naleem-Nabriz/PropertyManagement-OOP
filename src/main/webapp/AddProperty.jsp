<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Property Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            color: #333;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 400px;
            margin: 10px auto;
            background: #f0f0f0;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 0 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #ff6f61;
            text-align: center;
            margin-bottom: 10px;
        }
        .form-group {
            margin-bottom: 8px;
        }
        label {
            display: block;
            margin-bottom: 3px;
            font-weight: bold;
            color: #555;
        }
        input[type="text"],
        input[type="number"],
        textarea,
        select {
            width: calc(100% - 10px);
            padding: 6px;
            margin: 2px 0 6px;
            border: 1px solid #ccc;
            border-radius: 4px;
            background-color: #fff;
            color: #333;
            box-sizing: border-box;
        }
        textarea {
            resize: vertical;
            max-height: 80px;
        }
        button {
            background-color: #ff6f61;
            color: #fff;
            border: none;
            padding: 8px;
            cursor: pointer;
            border-radius: 4px;
            width: 100%;
            margin-top: 8px;
        }
        button:hover {
            background-color: #e65a50;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>Property Details</h2>
        <form action="addproperty" method="POST">
            <div class="form-group">
                <label for="propertyName">Property Name:</label>
                <input type="text" id="propertyName" name="propertyName" required>
            </div>
            <div class="form-group">
                <label for="propertyType">Property Type:</label>
                <select id="propertyType" name="propertyType" required>
                    <option value="House">House</option>
                    <option value="Apartment">Apartment</option>
                    <option value="Condo">Condo</option>
                    <option value="Land">Land</option>
                </select>
            </div>
            <div class="form-group">
                <label for="location">Location:</label>
                <input type="text" id="location" name="location" required>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" id="price" name="price" required>
            </div>
            <div class="form-group">
                <label for="description">Description:</label>
                <textarea id="description" name="description" rows="2" required></textarea>
            </div>
            <div class="form-group">
                <label for="contact">Contact Information:</label>
                <input type="text" id="contact" name="contact" required>
            </div>
            <button type="submit">Submit Property</button>
        </form>
    </div>
</body>
</html>
