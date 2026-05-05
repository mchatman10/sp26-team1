<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Profile</title>
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
        <h1>Edit Profile</h1>
        <p class="subtitle">Update your coaching details</p>
    </div>
    <div class="details-card">
        <#if error?? && error>
            <div style="color:red; margin-bottom:20px;">
                Failed to update profile. Try again.
            </div>
        </#if>
        <form class="coaching-form" action="/provider/update/${provider.providerId}" method="post">
            <div class="details-grid">
                <div class="details-box highlight-box">
                    
                    <div class="form-group">
                        <label>Name</label>
                        <input type="text" name="name" value="${provider.name!}">
                    </div>
                    <div class="form-group">
                        <label>Username</label>
                        <input type="text" name="gameUser" value="${provider.gameUser!}">
                    </div>
                    <div class="form-group">
                        <label>Socials</label>
                        <input type="text" name="socials" value="${provider.socials!}">
                    </div>
                    <div class="form-group">
                        <label>Email</label>
                        <input type="email" name="email" value="${provider.email!}" required>
                    </div>
                    <div class="form-group">
                        <label>Password</label>
                        <input type="password" name="password" value="${provider.password!}" required>
                    </div>
                    <div class="form-group">
                        <label>Bio</label>
                        <textarea name="bio" rows="6">${provider.bio!}</textarea>
                    </div>
                </div>
            </div>
            <div class="button-row">
                <a class="btn-secondary" href="/provider/dashboard/${provider.providerId}">Cancel</a>
                <button type="submit" class="btn-primary">Save Changes</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>