<h2>Book Service</h2>

<p>Service: ${listing.title}</p>

<form action="/bookings" method="post">

    <input type="hidden" name="listingId" value="${listing.sessionId}">
    <input type="hidden" name="customerId" value="1">

    <button type="submit">Confirm Booking</button>
</form>