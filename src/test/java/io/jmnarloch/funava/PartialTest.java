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
import io.jmnarloch.funava.function.*;
import org.junit.After;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link Partial} facade.
 *
 * @author Jakub Narloch
 */
public class PartialTest {

    private static final String ARG = "ARG";
    private static final String FUNC_RESULT = "func result";

    @After
    public void tearDown() throws Exception {

        Consumers.value = null;
    }

    @Test
    public void shouldInvokeFunc() {

        // given
        Function<String> f = Partial.function(Functions::func);

        // when
        String result = f.apply();

        // then
        assertEquals(FUNC_RESULT, result);
    }

    @Test
    public void shouldInvokeFuncWithOneArg() {

        // given
        Function1<String, String> f = Partial.function(Functions::funcOneArg);

        // when
        String result = f.apply(ARG);

        // then
        assertEquals(ARG, result);
    }

    @Test
    public void shouldInvokeFuncWithTwoArgs() {

        // given
        Function2<String, String, String> f = Partial.function(Functions::funcTwoArgs);

        // when
        String result = f.apply(ARG, ARG);

        // then
        assertEquals(repeat(ARG, 2), result);
    }

    @Test
    public void shouldInvokeFuncWithThreeArgs() {

        // given
        Function3<String, String, String, String> f = Partial.function(Functions::funcThreeArgs);

        // when
        String result = f.apply(ARG, ARG, ARG);

        // then
        assertEquals(repeat(ARG, 3), result);
    }

    @Test
    public void shouldInvokeFuncWithFourArgs() {

        // given
        Function4<String, String, String, String, String> f = Partial.function(Functions::funcFourArgs);

        // when
        String result = f.apply(ARG, ARG, ARG, ARG);

        // then
        assertEquals(repeat(ARG, 4), result);
    }

    @Test
    public void shouldInvokeFuncWithFiveArgs() {

        // given
        Function5<String, String, String, String, String, String> f = Partial.function(Functions::funcFiveArgs);

        // when
        String result = f.apply(ARG, ARG, ARG, ARG, ARG);

        // then
        assertEquals(repeat(ARG, 5), result);
    }

    @Test
    public void shouldPartiallyApplyOneArgumentFunc() {

        // given
        Function1<String, String> f = Partial.function(Functions::funcOneArg);

        // when
        Function<String> partial = f.arg("1");

        // then
        assertEquals("1", partial.apply());
    }

    @Test
    public void shouldPartiallyApplyOneArgumentFuncRight() {

        // given
        Function1<String, String> f = Partial.function(Functions::funcOneArg);

        // when
        Function<String> partial = f.rarg("1");

        // then
        assertEquals("1", partial.apply());
    }

    @Test
    public void shouldPartiallyApplyTwoArgumentFunc() {

        // given
        Function2<String, String, String> f = Partial.function(Functions::funcTwoArgs);

        // when
        Function1<String, String> partial = f.arg("1");

        // then
        assertEquals("12", partial.apply("2"));
    }

    @Test
    public void shouldPartiallyApplyTwoArgumentFuncRight() {

        // given
        Function2<String, String, String> f = Partial.function(Functions::funcTwoArgs);

        // when
        Function1<String, String> partial = f.rarg("1");

        // then
        assertEquals("21", partial.apply("2"));
    }

    @Test
    public void shouldPartiallyApplyThreeArgumentFunc() {

        // given
        Function3<String, String, String, String> f = Partial.function(Functions::funcThreeArgs);

        // when
        Function2<String, String, String> partial = f.arg("1");

        // then
        assertEquals("123", partial.apply("2", "3"));
    }

    @Test
    public void shouldPartiallyApplyThreeArgumentFuncRight() {

        // given
        Function3<String, String, String, String> f = Partial.function(Functions::funcThreeArgs);

        // when
        Function2<String, String, String> partial = f.rarg("1");

        // then
        assertEquals("231", partial.apply("2", "3"));
    }

    @Test
    public void shouldPartiallyApplyFourArgumentFunc() {

        // given
        Function4<String, String, String, String, String> f = Partial.function(Functions::funcFourArgs);

        // when
        Function3<String, String, String, String> partial = f.arg("1");

        // then
        assertEquals("1234", partial.apply("2", "3", "4"));
    }

    @Test
    public void shouldPartiallyApplyFourArgumentFuncRight() {

        // given
        Function4<String, String, String, String, String> f = Partial.function(Functions::funcFourArgs);

        // when
        Function3<String, String, String, String> partial = f.rarg("1");

        // then
        assertEquals("2341", partial.apply("2", "3", "4"));
    }

    @Test
    public void shouldPartiallyApplyFiveArgumentFunc() {

        // given
        Function5<String, String, String, String, String, String> f = Partial.function(Functions::funcFiveArgs);

        // when
        Function4<String, String, String, String, String> partial = f.arg("1");

        // then
        assertEquals("12345", partial.apply("2", "3", "4", "5"));
    }

    @Test
    public void shouldPartiallyApplyFiveArgumentFuncRight() {

        // given
        Function5<String, String, String, String, String, String> f = Partial.function(Functions::funcFiveArgs);

        // when
        Function4<String, String, String, String, String> partial = f.rarg("1");

        // then
        assertEquals("23451", partial.apply("2", "3", "4", "5"));
    }

    @Test
    public void shouldApplyFiveArgumentFunc() {

        // given
        Function5<String, String, String, String, String, String> f = Partial.function(Functions::funcFiveArgs);

        // when
        Function partial = f.arg("1")
                .arg("2")
                .arg("3")
                .arg("4")
                .arg("5");

        // then
        assertEquals("12345", partial.apply());
    }

    @Test
    public void shouldApplyFiveArgumentFuncRight() {

        // given
        Function5<String, String, String, String, String, String> f = Partial.function(Functions::funcFiveArgs);

        // when
        Function partial = f.rarg("1")
                .rarg("2")
                .rarg("3")
                .rarg("4")
                .rarg("5");

        // then
        assertEquals("54321", partial.apply());
    }

    @Test
    public void shouldApplyVarargsFunction() {

        // given
        Function2<String, String, String> f = Functions::funcVarArgs;

        // when
        Function partial = f.arg("1")
                .arg("2");

        // then
        assertEquals("12", partial.apply());
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

    private static String repeat(String val, int times) {
        final StringBuilder builder = new StringBuilder();
        for(int ind = 0; ind < times; ind++) {
            builder.append(val);
        }
        return builder.toString();
    }
}