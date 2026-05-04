<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/CSS/style.css">
</head>
<body>

<div class="navbar">
    <div class="logo">Coach Dashboard</div>
    <ul>
        <li><a href="/provider/dashboard/${provider.providerId}">Home</a></li>
        <li><a href="/provider/update/${provider.providerId}">Edit Profile</a></li>
        <li><a href="/listings/create">Create a Coaching Post</a></li>
        <li><a href="/provider">Logout</a></li>
    </ul>
</div>

<div class="details-container">
    <div class="details-hero">
        <h1>Welcome, ${provider.name! "Coach"}</h1>
        <p class="subtitle">Manage your profile and sessions</p>
    </div>
    <div class="details-card">
        <div class="details-grid">
            <div class="details-box">
                <h2>Profile Info</h2>
                <p><span class="label">Name:</span> ${provider.name! ""}</p>
                <p><span class="label">Email:</span> ${provider.email}</p>
                <p><span class="label">Socials:</span> ${provider.socials! "N/A"}</p>
                <p><span class="label">Bio:</span> ${provider.bio! "No bio yet"}</p>
            </div>
            <div class="details-box highlight-box">
                <h4 class="mb-3 text-white">Sessions:</h4>
                <div class="row g-4 listings-single">
                    <#list listings as listing>
                    <div class="col-12">
                        <div class="card h-100 shadow-sm bg-dark text-white border-0">
                            <div class="card-body">
                                <h5 class="card-title"></h5>
                                <p class="card-text">Game: ${listing.game!""}</p>
                                <p class="card-text">Experience Level: ${listing.experience!""}</p>
                                <p class="card-text">Price: ${listing.price!""}</p>
                                <p class="card-text">Session Type: ${listing.sessionType!""}</p>
                                <p class="card-text">${listing.bio!""}</p>

                                <div class="card-footer bg-transparent border-0 pt-0 px-3 pb-3">
                                    <a href="/listings/id/${listing.sessionId}" class="btn btn-primary w-100">View Details</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </#list>
                </div>
            </div>
        </div>
        <div class="button-row">
            <a href="/provider/update/${provider.providerId}" class="btn-primary">Edit Profile</a>
            <a href="/provider" class="btn-secondary">Logout</a>
        </div>
    </div>
</div>
</body>
</html>