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
 * @author Jakub Narloch
 */
public interface SafeCast {

    static <S> Castable cast(S source) {
        return new Castable() {
            @Override
            @SuppressWarnings("unchecked")
            public <T> Optional<T> to(Class<T> target) {
                return target.isInstance(source) ? Optional.of((T)source) : Optional.empty();
            }
        };
    }

    interface Castable {

        <T> Optional<T> to(Class<T> target);
    }
}
