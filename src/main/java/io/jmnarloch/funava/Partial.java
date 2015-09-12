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

import io.jmnarloch.funava.function.*;
import io.jmnarloch.funava.consumer.*;

/**
 * An convient class for acquiring function/consumer wrapper class.
 *
 * @author Jakub Narloch
 */
public interface Partial {

    /**
     * Applies a parametreless function.
     *
     * @param function the function
     * @param <R> the function return type
     * @return the function wrapper
     */
    static <R> Function<R> function(Function<R> function) {
        return function;
    }

    /**
     * Applies a single argument function.
     *
     * @param function the function
     * @param <R> the function return type
     * @param <T> the function argument type
     * @return the function wrapper
     */
    static <R, T> Function1<R, T> function(Function1<R, T> fun) {
        return fun;
    }

    /**
     * Applies a double argument function.
     *
     * @param function the function
     * @param <R> the function return type
     * @param <T1> the function first argument type
     * @param <T2> the function second argument type
     * @return the function wrapper
     */
    static <R, T1, T2> Function2<R, T1, T2> function(Function2<R, T1, T2> fun) {
        return fun;
    }

    /**
     * Applies a triple argument function.
     *
     * @param function the function
     * @param <R> the function return type
     * @param <T1> the function first argument type
     * @param <T2> the function first argument type
     * @param <T3> the function third argument type
     * @return the function wrapper
     */
    static <R, T1, T2, T3> Function3<R, T1, T2, T3> function(Function3<R, T1, T2, T3> fun) {
        return fun;
    }

    /**
     * Applies a quadruple argument function.
     *
     * @param function the function
     * @param <R> the function return type
     * @param <T1> the function first argument type
     * @param <T2> the function first argument type
     * @param <T3> the function third argument type
     * @param <T4> the function fourth argument type
     * @return the function wrapper
     */
    static <R, T1, T2, T3, T4> Function4<R, T1, T2, T3, T4> function(Function4<R, T1, T2, T3, T4> fun) {
        return fun;
    }

    /**
     * Applies a quintuple argument function.
     *
     * @param function the function
     * @param <R> the function return type
     * @param <T1> the function first argument type
     * @param <T2> the function first argument type
     * @param <T3> the function third argument type
     * @param <T4> the function fourth argument type
     * @param <T5> the function fifth argument type
     * @return the function wrapper
     */
    static <R, T1, T2, T3, T4, T5> Function5<R, T1, T2, T3, T4, T5> function(Function5<R, T1, T2, T3, T4, T5> fun) {
        return fun;
    }

    /**
     * Applies a parametreless consumer.
     *
     * @param consumer the function
     * @return the function wrapper
     */
    static Consumer consumer(Consumer consumer) {
        return consumer;
    }

    /**
     * Applies a single argument function.
     *
     * @param consumer the function
     * @param <T> the function argument type
     * @return the function wrapper
     */
    static <T> Consumer1<T> consumer(Consumer1<T> consumer) {
        return consumer;
    }

    /**
     * Applies a double argument function.
     *
     * @param consumer the function
     * @param <T1> the function first argument type
     * @param <T2> the function second argument type
     * @return the function wrapper
     */
    static <T1, T2> Consumer2<T1, T2> consumer(Consumer2<T1, T2> consumer) {
        return consumer;
    }

    /**
     * Applies a triple argument function.
     *
     * @param consumer the function
     * @param <T1> the function first argument type
     * @param <T2> the function first argument type
     * @param <T3> the function third argument type
     * @return the function wrapper
     */
    static <T1, T2, T3> Consumer3<T1, T2, T3> consumer(Consumer3<T1, T2, T3> consumer) {
        return consumer;
    }

    /**
     * Applies a quadruple argument function.
     *
     * @param consumer the function
     * @param <T1> the function first argument type
     * @param <T2> the function first argument type
     * @param <T3> the function third argument type
     * @param <T4> the function fourth argument type
     * @return the function wrapper
     */
    static <T1, T2, T3, T4> Consumer4<T1, T2, T3, T4> consumer(Consumer4<T1, T2, T3, T4> consumer) {
        return consumer;
    }

    /**
     * Applies a quintuple argument function.
     *
     * @param consumer the function
     * @param <T1> the function first argument type
     * @param <T2> the function first argument type
     * @param <T3> the function third argument type
     * @param <T4> the function fourth argument type
     * @param <T5> the function fifth argument type
     * @return the function wrapper
     */
    static <T1, T2, T3, T4, T5> Consumer5<T1, T2, T3, T4, T5> consumer(Consumer5<T1, T2, T3, T4, T5> consumer) {
        return consumer;
    }
}
