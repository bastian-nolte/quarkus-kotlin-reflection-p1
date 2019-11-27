## Minimal example with Kotlin and Reflection

The following example works with JAR:
```bash
./mvnw clean package
java -jar target/kotlin-reflection-1.0.0-SNAPSHOT-runner.jar
curl localhost:8080/hello
```

2. the following example with native build does not work:
```bash
./mvnw clean package -Pnative
./target/kotlin-reflection-1.0.0-SNAPSHOT-runner
curl localhost:8080/hello
```
