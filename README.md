ambivalence
===========

[![Build Status](https://travis-ci.org/poetix/ambivalence.svg?branch=master)](https://travis-ci.org/poetix/ambivalence)

```xml
<dependency>
    <groupId>com.codepoetics</groupId>
    <artifactId>ambivalence</artifactId>
    <version>0.2</version>
</dependency>
```

An `Either` type for Java 8, in case you needed one.

Features:

* `join` and `forEither` to access values safely.
* left and right projections, with `map` and `flatMap`.
* `equals`, `hashCode` and `toString` implemented.
* `Tryable` wraps an exception-throwing lambda so that it returns `Either<T, Exception>`.
* `Eithers` provides `Stream` collectors which split a stream of `Either` values and optionally collect the left values.

```java
Either<String, Integer> stringOrInt1 = Either.ofLeft("a string");
Either<String, Integer> stringOrInt2 = Either.ofRight(23);

System.out.println(stringOrInt1.join(String::toUpperCase, Object::toString));
```
