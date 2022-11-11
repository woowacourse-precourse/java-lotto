package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        final String ERROR_MESSAGE = "[ERROR]";

        try {
            Chatbot chatbot = new Chatbot();
            int lottoPrice = validatePrice(chatbot.askPrice());
            System.out.println(lottoPrice);
            List<List<Integer>> userNumber = setUserNumber(lottoPrice / 1000);
            chatbot.printUserNumber(userNumber);
            Lotto lotto = new Lotto(chatbot.askLottoNumber());
            int bonus = validateLottoBonus(chatbot.askLottoBonus());
            List<Integer> result = compareNumbers(userNumber, lotto, bonus);
            float rate = calculateRate(lottoPrice, result);
            chatbot.printResult(rate, result);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + e.getMessage());
        }
    }

    public static int validatePrice(String price) {
        for (char c : price.toCharArray()) {
            if (!('0' <= c && c <= '9')) {
                throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
            }
        }
        int lottoPrice;
        try {
            lottoPrice = Integer.parseInt(price);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력값이 범위를 벗어났습니다.(1,000 이상 2,147,483,000 이하)");
        }
        if (lottoPrice <= 0) {
            throw new IllegalArgumentException("입력값이 범위를 벗어났습니다.(1,000 이상 2,147,483,000 이하)");
        } else if (lottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("입력값이 1,000원으로 나누어 떨어지지 않습니다.");
        }
        return lottoPrice;
    }

    public static List<List<Integer>> setUserNumber(int amount) {
        List<List<Integer>> userNumber = new ArrayList();

        return userNumber;
    }

    public static int validateLottoBonus(String price) {
        return 0;
    }

    public static List<Integer> compareNumbers(List<List<Integer>> userNumber, Lotto lotto, int bonus) {
        List<Integer> result = new ArrayList();

        return result;
    }

    public static float calculateRate(int price, List<Integer> result) {
        return 0f;
    }
}
