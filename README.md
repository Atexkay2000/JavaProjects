# Shopping Cart System

A simple Java-based shopping cart system that allows users to register, manage products in a cart, and validate user information.

## Table of Contents
- [Features](#features)
- [Classes](#classes)
- [Installation](#installation)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Features
- Add and remove products from the shopping cart.
- List all products in the cart.
- Calculate the total price of products in the cart.
- User registration with validation for email, username, and password.

## Classes
### Cart
- Manages a list of `Product` objects.
- Methods:
  - `add(Product p)`: Adds a product to the cart.
  - `remove(Product p)`: Removes a product from the cart.
  - `listAllProducts()`: Displays all products in the cart.
  - `clearCart()`: Clears all products from the cart.
  - `calculateTotalPrice()`: Calculates the total price of all products.

### Product
- Represents a product with a name, price, and quantity.
- Attributes:
  - `name`: Product name.
  - `price`: Product price.
  - `quantity`: Product quantity.

### User
- Represents a user with email, username, and password.
- Methods for validation:
  - `isValid(String username)`: Validates username.
  - `isValidEmail(String email)`: Validates email format.
  - `isValidPassword(String password)`: Validates password strength.

### UserManagement
- Manages user registration and validation.
- Methods:
  - `registerUser(String email, String username, String password)`: Registers a new user.
  - `listUsers()`: Lists all registered users.

## Installation
1. Clone the repository:
   ```bash
   git clone <https://github.com/Atexkay2000/JavaProjects>
