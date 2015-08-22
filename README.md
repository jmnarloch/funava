# Funava

> Small Java library for partial function application.

[![Build Status](https://travis-ci.org/jmnarloch/funava.svg?branch=master)](https://travis-ci.org/jmnarloch/funava)

Funava is implemented without a single Java class.

## Setup

Currently only as snapshot available from: https://oss.sonatype.org/content/repositories/snapshots/

```xml
<dependency>
    <groupId>io.jmnarloch</groupId>
    <artifactId>funava</artifactId>
    <version>1.0.0-SNAPSHOT</version>
</dependency>
```

## Examples

Safe cast

```java

Object val = "test";

String result =  SafeCast.cast(val).to(String.class).orElse("default");

// result == test

```

Ternary operator

```

int i = 15;

int result = Condition.when(i % 2 == 0).then(i / 2).orElse(i * 3);

// i == 45

```

Partial function application

```java

public String url(String scheme, String host, int port, String username, String repo) {
    return String.format("%s://%s:%d/%s/%s", scheme, host, port, username, repo);
}

String url = Partial.function(this::url)
                .arg("https")
                .arg("github.com")
                .arg(443)
                .arg("jmnarloch")
                .apply("funava");

// url == https://github.com:443/jmnarloch/funava

public int sum(int a, int b) {
        return a + b;
}

int sum = Partial.function(this::sum)
                .arg(1)
                .apply(2);

// 1 + 2 == 3

public int substract(int a, int b) {
        return a - b;
}

int diff = Partial.function(this::substract)
                .rarg(2)
                .apply(1);

// 1 - 2 == -1

public int product(int a, int b) {
        return a * b;
}
    
int product = Partial.function(this::product)
                .arg(4)
                .apply(5);

// 4 * 5 == 20
```

## License

Apache 2.0