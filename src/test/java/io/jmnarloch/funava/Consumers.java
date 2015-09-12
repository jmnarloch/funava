package io.jmnarloch.funava;

/**
 * Defines set of method with different argument count for testing purpose.
 *
 * @author Jakub Narloch
 */
public class Consumers {

    static String value;

    static void func() {
        value = "func result";
    }

    static void funcOneArg(String arg) {
        value = arg;
    }

    static void funcTwoArgs(String arg1, String arg2) {
        value = arg1 + arg2;
    }

    static void funcThreeArgs(String arg1, String arg2, String arg3) {
        value = arg1 + arg2 + arg3;
    }

    static void funcFourArgs(String arg1, String arg2, String arg3, String arg4) {
        value = arg1 + arg2 + arg3 + arg4;
    }

    static void funcFiveArgs(String arg1, String arg2, String arg3, String arg4, String args5) {
        value = arg1 + arg2 + arg3 + arg4 + args5;
    }
}
