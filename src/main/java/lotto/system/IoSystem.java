package lotto.system;


public interface IoSystem {

    String input();

    void print(final Object message);

    void println(final Object message);

    void printBeforeNextLine(final Object message);
}