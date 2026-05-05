<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Reviews</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/CSS/style.css" rel="stylesheet">
</head>

<body>

<div class="navbar">
    <div class="logo">Coach Dashboard</div>
    <ul>
        <li><a href="/provider/dashboard/${provider.providerId}">Home</a></li>
        <li><a href="/provider/update/${provider.providerId}">Edit Profile</a></li>
        <li><a href="/listings/create/${provider.providerId}">Create a Coaching Post</a></li>
        <li><a href="/login">Logout</a></li>
    </ul>
</div>

<div class="container mt-4">

    <h1 class="text-center mb-4">Reviews</h1>
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <#list reviews as review>
            <div class="col">
                <div class="card h-100 shadow">
                    <div class="card-body">
                        <h5 class="card-title">Rating: ${review.rating}/10</h5>
                        <p class="card-text">Comment: ${review.comment}</p>
                    </div>
                </div> 
            </div>
        </#list>
    </div>
    <a href="/listings/id/${listing.sessionId}" class="btn-secondary">← Back</a>
</div>

</body>
</html>