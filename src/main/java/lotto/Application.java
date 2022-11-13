package lotto;

import java.util.Scanner;

public class Application {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String PRICE_MESSAGE = "값이 1000으로 나누어지지 않습니다.";
    public static void main(String[] args) {
        int price = inputScanner();
        validatePrice(price);
    }

    public static void validatePrice(int price){
        if (price%1000!=0) {
            throw new IllegalArgumentException(ERROR_MESSAGE+PRICE_MESSAGE);
        }
    }
    public static int inputScanner(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_MESSAGE);
        return scanner.nextInt();
    }
}
