/**
 * Copyright (c) 2015 the original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.jmnarloch.funava;

import org.junit.Test;

/**
 *
 * @author Jakub Narloch
 */
public class Demo {

    @Test
    public void safeCast() {

        Object val = "test";

        String result =  SafeCast.cast(val).to(String.class).orElse("default");

        // result == test
    }

    @Test
    public void ternaryOperator() {

        int i = 15;

        int result = Condition.when(i % 2 == 0).then(i / 2).orElse(i * 3);

        // i == 45
    }

    @Test
    public void partialApplication() {

        String url = Partial.function(Demo::url)
                .arg("https")
                .arg("github.com")
                .arg(443)
                .arg("jmnarloch")
                .apply("funava");

        // url = https://github.com:443/jmnarloch/funava
        System.out.println(url);

        int sum = Partial.function(Demo::sum)
                .arg(1)
                .apply(2);

        // 1 + 2 == 3

        int diff = Partial.function(Demo::substract)
                .rarg(2)
                .apply(1);

        // 1 - 2 == -1

        int product = Partial.function(Demo::product)
                .arg(4)
                .apply(5);

        // 4 * 5 == 20
    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int substract(int a, int b) {
        return a - b;
    }

    public static int product(int a, int b) {
        return a * b;
    }

    public static String url(String scheme, String host, int port, String username, String repo) {
        return String.format("%s://%s:%d/%s/%s", scheme, host, port, username, repo);
    }
}