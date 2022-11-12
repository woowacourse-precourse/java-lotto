package lotto;

import java.util.Scanner;

public class View {

    private final Scanner scanner;


    public View(Scanner scanner) {
        this.scanner = scanner;
    }

    public int requestMoney(){
        int inputMoney = scanner.nextInt();

        return inputMoney;
    }


}
