# DI Container Readme

## Introduction

This document provides an overview of the DI (Dependency Injection) Container and the annotations used to configure and manage components in your application.

## Annotations

### `@Component`

- **Usage:** Client class should use this annotation.
- **Description:** The `@Component` annotation marks a class as a component, indicating that it should be managed by the DI Container. Components are typically classes that provide some functionality within your application and may have dependencies injected into them.

### `@Infused`

- **Usage:** Service field variables should use this annotation.
- **Description:** The `@Infused` annotation is used to annotate fields, methods, constructors, or parameters that should be injected with dependencies by the DI Container. It signifies that a particular element requires dependency injection.

### `@Qualifier`

- **Usage:** Service field variables or other elements can use this annotation.
- **Description:** The `@Qualifier` annotation can be applied to fields, methods, constructors, parameters, types, or annotations. It is used to avoid conflicts when there are multiple implementations of the same interface or multiple components that can fulfill a particular dependency. By specifying a value in `@Qualifier`, you can indicate which specific implementation should be injected.

## Getting Started

To use the DI Container in your application, follow these steps:

1. Annotate your classes with `@Component` to indicate which classes should be managed by the DI Container.

2. Use the `@Infused` annotation to mark fields, methods, constructors, or parameters that require dependency injection.

3. When you create an instance of the DI Container, it will automatically scan for classes annotated with `@Component`, create instances of those classes, and inject any required dependencies marked with `@Infused`.

4. If you have multiple implementations of the same interface or need to specify which implementation to use, you can use the `@Qualifier` annotation along with `@Infused` to provide a clear reference to the desired implementation.

## Example Usage

```java
@Component
public class MyService {
    @Infused
    private AnotherService anotherService;

    // ... Other methods and fields ...
}

@Component
public class AnotherService {
    // ... Implementation ...
}

@Component
public class MainApplication {
    public static void main(String[] args) {
        // Create an instance of the DI Container
        DIContainer container = new DIContainer();

        // Retrieve instances of components from the container
        MyService myService = container.getComponent(MyService.class);
        
        // Use the components with injected dependencies
        myService.doSomething();
    }
}
