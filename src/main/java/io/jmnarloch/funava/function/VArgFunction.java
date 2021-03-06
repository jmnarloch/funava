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
 * Variable argument function.
 *
 * @author Jakub Narloch
 */
@FunctionalInterface
public interface VArgFunction<R, T> {

    /**
     * Executes the function and return it's result.
     *
     * @param args the arguments
     * @return the function execution result
     */
    R apply(T... args);

    /**
     * Applies single argument and returns the partially applied variable argument function.
     *
     * @param arg the argument to apply
     * @return the partially applied variable argument function
     */
    @SuppressWarnings("unchecked")
    default VArgFunction<R, T> arg(T arg) {

        return (T... args) -> {
            final T[] arguments = (T[]) new Object[args.length + 1];
            arguments[0] = arg;
            System.arraycopy(args, 0, arguments, 1, args.length);
            return apply(arguments);
        };
    }
}
