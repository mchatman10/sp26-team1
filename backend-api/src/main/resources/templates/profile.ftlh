<!DOCTYPE html>
<html>

<head>
    <title>Edit Profile</title>
    <link rel="stylesheet" href="/style.css?v=yellow-2">
</head>

<body>

    <div class="navbar">
        <div class="logo">Super Smart Bros!</div>
        <div>
            <a href="/services">Home</a>
            <a href="/customers/profile">Profile</a>
            <a href="/logout">Sign Out</a>
        </div>
    </div>

    <div class="form-container">
        <h1>Edit Profile</h1>

        <form method="post" action="/customers/profile" class="coaching-form">

            <div class="form-group">
                <label>First Name</label>
                <input type="text" name="fname" value="${customer.fname}" required />
            </div>

            <div class="form-group">
                <label>Last Name</label>
                <input type="text" name="lname" value="${customer.lname}" required />
            </div>

            <div class="form-group">
                <label>Email</label>
                <input type="email" name="email" value="${customer.email}" required />
            </div>

            <div class="form-group">
                <label>Phone Number</label>
                <input type="text" name="phone" value="${customer.phone!""}" required />
            </div>

            <button type="submit" class="submit-btn">Save Changes</button>
        </form>
    </div>

</body>

</html>
