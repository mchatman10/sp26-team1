<!DOCTYPE html>
<html>

<head>
    <title>Signup</title>
    <link rel="stylesheet" href="/style.css?v=yellow-2">
</head>

<body class="auth-page">

    <div class="form-container auth-card">
        <h2>Create Account</h2>

        <form method="post" action="/signup">
            <input type="text" name="fname" placeholder="First Name" required />
            <input type="text" name="lname" placeholder="Last Name" required />
            <input type="text" name="phone" placeholder="Phone Number" required />
            <input type="text" name="email" placeholder="Email" required />
            <input type="password" name="password" placeholder="Password" required />

            <button type="submit">Sign Up</button>
        </form>

        <a href="/login">Already have an account? Login</a>
    </div>

</body>

</html>
