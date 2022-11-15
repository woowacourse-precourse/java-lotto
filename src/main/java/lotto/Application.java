package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        int lottoCount = lottoPurchase();
        List<Lotto> lotto = new ArrayList<Lotto>();
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Integer> enterValue = enterScore();
        int bonusNumber = bonusNumber(enterValue);

        for (int i = 0; i < lottoCount; i++) {
            lotto.add( new Lotto(issueLottoNumber()));
            System.out.println(lotto.get(i).getNumbers());
        }

        List<List<Integer>> checkList = new ArrayList<>();

        for (int i = 0; i < lotto.size(); i++) {
            checkList.add(checkValue(lotto.get(i).getNumbers(), enterValue, bonusNumber));
        }

        List<Integer> priceList = new ArrayList<>();
        for (int i = 0; i < checkList.size(); i++) {
            priceList.add(price(checkList.get(i), bonusNumber));
        }

        List<String> resultGame = endScore(priceList);
        for (String result : resultGame) {
            System.out.println(result);
        }

        String result = revenue(priceList, lottoCount);

        System.out.println(result);
    }

    public static int lottoPurchase() {
        System.out.println("구입금액을 입력해주세요.");
        int money = Integer.parseInt(Console.readLine());

        if (money % 1000 != 0) {
            throw new IllegalArgumentException(CheckRule.FAILPAYMENT.toString());
        }

        int value = money / 1000;

        return value;
    }

    public static List<Integer> issueLottoNumber() {
        List<Integer> issueLottoList = Randoms.pickUniqueNumbersInRange(1, 45, 6);


        if (issueLottoList.size() != issueLottoList.stream().distinct().count()) {
            throw new IllegalArgumentException(CheckRule.FAILSISE.toString());
        }

        // Collections.sort(issueLottoList);

        return issueLottoList;
    }

    public static List<Integer> enterScore() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String readNumber = Console.readLine();
        String[] valueNumber = readNumber.split(",");
        if (Arrays.stream(valueNumber).count() != 6) throw new IllegalArgumentException(CheckRule.FAILSISE.toString());
        if(Arrays.stream(valueNumber).anyMatch(""::equals)) throw new IllegalArgumentException(CheckRule.FAILSISE.toString());
        int[] intArray = Arrays.stream(valueNumber).mapToInt(Integer::parseInt).toArray();
        List<Integer> resultArray = Arrays.stream(intArray).boxed().collect(Collectors.toList());

        return resultArray;
    }

    public static int bonusNumber(List<Integer> enterScore) {
        System.out.println("");
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        if (enterScore.contains(bonusNumber)) throw new IllegalArgumentException(CheckRule.FAILSAMENUMBER.toString());

        return bonusNumber;
    }

    public static List<Integer> checkValue(List<Integer> lotto, List<Integer> enterScore, int bonusNumber) {
        List<Integer> value = lotto.stream().filter(num -> enterScore.stream().anyMatch(Predicate.isEqual(num))).collect(Collectors.toList());
        if (value.size() == 5) {
            if (lotto.contains(bonusNumber)) {
                value.add(bonusNumber);
            }
        }
        return value;
    }

    public static Integer price(List<Integer> value, int bonusNumber) {

        if (value.size() == 3) return 5000;
        else if (value.size() == 4) return 50000;
        else if (value.size() == 5) return 1500000;
        else if (value.size() == 6) {
            if (value.contains(bonusNumber)) return 30000000;
            if (!value.contains(bonusNumber)) return 2000000000;
        }
        return 0;
    }

    public static List<String> endScore(List<Integer> checkPoint) {
        List<String> checkValue = new ArrayList<>();

        checkValue.add("3개 일치 (5,000원) - " + Collections.frequency(checkPoint, 5000) + "개");
        checkValue.add("4개 일치 (50,000원) - " + Collections.frequency(checkPoint, 50000) + "개");
        checkValue.add("5개 일치 (1,500,000원) - " + Collections.frequency(checkPoint, 1500000) + "개");
        checkValue.add("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(checkPoint, 30000000) + "개");
        checkValue.add("6개 일치 (2,000,000,000원) - " + Collections.frequency(checkPoint, 2000000000) + "개");
        return checkValue;
    }

    public static String revenue(List<Integer> priceList, int lottoCnt) {
        int proceeds = priceList.stream().mapToInt(Integer::intValue).sum();
        lottoCnt = lottoCnt * 1000;
        float result = proceeds / (float) lottoCnt * 100;
        String revenueResult = "총 수익률은 " + Math.round(result*100)/100.0 + "%입니다.";

        return revenueResult;
    }

}
