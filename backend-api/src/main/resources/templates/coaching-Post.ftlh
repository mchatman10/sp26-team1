<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Create Coaching Post</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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

    <div class="form-container">
        <h1>Create a Coaching Listing</h1>

        <form action="/listings/create" method="post" class="coaching-form">

    <!-- Game Selection -->
    <div class="form-group">
        <label>Game(s) You Coach</label>

        <details class="multi-select">
            <summary>Select Games</summary>
            <div class="checkbox-container">
                <label><input type="checkbox" name="games" value="OG"> Super Smash Bros.</label>
                <label><input type="checkbox" name="games" value="Sixty"> Super Smash Bros. 64</label>
                <label><input type="checkbox" name="games" value="Melee"> Super Smash Bros. Melee</label>
                <label><input type="checkbox" name="games" value="Brawl"> Super Smash Bros. Brawl</label>
                <label><input type="checkbox" name="games" value="For"> Super Smash Bros. 4</label>
                <label><input type="checkbox" name="games" value="Ult"> Super Smash Bros. Ultimate</label>
</div>
        </details>
    </div>

    <!-- Experience -->
    <div class="form-group">
        <label for="experience">Experience Level</label>
        <select id="experience" name="experience" required>
            <option value="">Select your level</option>
            <option value="beginner">Beginner</option>
            <option value="casual">Casual</option>
            <option value="intermediate">Intermediate</option>
            <option value="advanced">Advanced</option>
            <option value="competitive">Competitive</option>
            <option value="professional">Professional</option>
        </select>
    </div>

    <!-- Character -->
    <div class="form-group">
        <label for="character">Main Character</label>
        <input type="text" id="character" name="character" required>
    </div>

    <!-- Price -->
    <div class="form-group">
        <label for="price">Price Rate ($ per hour)</label>
        <input type="number" id="price" name="price" min="0" required>
    </div>

    <!-- Session -->
    <div class="form-group">
        <label for="session">Session Type</label>
        <select id="session" name="session" required>
            <option value="">Select session type</option>
            <option value="vod">VOD Review</option>
            <option value="live">Live Coaching</option>
            <option value="match-analysis">Match Analysis</option>
            <option value="training">Training Session</option>
            <option value="custom">Custom Session</option>
        </select>
    </div>

    <!-- Bio -->
    <div class="form-group">
        <label for="bio">Biography</label>
        <textarea id="bio" name="bio" rows="6" required></textarea>
    </div>

    <button type="submit" class="submit-btn">Post Listing</button>

</form>
</div>

</body>
</html>
