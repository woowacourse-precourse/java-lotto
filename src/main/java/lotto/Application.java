package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.text.NumberFormat;
import java.util.*;

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
            List<Integer> result = getNumberOfWin(userNumber, lotto, bonus);
            chatbot.printResult(calculateRate(lottoPrice, result), result);
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

    public static List<Integer> getNumberOfWin(List<List<Integer>> userNumber, Lotto lotto, int bonus) {
        List<Integer> result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0,0));

        for (int i = 0; i < userNumber.size(); i++) {
            int countSameNum = countSameNum(userNumber.get(i), lotto, bonus);
            result.set(countSameNum, result.get(countSameNum) + 1);
        }
        return result;
    }

    public static int countSameNum(List<Integer> userEachNumber, Lotto lotto, int bonus) {
        List<Integer> result = new ArrayList<Integer>();
        int count = 0;

        for (int i = 0; i < COUNT; i++) {
            if (lotto.getLottoNumber().contains(userEachNumber.get(i))) {
                count++;
            }
        }
        if (count == 5 && userEachNumber.contains(bonus)) {
            count=7;
        }
        return count;
    }

    public static String calculateRate(int price, List<Integer> result) {
        NumberFormat numberFormat = NumberFormat.getInstance();

        long prizeMoney=result.get(3)*5000+result.get(4)*50000+result.get(5)*1500000+result.get(7)*30000000+result.get(6)*2000000000;
        double rate=prizeMoney/(double)price*100;
        String finalRate = numberFormat.format((int)(rate*10+0.5)/10f);

        return finalRate;
    }
}
