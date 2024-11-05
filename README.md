
### Extra-detailed instructions are located here:
[OAuth2 Setup Guide](docs/oauth2-setup.md)


## OAuth2 Setup Information

To get started with Google OAuth2 in this project, follow these steps:

1. **Google Cloud Console Setup**:
   - Navigate to the [Google Cloud Console](https://console.cloud.google.com/).
   - Create a new project.
   - Set up OAuth consent screen (make sure to set the type as external).
   - Add test users (use Gmail accounts).
   - Create OAuth credentials (set application type as web application).
   - Copy your **client ID** and **client secret** to the appropriate fields in the `application.properties` file.

2. **Configure `application.properties`**:
   ```
   spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
   spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
   spring.security.oauth2.client.registration.google.redirect-uri=http://localhost:8080/login/oauth2/code/google
   spring.security.oauth2.client.registration.google.scope=openid,profile,email
   ```

3. **Run the application** and navigate to `/login` to trigger the Google OAuth2 login flow.

For more in-depth instructions, you can check out [Dan Vega's OAuth2 Video](https://www.youtube.com/watch?v=s8p5LyZrxmw).

