<h2>Customer Form</h2>

<form action="<#if customer.customerId??>/customers/update/${customer.customerId}<#else>/customers</#if>" method="post">

    First Name:
    <input type="text" name="fname" value="${customer.fname!""}"><br>

    Last Name:
    <input type="text" name="lname" value="${customer.lname!""}"><br>

    Email:
    <input type="text" name="email" value="${customer.email!""}"><br>

    Phone:
    <input type="text" name="phone" value="${customer.phone!""}"><br>

    <button type="submit">
        <#if customer.customerId??>Update<#else>Create</#if>
    </button>
</form>