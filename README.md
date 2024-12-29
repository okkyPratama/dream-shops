# Dream Shops E-commerce Backend API

Dream Shops is a robust e-commerce backend system built with Spring Boot that provides a comprehensive set of APIs for managing an online shopping platform.

## Features

- **User Management**: Registration, authentication, and profile management
- **Product Management**: CRUD operations for products with image support
- **Category Management**: Organize products into categories
- **Shopping Cart**: Add, remove, and update items in cart
- **Order Processing**: Place and manage orders
- **Image Handling**: Upload and manage product images
- **Role-based Access Control**: Admin and User role separation
- **JWT Authentication**: Secure API endpoints

## Technologies Used

- Java 17
- Spring Boot
- Spring Security with JWT
- Spring Data JPA
- PostgreSQL/MySQL
- Lombok
- ModelMapper
- Maven

## Project Structure

```
com.dailycodework.dream_shops/
├── controller/        # REST controllers
├── model/            # Entity classes
├── repository/       # JPA repositories
├── service/          # Business logic
├── dto/              # Data Transfer Objects
├── exceptions/       # Custom exceptions
├── security/         # Security configurations
└── response/         # API response models
```

## Database Schema
![dream-shops-erd.png](..%2F..%2F..%2FProjects%2Fdream-shops%2Fsrc%2Fmain%2Fresources%2Fstatic%2Fdream-shops-erd.png)

## API Endpoints

### Authentication
- `POST /api/v1/auth/login` - User login

### Users
- `POST /api/v1/users/add` - Create new user
- `GET /api/v1/users/{userId}/user` - Get user by ID
- `PUT /api/v1/users/{userId}/update` - Update user
- `DELETE /api/v1/users/{userId}/delete` - Delete user

### Products
- `GET /api/v1/products/all` - Get all products
- `GET /api/v1/products/product/{productId}/product` - Get product by ID
- `POST /api/v1/products/add` - Add new product (Admin only)
- `PUT /api/v1/products/product/{productId}/update` - Update product (Admin only)
- `DELETE /api/v1/products/product/{productId}/delete` - Delete product (Admin only)
- `GET /api/v1/products/products/by/brand-and-name` - Search products by brand and name
- `GET /api/v1/products/products/by/category-and-brand` - Search products by category and brand
- `GET /api/v1/products/product/by-brand` - Get products by brand
- `GET /api/v1/products/product/{category}/all/products` - Get products by category

### Categories
- `GET /api/v1/categories/all` - Get all categories
- `POST /api/v1/categories/add` - Add new category
- `GET /api/v1/categories/category/{id}/category` - Get category by ID
- `PUT /api/v1/categories/category/{id}/update` - Update category
- `DELETE /api/v1/categories/category/{id}/delete` - Delete category

### Cart
- `GET /api/v1/carts/{cartId}/my-cart` - Get cart details
- `POST /api/v1/cartItems/item/add` - Add item to cart
- `DELETE /api/v1/cartItems/cart/{cartId}/item/{itemId}/remove` - Remove item from cart
- `PUT /api/v1/cartItems/cart/{cartId}/item/{itemId}/update` - Update cart item quantity
- `DELETE /api/v1/carts/{cartId}/clear` - Clear cart
- `GET /api/v1/carts/{cartId}/cart/total-price` - Get cart total

### Orders
- `POST /api/v1/orders/order` - Place new order
- `GET /api/v1/orders/{orderId}/order` - Get order by ID
- `GET /api/v1/orders/{userId}/order` - Get user's orders

### Images
- `POST /api/v1/images/upload` - Upload product images
- `GET /api/v1/images/image/download/{imageId}` - Download image
- `PUT /api/v1/images/image/{imageId}/update` - Update image
- `DELETE /api/v1/images/image/{imageId}/delete` - Delete image

## API Formats

### Request Models

#### Authentication
```json
// LoginRequest
{
    "email": "string",     // Required
    "password": "string"   // Required
}
```

#### User Management
```json
// CreateUserRequest
{
    "firstName": "string",
    "lastName": "string",
    "email": "string",
    "password": "string"
}

// UpdateUserRequest
{
    "firstName": "string",
    "lastName": "string"
}
```

#### Product Management
```json
// AddProductRequest
{
    "name": "string",
    "brand": "string",
    "price": "number",
    "inventory": "integer",
    "description": "string",
    "category": {
        "name": "string"
    }
}

// ProductUpdateRequest
{
    "name": "string",
    "brand": "string",
    "price": "number",
    "inventory": "integer",
    "description": "string",
    "category": {
        "name": "string"
    }
}
```

### Response Models

#### Standard API Response
All API endpoints return responses in the following format:
```json
{
    "message": "Success/Error message",
    "data": {
        // Response data object (can be null for error responses)
    }
}
```

#### Authentication Response
```json
{
    "message": "Login Successful",
    "data": {
        "id": "number",
        "token": "string"
    }
}
```

## Getting Started

1. Clone the repository
```bash
git clone https://github.com/yourusername/dream-shops.git
```

2. Configure database properties in `application.properties`
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/dream_shops
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build the project
```bash
mvn clean install
```

4. Run the application
```bash
mvn spring-boot:run
```
## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.
