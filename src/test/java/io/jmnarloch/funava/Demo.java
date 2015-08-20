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
    public void usage() {

        String url = Partial.function(this::url)
                .arg("https")
                .arg("github.com")
                .arg(443)
                .arg("jmnarloch")
                .apply("funava");

        // url = https://github.com:443/jmnarloch/funava
        System.out.println(url);
    }

    public String url(String scheme, String host, int port, String username, String repo) {
        return String.format("%s://%s:%d/%s/%s", scheme, host, port, username, repo);
    }
}