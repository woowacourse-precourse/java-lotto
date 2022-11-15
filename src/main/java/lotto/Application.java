package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.stream.IntStream;

enum MatchCount {
    THREE(3, 5000, "3개 일치 ", "(5,000원) - "), FOUR(4, 50000, "4개 일치 ", "(50,000원) - "),
    FIVE(5, 1500000, "5개 일치 ", "(1,500,000원) - "),
    SIX(6, 2000000000, "6개 일치 ", "(2,000,000,000원) - "),
    LUCKY_FIVE(7, 30000000, "5개 일치, 보너스 볼 일치 ", "(30,000,000원) - ");

    private final int key;
    private final int profit;
    private final String value;
    private final String prize;

    MatchCount(int key, int profit, String value, String prize) {
        this.key = key;
        this.profit = profit;
        this.value = value;
        this.prize = prize;
    }

    public int getKey() {
        return key;
    }

    public int getProfit() {
        return profit;
    }

    public String getValue() {
        return value;
    }

    public String getPrize() {
        return prize;
    }
}

public class Application {
    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_ANSWER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String NOT_NUMBER_MESSAGE = "값이 숫자가 아닙니다.";
    private static final String PRICE_MESSAGE = "값이 1000으로 나누어지지 않습니다.";
    private static final String ANSWER_MESSAGE = "번호가 6개가 아닙니다";
    private static final String LUCKY_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String OUT_OF_RANGE_MESSAGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다";
    private static final String SHOP_RESULT = "개를 구매했습니다.";
    private static final String IS_DUPLICATED_MESSAGE = "숫자가 중복되었습니다.";
    private static final String LOTTO_RESULT = "당첨 통계";
    private static final String LOTTO_RESULT_LINE = "---";
    private static final String COUNT = "개";
    private static final String PROFIT_MESSAGE_PREFIX = "총 수익률은 ";
    private static final String PROFIT_MESSAGE_SUFFIX = "%입니다.";

    public static void main(String[] args) {
        int myPrice = priceInput();
        int lottoCount = howManyLottos(myPrice);
        System.out.println(lottoCount + SHOP_RESULT);

        List<List<Integer>> myLottos = getMyLottos(lottoCount);
        for (List<Integer> myLotto : myLottos) {
            System.out.println(myLotto);
        }

        List<Integer> lottoNumbers = lottoNumAnswerInput();
        Lotto lottoAnswer = new Lotto(lottoNumbers);
        int luckyNumber = getLuckyNumber();

        HashMap result = lottoResult(lottoAnswer, luckyNumber, myLottos);
        double profit = calculateProfit(myPrice, result);
        System.out.println(PROFIT_MESSAGE_PREFIX + profit + PROFIT_MESSAGE_SUFFIX);
    }

