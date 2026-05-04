<!DOCTYPE html>
<html>

<head>
    <title>Payment</title>
    <link rel="stylesheet" href="/style.css?v=yellow-2">
</head>

<body>

    <div class="form-container">
        <h2>Enter Payment Info</h2>

        <form method="post" action="/book/confirm/${listingId}">
            <input type="text" name="fname" placeholder="First Name" required />
            <input type="text" name="lname" placeholder="Last Name" required />
            <input type="email" name="email" placeholder="Email" required />
            <input type="text" name="cardNumber" placeholder="Card Number" required />

            <button type="submit">Pay & Book</button>
        </form>
    </div>

</body>

</html>
