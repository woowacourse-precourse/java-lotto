package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

enum MatchNumber {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    BONUS_MATCH(7, 30000000);

    private final int value;
    private final long prize;

    MatchNumber(int value, int prize) {
        this.value = value;
        this.prize = prize;
    }

    public int getValue() {
        return value;
    }

    public long getPrize() {
        return prize;
    }
}

public class Application {

    public static final String ERROR_MESSAGE = "[ERROR]";
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int COUNT = 6;
    public static final int ONE_THOUSAND = 1000;

    public static MatchNumber three = MatchNumber.THREE;
    public static MatchNumber four = MatchNumber.FOUR;
    public static MatchNumber five = MatchNumber.FIVE;
    public static MatchNumber six = MatchNumber.SIX;
    public static MatchNumber bonusMatch = MatchNumber.BONUS_MATCH;

    public static void main(String[] args) {
        try {
            Chatbot chatbot = new Chatbot();
            int lottoPrice = validatePrice(chatbot.askPrice());
            List<List<Integer>> userNumber = issueUserLotto(lottoPrice / ONE_THOUSAND);
            chatbot.printUserLotto(lottoPrice / ONE_THOUSAND, userNumber);
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
        if (lottoPrice % ONE_THOUSAND != 0) {
            throw new IllegalArgumentException("입력값이 1,000원으로 나누어 떨어지지 않습니다.");
        }
        return lottoPrice;
    }

    public static List<List<Integer>> issueUserLotto(int amount) {
        List<List<Integer>> userNumber = new ArrayList<>();


        for (int i = 0; i < amount; i++) {
            List<Integer> tmpUserNumber=Randoms.pickUniqueNumbersInRange(STARTINCLUSIVE, ENDINCLUSIVE, COUNT);
            List<Integer> list=new ArrayList<Integer>();


            for(int j=0;j<COUNT;j++){
                list.add(tmpUserNumber.get(j));
            }

            Collections.sort(list);
            userNumber.add(list);
        }
        return userNumber;
    }

    public static int validateLottoBonus(Lotto lotto, int bonus) {

        if (!(STARTINCLUSIVE <= bonus && bonus <= ENDINCLUSIVE)) {
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
        List<Integer> result = new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0));

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
        if (count == five.getValue() && userEachNumber.contains(bonus)) {
            count = bonusMatch.getValue();
        }
        return count;
    }

    public static double calculateRate(int price, List<Integer> result) {

        long prizeMoney = result.get(three.getValue()) * three.getPrize()
                + result.get(four.getValue()) * four.getPrize()
                + result.get(five.getValue()) * five.getPrize()
                + result.get(bonusMatch.getValue()) * bonusMatch.getPrize()
                + result.get(six.getValue()) * six.getPrize();
        double cal = prizeMoney / (double) price * 100;
        return (int) (cal * 10 + 0.5) / 10d;
    }
}