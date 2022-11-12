package lotto;

import java.util.Scanner;

public class View {

    private final Scanner scanner;

    public Exception exception=new Exception();

    public View(Scanner scanner) {
        this.scanner = scanner;;
    }

    public int requestMoney(){
        int inputMoney = scanner.nextInt();
        if(exception.isNumeric(inputMoney)){
            return inputMoney;
        }
        throw new IllegalArgumentException("ERROR");
    }


}
