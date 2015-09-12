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
package io.jmnarloch.funava.consumer;

/**
 * An abstraction of triple argument routine that does not return any result.
 *
 * @param <T1> the function first argument type
 * @param <T2> the function second argument type
 * @param <T3> the function third argument type
 *
 * @author Jakub Narloch
 */
@FunctionalInterface
public interface Consumer3<T1, T2, T3> {

    /**
     * Executes the function.
     *
     * @param arg1 the function first argument
     * @param arg2 the function second argument
     * @param arg3 the function third argument
     */
    void apply(T1 arg1, T2 arg2, T3 arg3);

    /**
     * Applies single argument and returns the partially applied function.
     *
     * @param arg the argument to apply
     * @return the partially applied function
     */
    default Consumer2<T2, T3> arg(T1 arg) {

        return (T2 arg2, T3 arg3) -> apply(arg, arg2, arg3);
    }

    /**
     * Applies the single argument from the end and returns the partially applied function.
     *
     * @param arg the argument to apply
     * @return the partially applied function
     */
    default Consumer2<T1, T2> rarg(T3 arg) {

        return (T1 arg1, T2 arg2) -> apply(arg1, arg2, arg);
    }
}