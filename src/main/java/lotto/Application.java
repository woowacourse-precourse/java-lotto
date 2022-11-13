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
    private static final String LUCKY_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String OUT_OF_RANGE_MESSAGE = "숫자가 범위 밖에 있습니다.";


    public static void main(String[] args) {
        int myPrice = priceInput();
        List<Integer> lottoNumbers = lottoNumAnswerInput();
        Lotto myLotto = new Lotto(lottoNumbers);
        int luckyNumber = getLuckyNumber();
    }

    public static void validatePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + PRICE_MESSAGE);
        }
    }

    public static int priceInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(INPUT_MESSAGE);
        int price = scanner.nextInt();
        validatePrice(price);
        return price;
    }

    public static void validateInputForm(String input) {
        int count = 0;
        for (int charIndex = 0; charIndex < input.length(); charIndex++) {
            if (input.charAt(charIndex) == ',') {
                count++;
            }
        }
        if (count != 5) {
            throw new IllegalArgumentException(ANSWER_MESSAGE);
        }

    }

    public static List<Integer> lottoNumAnswerInput() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> lottoNumbers = new ArrayList<>();
        System.out.println(LOTTO_ANSWER_INPUT_MESSAGE);
        String lottoInput = scanner.nextLine();
        validateInputForm(lottoInput);
        String[] tempInput = lottoInput.split(",");

        for (String num : tempInput) {
            lottoNumbers.add(Integer.valueOf(num));
        }
        return lottoNumbers;
    }

    public static int getLuckyNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(LUCKY_NUMBER_INPUT_MESSAGE);
        int luckyNum = scanner.nextInt();
        isValidateNumber(luckyNum);
        return luckyNum;
    }

    public static void isValidateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_MESSAGE);
        }
    }
}
