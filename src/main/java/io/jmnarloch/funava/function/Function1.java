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
 * An abstraction of single argument function.
 *
 * @param <R> the function return type
 * @param <T> the function argument type
 *
 * @author Jakub Narloch
 */
@FunctionalInterface
public interface Function1<R, T> {

    /**
     * Executes the function and return it's result.
     *
     * @param arg the argument
     * @return the function execution result
     */
    R apply(T arg);

    /**
     * Applies single argument and returns the partially applied function.
     *
     * @param arg the argument to apply
     * @return the partially applied function
     */
    default Function<R> arg(T arg) {

        return () -> apply(arg);
    }

    /**
     * Applies the single argument from the end and returns the partially applied function.
     *
     * @param arg the argument to apply
     * @return the partially applied function
     */
    default Function<R> rarg(T arg) {

        return arg(arg);
    }
}
