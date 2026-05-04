<h2>Write Review</h2>

<form action="/reviews" method="post">

    <input type="hidden" name="listingId" value="${listing.sessionId}">
    <input type="hidden" name="customerId" value="1">

    Rating: <input type="number" name="rating"><br>
    Comment: <input type="text" name="comment"><br>

    <button type="submit">Submit</button>
</form>