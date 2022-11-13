package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_ANSWER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String PRICE_MESSAGE = "값이 1000으로 나누어지지 않습니다.";
    private static final String ANSWER_MESSAGE = "번호가 6개가 아닙니다";
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
    public static void validateInputForm(String input){
        int count=0;
        for (int charIndex = 0; charIndex < input.length(); charIndex++) {
            if (input.charAt(charIndex)==',') {
                count++;
            }
        }
        if(count!=5){
            throw new IllegalArgumentException(ANSWER_MESSAGE);
        }

    }
    public static List<Integer> LottoNumAnswerInput(){
        Scanner scanner = new Scanner(System.in);
        List<Integer> lottoNumbers = new ArrayList<>();
        int lottoNum=1;
        System.out.println(LOTTO_ANSWER_INPUT_MESSAGE);
        String lottoInput = scanner.nextLine();
        validateInputForm(lottoInput);

        return lottoNumbers;
    }
}
