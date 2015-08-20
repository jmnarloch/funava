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

    static <R> Func<R> function(Func<R> func) {
        return func;
    }

    static <R, T> FuncOne<R, T> function(FuncOne<R, T> fun) {
        return fun;
    }

    static <R, T1, T2> FuncTwo<R, T1, T2> function(FuncTwo<R, T1, T2> fun) {
        return fun;
    }

    static <R, T1, T2, T3> FuncThree<R, T1, T2, T3> function(FuncThree<R, T1, T2, T3> fun) {
        return fun;
    }

    static <R, T1, T2, T3, T4> FuncFour<R, T1, T2, T3, T4> function(FuncFour<R, T1, T2, T3, T4> fun) {
        return fun;
    }

    static <R, T1, T2, T3, T4, T5> FuncFive<R, T1, T2, T3, T4, T5> function(FuncFive<R, T1, T2, T3, T4, T5> fun) {
        return fun;
    }

    static Sup supplier(Sup sup) {
        return sup;
    }

    static <T> SupOne<T> supplier(SupOne<T> sup) {
        return sup;
    }

    static <T1, T2> SupTwo<T1, T2> supplier(SupTwo<T1, T2> sup) {
        return sup;
    }

    static <T1, T2, T3> SupThree<T1, T2, T3> supplier(SupThree<T1, T2, T3> sup) {
        return sup;
    }

    static <T1, T2, T3, T4> SupFour<T1, T2, T3, T4> supplier(SupFour<T1, T2, T3, T4> sup) {
        return sup;
    }

    static <T1, T2, T3, T4, T5> SupFive<T1, T2, T3, T4, T5> supplier(SupFive<T1, T2, T3, T4, T5> sup) {
        return sup;
    }
}
