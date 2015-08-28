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
import io.jmnarloch.funava.supplier.*;

/**
 * @author Jakub Narloch
 */
public interface Partial {

    static <R> Function<R> function(Function<R> function) {
        return function;
    }

    static <R, T> UnFunction<R, T> function(UnFunction<R, T> fun) {
        return fun;
    }

    static <R, T1, T2> BiFunction<R, T1, T2> function(BiFunction<R, T1, T2> fun) {
        return fun;
    }

    static <R, T1, T2, T3> TriFunction<R, T1, T2, T3> function(TriFunction<R, T1, T2, T3> fun) {
        return fun;
    }

    static <R, T1, T2, T3, T4> QuaterFunction<R, T1, T2, T3, T4> function(QuaterFunction<R, T1, T2, T3, T4> fun) {
        return fun;
    }

    static <R, T1, T2, T3, T4, T5> QuiFunction<R, T1, T2, T3, T4, T5> function(QuiFunction<R, T1, T2, T3, T4, T5> fun) {
        return fun;
    }

    static Supplier supplier(Supplier supplier) {
        return supplier;
    }

    static <T> UnSupplier<T> supplier(UnSupplier<T> sup) {
        return sup;
    }

    static <T1, T2> BiSupplier<T1, T2> supplier(BiSupplier<T1, T2> sup) {
        return sup;
    }

    static <T1, T2, T3> TriSupplier<T1, T2, T3> supplier(TriSupplier<T1, T2, T3> sup) {
        return sup;
    }

    static <T1, T2, T3, T4> QuaterSupplier<T1, T2, T3, T4> supplier(QuaterSupplier<T1, T2, T3, T4> sup) {
        return sup;
    }

    static <T1, T2, T3, T4, T5> QuiSupplier<T1, T2, T3, T4, T5> supplier(QuiSupplier<T1, T2, T3, T4, T5> sup) {
        return sup;
    }
}
