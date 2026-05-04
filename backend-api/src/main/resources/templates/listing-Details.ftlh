<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listing Details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/CSS/style.css">
</head>

<body>

<nav class="navbar">
    <div class="logo">Super Smart Bros</div>
    <ul>
        <li><a href="/index">Home</a></li>
        <li><a href="/destination">Menu</a></li>
        <li><a href="/listings">Listings</a></li>
    </ul>
</nav>

<div class="details-container">
    <div class="details-hero">
        <h1>${listing.game}</h1>
        <p class="subtitle">Coaching Session Details</p>
    </div>
    <div class="details-card">
        <div class="details-grid">
            <div class="details-box">
                <h2>Session Info</h2>
                <p><span class="label">Game:</span> ${listing.game}</p>
                <p><span class="label">Experience Level:</span> ${listing.experience}</p>
                <p><span class="label">Session Type:</span> ${listing.sessionType}</p>
                <p><span class="label">Price:</span> $${listing.price}</p>
            </div>

            <div class="details-box highlight-box">
                <h2>Coach Bio</h2>
                <p>${listing.bio}</p>
            </div>
        </div>

        <div class="button-row">
            <a href="/listings" class="btn-secondary">← Back</a>
            <a href="/book/${listing.sessionId}" class="btn-primary">Book Session</a>
        </div>
        <div class="button-row">
            <a href="/reviews/listing/id/${listing.sessionId}" class="btn-primary">View Reviews</a>
        </div>
    </div>
</div>

</body>
</html>