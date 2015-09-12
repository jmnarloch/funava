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

import java.util.Optional;

/**
 * An functional counterpart of Java cast operator allowing to specify the
 * alternative flow through {@link Optional#orElse(Object)} method.
 *
 * @author Jakub Narloch
 */
public interface SafeCast {

    /**
     * Casts the specified object into desired type.
     *
     * @param source the object to cast
     * @param <S> the source type
     * @return the {@link SafeCast.Castable}
     */
    static <S> Castable cast(S source) {
        return new Castable() {
            @Override
            @SuppressWarnings("unchecked")
            public <T> Optional<T> to(Class<T> target) {
                return target.isInstance(source) ? Optional.of((T)source) : Optional.empty();
            }
        };
    }

    /**
     * Simple interface for specifying the desired cast type.
     *
     * @author Jakub Narloch
     */
    @FunctionalInterface
    interface Castable {

        /**
         * Perform the cast to the desired type and returns the {@link Optional} result.
         * @param target the target type
         * @param <T> the class type
         * @return the cast result
         */
        <T> Optional<T> to(Class<T> target);
    }
}
