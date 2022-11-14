package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.Result.*;

public class Utils {
    private static final int PRICE_OF_LOTTO = 1000;
    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int NUMBER_OF_NUMS = 6;
    private static final int SECOND_THIRD_STANDARD = 5;
    public static final Map<Result, Integer> WINNING_DATA = new HashMap<>();

    public static int getNumberOfIssues(int price) {
        return price / PRICE_OF_LOTTO;
    }

    private static void initializeMap() {
        for (Result result : Result.values()) {
            WINNING_DATA.put(result, 0);
        }
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

        initializeMap();

        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            int numOfMatching = (int) numbers.stream().filter(winningNums::contains).count();
            if (numOfMatching >= FIFTH.getStandard()) {
                getEachResult(numOfMatching, numbers, bonusNum);
            }
        }
        return WINNING_DATA;
    }

    private static void getEachResult(int numOfMatching, List<Integer> numbers, int bonusNum) {
        if (numOfMatching == SECOND_THIRD_STANDARD) {
            if (numbers.contains(bonusNum)) {
                WINNING_DATA.merge(SECOND, 1, Integer::sum);
                return;
            }
            WINNING_DATA.merge(THIRD, 1, Integer::sum);
            return;
        }

        Result result = findResultByStandard(numOfMatching);
        WINNING_DATA.merge(result, 1, Integer::sum);
    }

    public static String getRatioOfProfit(int price) {
        float totalPrize = 0F;

        Set<Result> results = WINNING_DATA.keySet();
        for (Result result : results) {
            // 해당 등수의 상금 액수 * 당첨 횟수
            totalPrize += result.getPrize() * WINNING_DATA.get(result);
        }

        float ratio = (totalPrize / (float) price) * 100;
        return String.format("%.1f", ratio);
    }

}
