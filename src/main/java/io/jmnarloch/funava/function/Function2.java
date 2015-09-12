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
package io.jmnarloch.funava.function;

/**
 *
 * @author Jakub Narloch
 */
@FunctionalInterface
public interface Function2<R, T1, T2> {

    R apply(T1 arg1, T2 arg2);

    default Function1<R, T2> arg(T1 arg) {

        return (T2 arg2) -> apply(arg, arg2);
    }

    default Function1<R, T1> rarg(T2 arg) {

        return (T1 arg1) -> apply(arg1, arg);
    }
}
