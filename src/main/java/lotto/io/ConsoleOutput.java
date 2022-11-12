package lotto.io;

public class ConsoleOutput implements Output {
    @Override
    public void printOutput(String message) {
        System.out.println(message);
    }
}
