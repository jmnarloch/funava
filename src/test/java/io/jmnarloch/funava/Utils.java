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

/**
 * Defines convenient test utility methods.
 *
 * @author Jakub Narloch
 */
interface Utils {

    /**
     * Repeats the text given number of times.
     *
     * @param val   the value
     * @param times the number of times val should be repeated
     * @return the result
     */
    static String repeat(String val, int times) {
        final StringBuilder builder = new StringBuilder();
        for (int ind = 0; ind < times; ind++) {
            builder.append(val);
        }
        return builder.toString();
    }
}
