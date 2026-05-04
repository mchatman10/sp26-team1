<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Listing Details</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="/CSS/style.css">
</head>

<body>

<div class="navbar">
    <div class="logo">Coach Dashboard</div>
    <ul>
        <li><a href="/provider/dashboard/${provider.providerId}">Home</a></li>
        <li><a href="/provider/update/${provider.providerId}">Edit Profile</a></li>
        <li><a href="/listings/create/${provider.providerId}">Create a Coaching Post</a></li>
        <li><a href="/provider/login">Logout</a></li>
    </ul>
</div>

<div class="details-container">
    <div class="details-hero">
        <h1>${provider.gameUser!"Coach"}</h1>
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
                <h2>More Info</h2>
                <p>${listing.bio}</p>
            </div>
        </div>

        <div class="button-row">
            <a href="/provider/dashboard/${provider.providerId}" class="btn-secondary">← Back</a>
            <a href="/reviews/listing/id/${listing.sessionId}" class="btn-primary">View Reviews</a>
        </div>
        <div class="button-row">
            <a href="/listings/delete/${listing.sessionId}" class="btn-secondary">Delete Coaching Post</a>
        </div>
    </div>
</div>

</body>
</html>