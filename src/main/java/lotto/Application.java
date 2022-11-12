package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    static final int LOTTO_PRICE = 1000;
    static int BONUS_NUMBER;
    static int numberOfPurchasedLotto;
    static int totalRevenue;
    static String revenuePercentage;
    static int initialAmount;
    protected static List<Lotto> purchasedLotto = new ArrayList<>();
    static List<Integer> trackEachPlace = new ArrayList<>();
    static Lotto winning_number_lotto;
    static final String ENTER_THE_AMOUNT = "구입금액을 입력해 주세요.";
    static final String ENTER_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    static final String ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    static final String LOTTO_PURCHASE_MESSAGE = "개를 구매했습니다.";
    static final String ANNOUNCEMENT = "당첨 통계\n---";
    static String closingStatement;

    enum places {
        FIRST_PLACE(2000000000, 6, "6개 일치 (2,000,000,000원) - "),
        SECOND_PLACE(30000000, Integer.MAX_VALUE, "5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        THIRD_PLACE(1500000, 5, "5개 일치 (1,500,000원) - "),
        FOURTH_PLACE(50000, 4, "4개 일치 (50,000원) - "),
        FIFTH_PLACE(5000, 3, "3개 일치 (5,000원) - ");

        final int numberMatch;
        final int prize;
        final String message;


        places(int prize, int numberMatch, String message) {
            this.prize = prize;
            this.numberMatch = numberMatch;
            this.message = message;
        }
    }

    public static void main(String[] args) {
        printLottoNumbers();
        validateGivenNumbers();
        initializeBonusNumber();
        showStatistics();

    }

    public static void enterTheAmount() {
        System.out.println(ENTER_THE_AMOUNT);
        initialAmount = Integer.parseInt(Console.readLine());
        if (initialAmount % LOTTO_PRICE != 0) throw new IllegalArgumentException();
        numberOfPurchasedLotto = initialAmount / LOTTO_PRICE;
    }

    public static Lotto generateSixNumbers() {
        System.out.println(ENTER_WINNING_NUMBER);
        String inputNumbers = Console.readLine();
        String[] winningNumbersAsString = inputNumbers.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumbersAsString) winningNumbers.add(Integer.parseInt(number));
        return new Lotto(winningNumbers);
    }

    public static boolean hasInvalidInput(List<Integer> numbers) {
        for (int number : numbers) {
            if(isNotInRange(number)) return true;
        }
        return false;
    }

    public static boolean isNotInRange(int number){
        return number < 1 || number > 45;
    }

    public static void validateGivenNumbers() {
        winning_number_lotto = generateSixNumbers();
        if (hasInvalidInput(winning_number_lotto.getNumbers())) {
            System.out.println(ERROR_MESSAGE);
            throw new IllegalArgumentException();
        }

    }

    public static void initializeBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        do {
            BONUS_NUMBER = Integer.parseInt(Console.readLine());
        } while (hasInvalidInput(List.of(BONUS_NUMBER)));
    }

    public static Lotto generateRandomSixNumbers() {
        List<Integer> lottoNumbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
    }

    public static void printLottoNumbers() {
        enterTheAmount();
        System.out.println(numberOfPurchasedLotto + LOTTO_PURCHASE_MESSAGE);
        for (int index = 0; index < numberOfPurchasedLotto; index++) {
            purchasedLotto.add(generateRandomSixNumbers());
            System.out.println(purchasedLotto.get(index).getNumbers().toString());
        }
    }

    public static void countMatchingNumber() {
        for (Lotto lotto : purchasedLotto) {
            int matchedNumber = returnMatchedNumber(lotto);
            boolean containsBonusNumber = containsBonusNumber(lotto);
            if (containsBonusNumber && matchedNumber == places.THIRD_PLACE.numberMatch) {
                trackEachPlace.add(Integer.MAX_VALUE);
                continue;
            }
            trackEachPlace.add(matchedNumber);
        }
    }

    public static int returnMatchedNumber(Lotto lotto) {
        int count = 0;
        for (int number : winning_number_lotto.getNumbers()) {
            if (lotto.containsTheNumber(number)) count++;
        }
        return count;
    }

    public static boolean containsBonusNumber(Lotto lotto) {
        return lotto.containsTheNumber(BONUS_NUMBER);
    }

    public static void showStatistics() {
        countMatchingNumber();
        System.out.println(ANNOUNCEMENT);
        printAndAdd(places.FIFTH_PLACE);
        printAndAdd(places.FOURTH_PLACE);
        printAndAdd(places.THIRD_PLACE);
        printAndAdd(places.SECOND_PLACE);
        printAndAdd(places.FIRST_PLACE);
        calculatePercentage();
        System.out.println(closingStatement);

    }

    public static void printAndAdd(places place) {
        int won = Collections.frequency(trackEachPlace, place.numberMatch);
        System.out.println(place.message + won + "개");
        totalRevenue += won * place.prize;
    }

    public static void calculatePercentage() {
        revenuePercentage = String.format("%.1f", ((double) totalRevenue / initialAmount * 100));
        closingStatement = "총 수익률은 " + revenuePercentage + "%입니다.";
    }
}