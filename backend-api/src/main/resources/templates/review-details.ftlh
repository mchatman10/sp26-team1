<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Review Details</title>
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

<div class="container mt-5">
    <div class="card shadow">
        <div class="card-body">
            <h2 class="card-title text-center mb-4">
                Review Details
            </h2>
            <div class="mb-3">
                <h5>Rating</h5>
                <p>${review.rating}/10</p>
            </div>
            <div class="mb-3">
                <h5>Comment</h5>
                <p>${review.comment}</p>
            </div>
            <div class="mb-3">
                <h5>Customer</h5>
                <p>
                    <#if review.customer??>
                        ${review.customer.name}
                    <#else>
                        Unknown Customer
                    </#if>
                </p>
            </div>
            
            <div class="mb-3">
                <h5>Listing</h5>
                <p>
                    <#if review.listing??>
                        ${review.listing.game} - ${review.listing.sessionType}
                    <#else>
                        Unknown Listing
                    </#if>
                </p>
            </div>

            <div class="text-center mt-4">
                <a href="/reviews/{listingId}" class="btn btn-secondary">Back to Reviews</a>

                <#if review.listing??>
                    <a href="/listings/id/${review.listing.sessionId}" class="btn btn-primary">
                        View Listing
                    </a>
                </#if>
            </div>
        </div>
    </div>
</div>

</body>
</html>