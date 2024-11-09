## Google Cloud OAuth2 Setup

### OAuth Consent Screen Setup

1. **Select a Project:**
   - Go to the [Google Cloud Console](https://console.cloud.google.com/).
   - In the top navigation bar, click on the dropdown and select **New Project**.
   - Give your project a name, select your billing account if needed, and click **Create**.

2. **Publishing Status:**
   - Once your project is created, navigate to the **OAuth consent screen** in the API & Services section.
   - Under **Publishing Status**, select **Testing** for the development phase. This allows you to limit the app's access to test users.

3. **User Type:**
   - Choose **External** if you're creating an app that needs access for users outside of your organization. If it's only for internal use, you can choose **Internal**.

4. **App Information:**
   - Fill in required fields such as **App Name**, **User Support Email**, and **Developer Contact Information**.

5. **Scopes:**
   - Specify which scopes your app will request from users (e.g., email, profile, openid). You can add them later during credential creation, but it’s good to define them here as well.

6. **Add Test Users:**
   - Add the Gmail addresses of your test users under the **Test Users** section. These are the only users who will be able to log in while your app is in testing mode.

7. **Save and Continue:**
   - Complete the required fields and click **Save and Continue**.

8. **Summary:**
   - Review the information you've entered and click **Back to Dashboard**.

### Credentials Screen Setup

1. **Create OAuth 2.0 Credentials:**
   - Go to the **Credentials** section in the API & Services menu.
   - Click **Create Credentials** and choose **OAuth 2.0 Client ID**.

2. **Application Type:**
   - Choose the appropriate **Application Type** for your app:
      - **Web Application** for web-based apps.
      - Since OAuth2 is a web-based login flow, choose **Web Application**.

3. **Authorized Redirect URIs:**
   - If you're creating a **Web Application**, under **Authorized redirect URIs**, add the following:
      - `http://localhost:8080/login/oauth2/code/google` (for local testing)
      - Additional URIs can be added based on your production or testing environments.
      - Example: `http://localhost:8080/`

4. **Client ID and Client Secret:**
   - After creating the credentials, you'll receive a **Client ID** and **Client Secret**. Both are crucial for your OAuth2 setup.
   - **Copy the Client ID and Client Secret** to be used in your application's `application.properties` or `application.yml`.

### Application Properties Configuration

Once you've set up your OAuth consent screen and credentials, you need to add the **Client ID** and **Client Secret** to your application properties.

Here’s an example configuration for a Spring Boot application using `application.properties`:

```properties
spring.security.oauth2.client.registration.google.client-id=YOUR_GOOGLE_CLIENT_ID
spring.security.oauth2.client.registration.google.client-secret=YOUR_GOOGLE_CLIENT_SECRET
spring.security.oauth2.client.registration.google.redirect-uri=http://localhost:8080/login/oauth2/code/google
spring.security.oauth2.client.registration.google.scope=openid, profile, email
spring.security.oauth2.client.provider.google.authorization-uri=https://accounts.google.com/o/oauth2/auth
spring.security.oauth2.client.provider.google.token-uri=https://oauth2.googleapis.com/token
spring.security.oauth2.client.provider.google.user-info-uri=https://www.googleapis.com/oauth2/v3/userinfo
spring.security.oauth2.client.provider.google.jwk-set-uri=https://www.googleapis.com/oauth2/v3/certs
spring.security.oauth2.client.provider.google.issuer-uri=https://accounts.google.com
```

### Security Configuration

1. **Setting a Custom Success URL**
   - In your `SecurityConfig` file, you may want to set the default success URL for students to go directly to `/secured` upon successful login.
   - If students prefer to use a different landing page (such as `/dashboard` or `/home`), they can easily modify the `defaultSuccessUrl` in the `SecurityConfig`.
   - **Example**:
     ```
     .oauth2Login(oauth2 -> oauth2
             .defaultSuccessUrl("/secured", true)) // Redirects to /secured after login. Customize to /dashboard or other home page if needed.
     ```

2. **Using `OAuth2UserServiceConfig` for Custom Roles** (Optional)
   - If students want to assign custom roles or map additional user data, they can uncomment the `OAuth2UserServiceConfig` section in their project.
   - **Note**: Adding custom roles can be beneficial for more advanced role-based access control.
   - **Example**: Customizing roles within `OAuth2UserServiceConfig` allows for role management such as assigning `ROLE_ADMIN`, `ROLE_USER`, or other roles based on user attributes.
   - **Reminder**: If you implement this, don’t forget to add the custom `OAuth2UserServiceConfig` to your `SecurityConfig` file.

### Completing Setup

- **Package Structure Reminder**: Ensure your project package structure is aligned, and that controllers and configurations are correctly organized in their intended paths to avoid authorization or routing issues.
   - **Example Path**: `/src/main/java/com/coderscampus/social_login` for this project.

- **Testing OAuth2:** Once everything is set up, test the OAuth2 flow by running your application and attempting to log in via Google. You will need to manually enter /login in the URL bar (e.g., http://localhost:8080/login) to initiate the login flow. Verify that the redirect works correctly.
   - **Tip**: For students adding multiple pages, consider testing login with various `defaultSuccessUrl` settings to ensure the chosen page loads properly after authentication.

- **Publishing:** Once your application is ready for public use, you'll need to go back to the OAuth consent screen and publish it from testing to production. Google will review the app if necessary. You may also need to verify your domain during this process.

--- 
