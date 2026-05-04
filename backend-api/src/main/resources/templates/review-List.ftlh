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

<nav class="navbar">
    <div class="logo">Super Smart Bros</div>
    <ul>
        <li><a href="/index">Home</a></li>
        <li><a href="/destination">Menu</a></li>
        <li><a href="/listings">Listings</a></li>
    </ul>
</nav>

<div class="container mt-4">

    <h1 class="text-center mb-4">Reviews</h1>
    <div class="row row-cols-1 row-cols-md-3 g-4">
        <#list reviews as review>
            <div class="col">
                <div class="card h-100 shadow">
                    <div class="card-body">
                        <h5 class="card-title">Rating: ${review.rating}/10</h5>
                        <p class="card-text">Comment: ${review.comment}</p>
                        
                        <a href="/listings/id/${review.listing.sessionId}" class="btn btn-primary">
                        View Listing</a>
                    </div>
                </div> 
            </div>
        </#list>
    </div>
</div>

</body>
</html>