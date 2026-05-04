<a href="/customers/new">Create Customer Profile</a>

<h2>Available Coaching Services</h2>

<#list services as service>
    <div style="border:1px solid black; margin:10px; padding:10px;">

        <h3>${service.game}</h3>

        <p><strong>Experience:</strong> ${service.experience}</p>
        <p><strong>Main Character:</strong> ${service.mainC!"N/A"}</p>
        <p><strong>Session Type:</strong> ${service.sessionType}</p>
        <p><strong>Price:</strong> $${service.price}</p>
        <p><strong>Bio:</strong> ${service.bio!"No bio available"}</p>

        <a href="/bookings/new/${service.sessionId}">Book</a>
    </div>
</#list>