package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
            chatbot.printUserLotto(lottoPrice / 1000, userNumber);
            Lotto lotto = new Lotto(chatbot.askLottoNumber());
            int bonus = validateLottoBonus(lotto, chatbot.askLottoBonus());
            List<Integer> result = compareNumbers(userNumber, lotto, bonus);
            float rate = calculateRate(lottoPrice, result);
            chatbot.printResult(rate, result);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE + " " + e.getMessage());
        }
    }

    public static int validatePrice(String price) {
        for (char c : price.toCharArray()) {
            if (!('0' <= c && c <= '9')) {
                throw new IllegalArgumentException("입력값이 숫자가 아닙니다.");
            }
        }
        int lottoPrice = Integer.parseInt(price);
        if (lottoPrice <= 0) {
            throw new IllegalArgumentException("입력값이 범위를 벗어났습니다.(1,000 이상 2,147,483,000 이하)");
        }
        if (lottoPrice % 1000 != 0) {
            throw new IllegalArgumentException("입력값이 1,000원으로 나누어 떨어지지 않습니다.");
        }
        return lottoPrice;
    }

    public static List<List<Integer>> issueUserLotto(int amount) {
        List<List<Integer>> userNumber = new ArrayList(amount);

        for (int i = 0; i < amount; i++) {
            userNumber.add(Randoms.pickUniqueNumbersInRange(STARTINCLUSIVE, ENDINCLUSIVE, COUNT));
        }
        return userNumber;
    }

    public static int validateLottoBonus(Lotto lotto, int bonus) {

        if (!(0 < bonus && bonus <= 45)) {
            throw new IllegalArgumentException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

        for (int i = 0; i < lotto.getLottoNumber().size(); i++) {
            if (lotto.getLottoNumber().get(i).equals(bonus)) {
                throw new IllegalArgumentException("로또 번호와 보너스 번호는 중복되지 않아야 합니다.");
            }
        }

        return bonus;
    }

    public static List<Integer> compareNumbers(List<List<Integer>> userNumber, Lotto lotto, int bonus) {
        //List<Integer> result = new ArrayList<Integer>();

        return null;
    }

    public static int countSameNum(List<Integer> userEachNumber, Lotto lotto) {
        List<Integer> result = new ArrayList<Integer>();
        int count = 0;

        for (int i = 0; i < COUNT; i++) {
            if(lotto.getLottoNumber().contains(userEachNumber.get(i))) {
                count++;
            }
        }
        return count;
    }

    public static float calculateRate(int price, List<Integer> result) {
        return 0f;
    }
}
