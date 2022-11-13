package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money = inputMoney();
    }

    public static int inputMoney() {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.next();
        int money;

        try {
            money = checkInput(inputString);
        } catch (Exception e) {
            String errorMessage = "[ERROR] 잘못된 입력이 들어왔습니다.";
            throw new IllegalArgumentException(errorMessage);
        }

        return money;
    }

    public static int checkInput(String input) {
        int inputInteger = Integer.parseInt(input);
        if (inputInteger % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(input);
    }
}
