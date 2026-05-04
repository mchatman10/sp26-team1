<!DOCTYPE html>
<html>

<head>
    <title>Sessions</title>
    <link rel="stylesheet" href="/style.css?v=yellow-2">
</head>

<body>

    <div class="navbar">
        <div class="logo">Super Smart Bros!</div>
        <div>
            <a href="/services">Home</a>
            <a href="/customers/profile">Profile</a>
            <a href="/logout">Sign Out</a>
        </div>
    </div>

    <div class="sessions-header">
        <h1>Sessions</h1>
    </div>

    <#if message??>
        <div style="text-align:center; margin:20px; color:lime;">
            ${message}
        </div>
    </#if>

    <div class="grid">
        <#list listings as listing>
            <div class="card">

                <div class="card-content">
                    <h2>${listing.game}</h2>
                    <p>${listing.bio}</p>

                    <p><b>Session:</b> ${listing.sessionType}</p>
                    <p><b>Rate:</b> $${listing.price}/hour</p>

                    <a href="/book/${listing.sessionId}" class="btn">Book</a>

                    <h3>Reviews:</h3>

                    <#if listing.visibleReviews?? && (listing.visibleReviews?size> 0)>
                        <#list listing.visibleReviews as review>
                            <p>${review.comment} - Rating: ${review.rating}/10</p>
                        </#list>
                        <#else>
                            <p>No reviews yet</p>
                    </#if>

                    <#if listing.booked?? && listing.booked==true>
                        <form action="/review/${listing.sessionId}" method="post">
                            <input type="text" name="comment" placeholder="Write review" required />
                            <input type="number" name="rating" min="1" max="10" placeholder="Rating (1-10)" required />
                            <button class="btn">Submit Review</button>
                        </form>
                    </#if>

                </div>
            </div>
        </#list>
    </div>

</body>

</html>
