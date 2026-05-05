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
            <div class="account-toggle">
                <label>
                    <input type="radio" name="accountType" value="customer" checked />
                    Customer
                </label>
                <label>
                    <input type="radio" name="accountType" value="provider" />
                    Provider
                </label>
            </div>

            <div class="customer-fields">
                <input type="text" name="fname" placeholder="First Name" required />
                <input type="text" name="lname" placeholder="Last Name" required />
                <input type="text" name="phone" placeholder="Phone Number" required />
            </div>

            <input type="email" name="email" placeholder="Email" required />
            <input type="password" name="password" placeholder="Password" required />

            <button type="submit">Sign Up</button>
        </form>

        <a href="/login">Already have an account? Login</a>
    </div>

    <script>
        const accountTypes = document.querySelectorAll('input[name="accountType"]');
        const customerFields = document.querySelector('.customer-fields');
        const customerInputs = customerFields.querySelectorAll('input');

        function updateAccountFields() {
            const isProvider = document.querySelector('input[name="accountType"]:checked').value === 'provider';
            customerFields.hidden = isProvider;
            customerInputs.forEach((input) => {
                input.disabled = isProvider;
                input.required = !isProvider;
            });
        }

        accountTypes.forEach((input) => input.addEventListener('change', updateAccountFields));
        updateAccountFields();
    </script>

</body>

</html>
