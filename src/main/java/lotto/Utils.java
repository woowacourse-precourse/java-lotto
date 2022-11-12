package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.Result.*;

public class Utils {
    private static final int LOTTO_PRICE = 1000;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int NUMBER_OF_NUMS = 6;
    private static final int FIRST_PLACE_STANDARD = 6;
    private static final int SECOND_THIRD_PLACE_STANDARD = 5;
    private static final int FOURTH_PLACE_STANDARD = 4;
    private static final int FIFTH_PLACE_STANDARD = 3;
    private static final Map<Result, Integer> WINNING_DATA = new HashMap<>();

    public static int getNumberOfIssues(int price) {
        return price / LOTTO_PRICE;
    }

    public static List<Lotto> issueLotto(int price) {
        List<Lotto> issuedLottos = new ArrayList<>();
        for (int count = 0; count < price ; count++) {
            List<Integer> picked = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, NUMBER_OF_NUMS);
            issuedLottos.add(new Lotto(picked));
        }
        return issuedLottos;
    }

    public static int stringToInt(String response) throws IllegalArgumentException {
        try {
            return Integer.parseInt(response);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력 가능합니다.");
        }
    }

    public static String[] splitInput(String input) throws IllegalArgumentException {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("각 로또 번호는 쉼표(,)로 구분하여 입력되어야 합니다.");
        }
        String trimmed = input.replaceAll(" ", "");
        return trimmed.split(",");
    }

    public static List<Integer> stringArrToIntegerList(String[] winningNums) throws IllegalArgumentException {
        List<Integer> converted = new ArrayList<>();
        try {
            for (String num : winningNums) {
                converted.add(Integer.parseInt(num));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 정수로 입력해야 합니다.");
        }
        return converted;
    }

    public static Map<Result, Integer> getAllResults(List<Lotto> lottos, List<Integer> winningNums, int bonusNum) {
        for (Lotto lotto : lottos) {
            getEachResult(lotto, winningNums, bonusNum);
        }
        return WINNING_DATA;
    }

    private static void getEachResult(Lotto lotto, List<Integer> winningNums, int bonusNum) {
        List<Integer> numbers = lotto.getNumbers();
        int numOfMatching = (int) numbers.stream().filter(winningNums::contains).count();
        if (numOfMatching == FIRST_PLACE_STANDARD) {
            WINNING_DATA.merge(FIRST, 1, Integer::sum);
        } else if (numOfMatching == SECOND_THIRD_PLACE_STANDARD && numbers.contains(bonusNum)) {
            WINNING_DATA.merge(SECOND, 1, Integer::sum);
        } else if (numOfMatching == SECOND_THIRD_PLACE_STANDARD) {
            WINNING_DATA.merge(THIRD, 1, Integer::sum);
        } else if (numOfMatching == FOURTH_PLACE_STANDARD) {
            WINNING_DATA.merge(FOURTH, 1, Integer::sum);
        } else if (numOfMatching == FIFTH_PLACE_STANDARD) {
            WINNING_DATA.merge(FIFTH, 1, Integer::sum);
        }
        setZeroForNull();
    }

    private static void setZeroForNull() {
        for (Result result : Result.values()) {
            WINNING_DATA.putIfAbsent(result, 0);
        }
    }

    public static String getRatioOfProfit(int price) {
        float totalPrize = 0F;

        Set<Result> results = WINNING_DATA.keySet();
        for (Result result : results) {
            totalPrize += result.getIntPrize() * WINNING_DATA.get(result);
        }

        float ratio = (totalPrize / (float) price) * 100;
        return String.format("%.1f", ratio);
    }

}
