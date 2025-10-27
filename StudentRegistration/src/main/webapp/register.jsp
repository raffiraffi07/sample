<!DOCTYPE html>
<html>
<head>
    <title>Student Registration</title>
    <link rel="stylesheet" href="css/style.css">
    <script>
        function validateForm() {
            let name = document.forms["regForm"]["name"].value;
            let email = document.forms["regForm"]["email"].value;
            let course = document.forms["regForm"]["course"].value;
            if (name == "" || email == "" || course == "") {
                alert("All fields must be filled out");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <h2>Student Registration Form</h2>
    <form name="regForm" action="register" method="post" onsubmit="return validateForm()">
        Name: <input type="text" name="name"><br><br>
        Email: <input type="email" name="email"><br><br>
        Course: <input type="text" name="course"><br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
