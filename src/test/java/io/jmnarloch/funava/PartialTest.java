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
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Tests the {@link Partial} fascade.
 */
public class PartialTest {

    private static final String ARG = "ARG";
    private static final String FUNC_RESULT = "func result";

    @Test
    public void shouldInvokeFunc() {

        // given
        Func<String> f = Partial.function(Functions::func);

        // when
        String result = f.apply();

        // then
        assertEquals(FUNC_RESULT, result);
    }

    @Test
    public void shouldInvokeFuncWithOneArg() {

        // given
        FuncOne<String, String> f = Partial.function(Functions::funcOneArg);

        // when
        String result = f.apply(ARG);

        // then
        assertEquals(ARG, result);
    }

    @Test
    public void shouldInvokeFuncWithTwoArgs() {

        // given
        FuncTwo<String, String, String> f = Partial.function(Functions::funcTwoArgs);

        // when
        String result = f.apply(ARG, ARG);

        // then
        assertEquals(repeat(ARG, 2), result);
    }

    @Test
    public void shouldInvokeFuncWithThreeArgs() {

        // given
        FuncThree<String, String, String, String> f = Partial.function(Functions::funcThreeArgs);

        // when
        String result = f.apply(ARG, ARG, ARG);

        // then
        assertEquals(repeat(ARG, 3), result);
    }

    @Test
    public void shouldInvokeFuncWithFourArgs() {

        // given
        FuncFour<String, String, String, String, String> f = Partial.function(Functions::funcFourArgs);

        // when
        String result = f.apply(ARG, ARG, ARG, ARG);

        // then
        assertEquals(repeat(ARG, 4), result);
    }

    @Test
    public void shouldInvokeFuncWithFiveArgs() {

        // given
        FuncFive<String, String, String, String, String, String> f = Partial.function(Functions::funcFiveArgs);

        // when
        String result = f.apply(ARG, ARG, ARG, ARG, ARG);

        // then
        assertEquals(repeat(ARG, 5), result);
    }

    @Test
    public void shouldPartiallyApplyOneArgumentFunc() {

        // given
        FuncOne<String, String> f = Partial.function(Functions::funcOneArg);

        // when
        Func<String> partial = f.arg("1");

        // then
        assertEquals("1", partial.apply());
    }

    @Test
    public void shouldPartiallyApplyOneArgumentFuncRight() {

        // given
        FuncOne<String, String> f = Partial.function(Functions::funcOneArg);

        // when
        Func<String> partial = f.rarg("1");

        // then
        assertEquals("1", partial.apply());
    }

    @Test
    public void shouldPartiallyApplyTwoArgumentFunc() {

        // given
        FuncTwo<String, String, String> f = Partial.function(Functions::funcTwoArgs);

        // when
        FuncOne<String, String> partial = f.arg("1");

        // then
        assertEquals("12", partial.apply("2"));
    }

    @Test
    public void shouldPartiallyApplyTwoArgumentFuncRight() {

        // given
        FuncTwo<String, String, String> f = Partial.function(Functions::funcTwoArgs);

        // when
        FuncOne<String, String> partial = f.rarg("1");

        // then
        assertEquals("21", partial.apply("2"));
    }

    @Test
    public void shouldPartiallyApplyThreeArgumentFunc() {

        // given
        FuncThree<String, String, String, String> f = Partial.function(Functions::funcThreeArgs);

        // when
        FuncTwo<String, String, String> partial = f.arg("1");

        // then
        assertEquals("123", partial.apply("2", "3"));
    }

    @Test
    public void shouldPartiallyApplyThreeArgumentFuncRight() {

        // given
        FuncThree<String, String, String, String> f = Partial.function(Functions::funcThreeArgs);

        // when
        FuncTwo<String, String, String> partial = f.rarg("1");

        // then
        assertEquals("231", partial.apply("2", "3"));
    }

    @Test
    public void shouldPartiallyApplyFourArgumentFunc() {

        // given
        FuncFour<String, String, String, String, String> f = Partial.function(Functions::funcFourArgs);

        // when
        FuncThree<String, String, String, String> partial = f.arg("1");

        // then
        assertEquals("1234", partial.apply("2", "3", "4"));
    }

    @Test
    public void shouldPartiallyApplyFourArgumentFuncRight() {

        // given
        FuncFour<String, String, String, String, String> f = Partial.function(Functions::funcFourArgs);

        // when
        FuncThree<String, String, String, String> partial = f.rarg("1");

        // then
        assertEquals("2341", partial.apply("2", "3", "4"));
    }

    @Test
    public void shouldPartiallyApplyFiveArgumentFunc() {

        // given
        FuncFive<String, String, String, String, String, String> f = Partial.function(Functions::funcFiveArgs);

        // when
        FuncFour<String, String, String, String, String> partial = f.arg("1");

        // then
        assertEquals("12345", partial.apply("2", "3", "4", "5"));
    }

    @Test
    public void shouldPartiallyApplyFiveArgumentFuncRight() {

        // given
        FuncFive<String, String, String, String, String, String> f = Partial.function(Functions::funcFiveArgs);

        // when
        FuncFour<String, String, String, String, String> partial = f.rarg("1");

        // then
        assertEquals("23451", partial.apply("2", "3", "4", "5"));
    }

    @Test
    public void shouldApplyFiveArgumentFunc() {

        // given
        FuncFive<String, String, String, String, String, String> f = Partial.function(Functions::funcFiveArgs);

        // when
        Func partial = f.arg("1")
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
        FuncFive<String, String, String, String, String, String> f = Partial.function(Functions::funcFiveArgs);

        // when
        Func partial = f.rarg("1")
                .rarg("2")
                .rarg("3")
                .rarg("4")
                .rarg("5");

        // then
        assertEquals("54321", partial.apply());
    }

    private static String repeat(String val, int times) {
        final StringBuilder builder = new StringBuilder();
        for(int ind = 0; ind < times; ind++) {
            builder.append(val);
        }
        return builder.toString();
    }
}