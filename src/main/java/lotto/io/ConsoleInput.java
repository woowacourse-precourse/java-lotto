package lotto.io;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private  final Scanner scanner = new Scanner(System.in);
    @Override
    public String input() {
        return scanner.nextLine();
    }
}
