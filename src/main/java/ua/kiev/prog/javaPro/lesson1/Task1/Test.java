package ua.kiev.prog.javaPro.lesson1.Task1;

import static java.lang.String.format;

public class Test {
    @MyAnnotation(a="aaa",b="bbb")
    public void testMe(String a, String b) {
        System.out.println(format("Values of parameters: a=%s , b=%s", a, b));
    }
}
