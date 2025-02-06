# CropConnect-Backend

***
## Application.properties
### Application name
spring.application.name=CropConnect-backend

### MongoDB Configuration
spring.data.mongodb.uri=${spring.data.mongodb.uri}  # Connection URI (replace with actual value or set as an environment variable)
spring.data.mongodb.database=CropConnectDB          # Name of the database used in MongoDB

### Mail Server Configuration
spring.mail.host=smtp.example.com                   # SMTP server host (replace with actual SMTP provider)
spring.mail.port=000                                # SMTP server port (e.g., 587 for TLS, 465 for SSL)
spring.mail.username=${spring.mail.username}        # Email username (set as an environment variable)
spring.mail.password=${spring.mail.password}        # Email password (set as an environment variable)

### Additional Mail Properties
spring.mail.properties.mail.smtp.auth=true          # Enables authentication for outgoing emails
spring.mail.properties.mail.smtp.starttls.enable=true  # Enables TLS encryption for secure email transmission

### Admin Email Configuration
admin.email=${spring.mail.username}                 # Admin email address (uses the same email as configured above)

