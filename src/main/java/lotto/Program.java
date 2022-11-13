package lotto;

public class Program {
    private final ConsoleProgram consoleProgram;

    public Program() {
        consoleProgram = new ConsoleProgram();
    }

    public void run() {
        consoleProgram.requestMoney();
    }
}
