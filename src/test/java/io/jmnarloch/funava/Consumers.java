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
 * Defines set of method with different argument count for testing purpose.
 *
 * @author Jakub Narloch
 */
public class Consumers {

    static String value;

    static void func() {
        value = "func result";
    }

    static void funcOneArg(String arg) {
        value = arg;
    }

    static void funcTwoArgs(String arg1, String arg2) {
        value = arg1 + arg2;
    }

    static void funcThreeArgs(String arg1, String arg2, String arg3) {
        value = arg1 + arg2 + arg3;
    }

    static void funcFourArgs(String arg1, String arg2, String arg3, String arg4) {
        value = arg1 + arg2 + arg3 + arg4;
    }

    static void funcFiveArgs(String arg1, String arg2, String arg3, String arg4, String args5) {
        value = arg1 + arg2 + arg3 + arg4 + args5;
    }

    static void funcVarArgs(String... args) {
        final StringBuilder builder = new StringBuilder();
        for (String arg : args) {
            builder.append(arg);
        }
        value = builder.toString();
    }
}
