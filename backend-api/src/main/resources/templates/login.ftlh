<!DOCTYPE html>
<html>

<head>
    <title>Login</title>
    <link rel="stylesheet" href="/style.css?v=yellow-2">
</head>

<body class="auth-page">

    <div class="form-container auth-card">
        <h2>Login</h2>

        <form method="post" action="/login">
            <input type="email" name="username" placeholder="Email Address" required />
            <input type="password" name="password" placeholder="Password" required />
            <button type="submit">Login</button>
        </form>

        <a href="/signup">Don't have an account? Sign up</a>
    </div>

</body>

</html>
