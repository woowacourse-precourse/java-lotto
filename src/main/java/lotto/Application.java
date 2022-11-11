package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int STARTINCLUSIVE = 1;
    private static final int ENDINCLUSIVE = 45;
    private static final int COUNT = 6;

    public static void main(String[] args) {
        try {
            Chatbot chatbot = new Chatbot();
            int lottoPrice = validatePrice(chatbot.askPrice());
            List<List<Integer>> userNumber = issueUserLotto(lottoPrice / 1000);
            chatbot.printUserLotto(lottoPrice / 1000,userNumber);
            /*Lotto lotto = new Lotto(chatbot.askLottoNumber());
            List<Integer> result = compareNumbers(userNumber, lotto, validateLottoBonus(chatbot.askLottoBonus()));
            float rate = calculateRate(lottoPrice, result);
            chatbot.printResult(rate, result);*/
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

    public static List<List<Integer>> issueUserLotto(int amount) {
        List<List<Integer>> userNumber = new ArrayList(amount);

        for(int i=0;i<amount;i++){
            userNumber.add(Randoms.pickUniqueNumbersInRange(STARTINCLUSIVE, ENDINCLUSIVE, COUNT));
        }
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
