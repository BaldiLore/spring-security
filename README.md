
# Authentication with JWT Token

This project aims to define a template for managing authentication using Spring Security.

***!!!Disclaimer:*** This project was created for educational purposes only. The author assumes no responsibility for any improper use of the code in this project.

## API Reference

#### Test access to the private resource

```http
  GET /private/auth
```

#### Get item

```http
  GET /public/no-auth
```


## VM Options

To test this project with different security configurations, you will need to start it with one of the following profiles:
- dev
- prod

With ***dev*** profile the security configuretion allows to access all resources regardless of the presence or validity of the token.

With ***prod*** profile the security configuration allows to access /public/* resurces without token validation while all other resources need a valid JWT Token.

