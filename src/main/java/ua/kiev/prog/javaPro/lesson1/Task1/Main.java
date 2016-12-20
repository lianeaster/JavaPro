package ua.kiev.prog.javaPro.lesson1.Task1;

import static java.util.stream.Stream.of;

public class Main {
    public static void main(String[] args) {
        of(Test.class.getDeclaredMethods())
                .map(method -> method.getAnnotation(MyAnnotation.class))
                .findAny()
                .ifPresent(annotation ->
                        new Test().testMe(annotation.a(), annotation.b()));
    }
}