    public static HashMap lottoResult(Lotto answer, int luckyNum, List<List<Integer>> lottos) {
        System.out.println(LOTTO_RESULT);
        System.out.println(LOTTO_RESULT_LINE);
        List lottoAnswer = answer.getNumbers();
        HashMap result = setMap();

        for (List<Integer> lotto : lottos) {
            int count=calculateCount(lotto,lottoAnswer);
            int isLucky=checkIsLucky(lotto,luckyNum);
            count=checkIsSeven(count,isLucky);
            int num =setNum(count,result);
            result.put(count, num);
        }

        printResult(result);
        return result;
    }
    public static int setNum(int count,HashMap result){
        int num=0;
        if (count > 2 && count < 8) {
            num = (int) result.get(count);
        }
        num++;
        return num;
    }
    public static int checkIsSeven(int count,int isLucky){
        if (count == 5 && isLucky == 1) {
            count = 7;
        }
        return count;
    }
    public static int checkIsLucky(List lotto,int luckyNum){
        int isLucky = 0;
        if (lotto.contains(luckyNum)) {
            isLucky = 1;
        }
        return isLucky;
    }
    public static HashMap setMap(){
        HashMap result = new HashMap();
        for (int loop = 3; loop < 8; loop++) {
            result.put(loop, 0);
        }
        return result;
    }
    public static int calculateCount(List<Integer> lotto,List lottoAnswer){
        int count=0;
        for (Object number : lottoAnswer) {
            if (lotto.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public static double calculateProfit(int price, HashMap result) {
        double profit = (((int) result.get(MatchCount.THREE.getKey())) * MatchCount.THREE.getProfit() +
                ((int) result.get(MatchCount.FOUR.getKey())) * MatchCount.FOUR.getProfit() +
                ((int) result.get(MatchCount.FIVE.getKey())) * MatchCount.FIVE.getProfit() +
                ((int) result.get(MatchCount.LUCKY_FIVE.getKey())) * MatchCount.LUCKY_FIVE.getProfit() +
                ((int) result.get(MatchCount.SIX.getKey())) * MatchCount.SIX.getProfit());
        profit = Math.round(profit * 10000 / price);
        profit /= 100;
        return profit;
    }

    public static void printResult(HashMap result) {
        System.out.println(MatchCount.THREE.getValue() + MatchCount.THREE.getPrize() + result.get(MatchCount.THREE.getKey()) + COUNT);
        System.out.println(MatchCount.FOUR.getValue() + MatchCount.FOUR.getPrize() + result.get(MatchCount.FOUR.getKey()) + COUNT);
        System.out.println(MatchCount.FIVE.getValue() + MatchCount.FIVE.getPrize() + result.get(MatchCount.FIVE.getKey()) + COUNT);
        System.out.println(MatchCount.LUCKY_FIVE.getValue() + MatchCount.LUCKY_FIVE.getPrize() + result.get(MatchCount.LUCKY_FIVE.getKey()) + COUNT);
        System.out.println(MatchCount.SIX.getValue() + MatchCount.SIX.getPrize() + result.get(MatchCount.SIX.getKey()) + COUNT);

    }

    public static List<List<Integer>> getMyLottos(int count) {
        List<List<Integer>> totalLottos = new ArrayList<>();
        List<Integer> numbers;
        for (int loop = 0; loop < count; loop++) {
            numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            isValidateNumbers(numbers);
            isDuplicated(numbers);
//            Collections.sort(numbers); ??
            totalLottos.add(numbers);
        }
        return totalLottos;

    }

    public static int howManyLottos(int price) {
        return price / 1000;
    }

    public static void validatePrice(int price) {
        if (price % 1000 != 0) {
            System.out.println(ERROR_MESSAGE + PRICE_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE + PRICE_MESSAGE);
        }
    }

    public static int isNumber(String price) {
        int priceChecked=0;
        try {
            priceChecked = Integer.parseInt(price);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE);
//            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return priceChecked;
    }

    public static int priceInput() {
        System.out.println(INPUT_MESSAGE);
        String getPrice = Console.readLine();
        int price =isNumber(getPrice);
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
            System.out.println(ANSWER_MESSAGE);
            throw new IllegalArgumentException(ANSWER_MESSAGE);
        }

    }

    public static List<Integer> lottoNumAnswerInput() {
        List<Integer> lottoNumbers = new ArrayList<>();
        System.out.println(LOTTO_ANSWER_INPUT_MESSAGE);
        String lottoInput = Console.readLine();
        validateInputForm(lottoInput);
        String[] tempInput = lottoInput.replace(" ", "").split(",");

        for (String num : tempInput) {
            lottoNumbers.add(Integer.valueOf(num));
        }
        return lottoNumbers;
    }

    public static int getLuckyNumber() {
        System.out.println(LUCKY_NUMBER_INPUT_MESSAGE);
        String getLuckyNum = Console.readLine();
        int luckyNum = Integer.valueOf(getLuckyNum);
        isValidateNumber(luckyNum);
        return luckyNum;
    }

    public static void isDuplicated(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (Collections.frequency(numbers, num) != 1) {
                System.out.println(ERROR_MESSAGE + IS_DUPLICATED_MESSAGE);
                throw new IllegalArgumentException(ERROR_MESSAGE + IS_DUPLICATED_MESSAGE);
            }
        }
    }

    public static void isValidateNumber(int number) {
        if (number < 1 || number > 45) {
            System.out.println(ERROR_MESSAGE + OUT_OF_RANGE_MESSAGE);
            throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_MESSAGE);
        }
    }

    public static void isValidateNumbers(List<Integer> numbers) {
        for (Integer num : numbers) {
            if (num < 1 || num > 45) {
                System.out.println(ERROR_MESSAGE + OUT_OF_RANGE_MESSAGE);
                throw new IllegalArgumentException(ERROR_MESSAGE + OUT_OF_RANGE_MESSAGE);
            }
        }
    }
}
