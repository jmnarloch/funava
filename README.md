# Funava

> Small Java library for partial function application.

[![Build Status](https://travis-ci.org/jmnarloch/funava.svg?branch=master)](https://travis-ci.org/jmnarloch/funava)

## Example

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
```

## License

Apache 2.0