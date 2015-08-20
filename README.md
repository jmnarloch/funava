# Funava

> Small Java library for partial function application.

[![Build Status](https://travis-ci.org/jmnarloch/funava.svg?branch=master)](https://travis-ci.org/jmnarloch/funava)

## Examples

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