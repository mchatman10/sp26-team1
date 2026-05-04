<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Provider Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="/CSS/style.css" rel="stylesheet">
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
                <p><span class="label">Phone:</span> ${provider.phone! "N/A"}</p>
                <p><span class="label">Bio:</span> ${provider.bio! "No bio yet"}</p>
            </div>
            <div class="details-box highlight-box">
                <p><span class="label">Sessions:</span> Coming soon</p>
            </div>
        </div>
        <div class="button-row">
            <a href="/provider/update/${provider.providerId}" class="btn-primary">
                Edit Profile
            </a>

            <a href="/provider" class="btn-secondary">
                Logout
            </a>
        </div>
    </div>
</div>
</body>
</html>