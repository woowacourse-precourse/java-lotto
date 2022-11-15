package lotto;

import java.util.Scanner;

public class Application {

    static String getMoney() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        return userInput;
    }
    static String[] getWinNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        String[] winNumbers = userInput.split(",");
        return winNumbers;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String[] winNumbers = getWinNumbers();
        String Money = getMoney();

    }
}
