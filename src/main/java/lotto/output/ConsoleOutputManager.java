package lotto.output;

public class ConsoleOutputManager implements OutputManager{
    @Override
    public void write(String message) {
        System.out.print(message);
    }
}
