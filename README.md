# spring-boot2-oauth2-sample

This is a sample project about implement OAuth2 with Spring Boot 2.

You can find all the documentation in this post.

http://rfvallina.com/blog/2019/03/14/spring-boot-2-oauth2.html

## Build and Run

```sh
mvn clean install
mvn spring-boot:run
```

## Testing

```sh
curl -X POST --user "spring-sample:a843jdf8ak" -d "grant_type=password&username=enduser&password=password" http://localhost:8080/oauth/token
```

This command returns something like this:

```json
{
    "access_token": "a98e2a68-89dc-4991-ba6e-c8713f56ec5f",
    "token_type": "bearer",
    "refresh_token": "1c46f591-ed6f-4e0a-93f5-b9811179c028",
    "expires_in": 43199,
    "scope": "read write"
}
```

Then, you can invoke an api resource like this:

```sh
curl --header "Authorization: Bearer a98e2a68-89dc-4991-ba6e-c8713f56ec5f" http://localhost:8080/api/v1/test
```

The response will be similar to this:

```json
{
    "id": "5456806040857622917",
    "time": "2019-03-14 08:07:14.461"
}
```
