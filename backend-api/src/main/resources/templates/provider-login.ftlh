<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/CSS/style.css">
</head>
<body>
<div class="form-container">
    <h1>Coach Login</h1>
    <form class="coaching-form" method="post" action="/provider/login">
        <div class="form-group">
            <label for="email">Email</label>
            <input type="email" name="email" id="email" placeholder="Enter your email" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" placeholder="Enter your password" required>
        </div>

        <button type="submit" class="submit-btn">Login</button>
    </form>
    <#if error??>
        <p style="color:red; text-align:cen ter; margin-top:15px;">
            Invalid email or password
        </p>
    </#if>
    <div style="text-align:center; margin-top:20px;">
        <a href="/provider/register" class="btn-secondary">Create Account</a>
    </div>
</div>
</body>
</html>