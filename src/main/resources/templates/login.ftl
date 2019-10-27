<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>

<@c.page>
    <@l.login "/login" />
    <h3>Login page</h3><br/>
    <a href="/registration">Add new user</a>
</@c.page>