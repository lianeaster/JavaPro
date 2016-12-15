package ua.kiev.prog.javaPro.lesson1.Task2;

public class Main {
    public static void main(String[] args) {
        TextContainer textContainer = new TextContainer();
        String path = textContainer.getClass().getDeclaredAnnotation(SaveTo.class).path();
        textContainer.save(path);
    }
}
