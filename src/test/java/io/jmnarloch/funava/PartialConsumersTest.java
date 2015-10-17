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

import io.jmnarloch.funava.consumer.*;
import org.junit.After;
import org.junit.Test;

import static io.jmnarloch.funava.Utils.repeat;
import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link Partial} facade.
 *
 * @author Jakub Narloch
 */
public class PartialConsumersTest {

    private static final String ARG = "ARG";
    private static final String FUNC_RESULT = "func result";

    @After
    public void tearDown() throws Exception {

        Consumers.value = null;
    }

    @Test
    public void shouldInvokeConsumer() {

        // given
        Consumer c = Partial.consumer(Consumers::func);

        // when
        c.apply();

        // then
        assertEquals(FUNC_RESULT, Consumers.value);
    }

    @Test
    public void shouldInvokeConsumerWithOneArg() {

        // given
        Consumer1<String> f = Partial.consumer(Consumers::funcOneArg);

        // when
        f.apply(ARG);

        // then
        assertEquals(ARG, Consumers.value);
    }

    @Test
    public void shouldInvokeConsumerWithTwoArgs() {

        // given
        Consumer2<String, String> f = Partial.consumer(Consumers::funcTwoArgs);

        // when
        f.apply(ARG, ARG);

        // then
        assertEquals(repeat(ARG, 2), Consumers.value);
    }

    @Test
    public void shouldInvokeConsumerWithThreeArgs() {

        // given
        Consumer3<String, String, String> f = Partial.consumer(Consumers::funcThreeArgs);

        // when
        f.apply(ARG, ARG, ARG);

        // then
        assertEquals(repeat(ARG, 3), Consumers.value);
    }

    @Test
    public void shouldInvokeConsumersWithFourArgs() {

        // given
        Consumer4<String, String, String, String> f = Partial.consumer(Consumers::funcFourArgs);

        // when
        f.apply(ARG, ARG, ARG, ARG);

        // then
        assertEquals(repeat(ARG, 4), Consumers.value);
    }

    @Test
    public void shouldInvokeConsumersWithFiveArgs() {

        // given
        Consumer5<String, String, String, String, String> f = Partial.consumer(Consumers::funcFiveArgs);

        // when
        f.apply(ARG, ARG, ARG, ARG, ARG);

        // then
        assertEquals(repeat(ARG, 5), Consumers.value);
    }

    @Test
    public void shouldPartiallyApplyOneArgumentConsumer() {

        // given
        Consumer1<String> f = Partial.consumer(Consumers::funcOneArg);

        // when
        f.arg("1").apply();

        // then
        assertEquals("1", Consumers.value);
    }

    @Test
    public void shouldPartiallyApplyOneArgumentConsumerRight() {

        // given
        Consumer1<String> f = Partial.consumer(Consumers::funcOneArg);

        // when
        f.rarg("1").apply();

        // then
        assertEquals("1", Consumers.value);
    }

    @Test
    public void shouldPartiallyApplyTwoArgumentConsumer() {

        // given
        Consumer2<String, String> f = Partial.consumer(Consumers::funcTwoArgs);

        // when
        f.arg("1").apply("2");

        // then
        assertEquals("12", Consumers.value);
    }

    @Test
    public void shouldPartiallyApplyTwoArgumentConsumerRight() {

        // given
        Consumer2<String, String> f = Partial.consumer(Consumers::funcTwoArgs);

        // when
        f.rarg("1").apply("2");

        // then
        assertEquals("21", Consumers.value);
    }

    @Test
    public void shouldPartiallyApplyThreeArgumentConsumer() {

        // given
        Consumer3<String, String, String> f = Partial.consumer(Consumers::funcThreeArgs);

        // when
        f.arg("1").apply("2", "3");

        // then
        assertEquals("123", Consumers.value);
    }

    @Test
    public void shouldPartiallyApplyThreeArgumentConsumerRight() {

        // given
        Consumer3<String, String, String> f = Partial.consumer(Consumers::funcThreeArgs);

        // when
        f.rarg("1").apply("2", "3");

        // then
        assertEquals("231", Consumers.value);
    }

    @Test
    public void shouldPartiallyApplyFourArgumentConsumer() {

        // given
        Consumer4<String, String, String, String> f = Partial.consumer(Consumers::funcFourArgs);

        // when
        f.arg("1").apply("2", "3", "4");

        // then
        assertEquals("1234", Consumers.value);
    }

    @Test
    public void shouldPartiallyApplyFourArgumentConsumerRight() {

        // given
        Consumer4<String, String, String, String> f = Partial.consumer(Consumers::funcFourArgs);

        // when
        f.rarg("1").apply("2", "3", "4");

        // then
        assertEquals("2341", Consumers.value);
    }

    @Test
    public void shouldPartiallyApplyFiveArgumentConsumer() {

        // given
        Consumer5<String, String, String, String, String> f = Partial.consumer(Consumers::funcFiveArgs);

        // when
        f.arg("1").apply("2", "3", "4", "5");

        // then
        assertEquals("12345", Consumers.value);
    }

    @Test
    public void shouldPartiallyApplyFiveArgumentConsumerRight() {

        // given
        Consumer5<String, String, String, String, String> f = Partial.consumer(Consumers::funcFiveArgs);

        // when
        f.rarg("1").apply("2", "3", "4", "5");

        // then
        assertEquals("23451", Consumers.value);
    }

    @Test
    public void shouldApplyFiveArgumentConsumer() {

        // given
        Consumer5<String, String, String, String, String> f = Partial.consumer(Consumers::funcFiveArgs);

        // when
        f.arg("1")
                .arg("2")
                .arg("3")
                .arg("4")
                .arg("5")
                .apply();

        // then
        assertEquals("12345", Consumers.value);
    }

    @Test
    public void shouldApplyFiveArgumentConsumerRight() {

        // given
        Consumer5<String, String, String, String, String> f = Partial.consumer(Consumers::funcFiveArgs);

        // when
        f.rarg("1")
                .rarg("2")
                .rarg("3")
                .rarg("4")
                .rarg("5")
                .apply();

        // then
        assertEquals("54321", Consumers.value);
    }

    @Test
    public void shouldApplyVarargsFunction() {

        // given
        VArgConsumer<String> f = Partial.vargConsumer(Consumers::funcVarArgs);

        // when
        f.arg("1")
                .arg("2")
                .apply();

        // then
        assertEquals("12", Consumers.value);
    }
}
