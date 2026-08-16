## Requirements

- Java 21
- Maven

## Dependencies

The project uses Jackson for JSON deserialization:

- `jackson-databind`
- `jackson-datatype-jsr310`

## Build

Run the following commands from the project root directory (the directory containing `pom.xml`):

Run:

```bash
mvn clean install -U
```

To inspect the dependency tree:

```bash
mvn dependency:tree
```

## Run

Run the `org.example.Main` class.

When the application starts, choose how you want to provide the JSON input:

1. **File input**
2. **Inline input**

## Test

To run tests run:

```bash
mvn test
```

## Notes

AI assistance was used to:

- Help resolve dependency errors.
- Break the assignment logic into separate classes.
- Make this file interactive.