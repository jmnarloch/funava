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
public interface Condition {

    static Conditional when(boolean condition) {
        return new Conditional() {
            @Override
            public <T> Optional<T> then(T value) {
                return condition ? Optional.of(value) : Optional.empty();
            }
        };
    }

    interface Conditional {

        <T> Optional<T> then(T value);
    }
}
