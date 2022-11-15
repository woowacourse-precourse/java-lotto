package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogManager;

public class Game {

    static int bonus;
    static Lotto winningNumbers;
    static LottoTickets lottoTickets;
    public static Long price;

    Game(String input) {
        checkInputError(input);
        this.price = Long.valueOf(input);
    }

    public static void play() {
        try {
            enterLottoTickets();
            enterWinningNumbers();
            enterBonus();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        setLottoResults();
        System.out.println(Record.getWinningStats(lottoTickets));
    }

    private static void setLottoResults() {

        int size = lottoTickets.getLottoTicketsSize();

        List<LottoResult> lottoResults = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Lotto lotto = lottoTickets.getLotto(i);
            List<Integer> result = lotto.getResult(winningNumbers, bonus);
            LottoResult lottoResult = new LottoResult(result);

            lottoResults.add(lottoResult);
        }

        lottoTickets.setLottoResults(lottoResults);
        lottoTickets.setMatches();
    }

    private static void enterLottoTickets() {
        long counts =  price / ReferenceValue.Lotto.PRICE.getValue().longValue();
        System.out.println(Record.getBuyCounts(counts));

        List<Lotto> allLottery = new ArrayList<>();
        for (int i = 0; i < counts; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(ReferenceValue.Lotto.START_RANGE.getValue(),
                    ReferenceValue.Lotto.END_RANGE.getValue(), ReferenceValue.Lotto.SIZE.getValue());

            List<Integer> sortedNumbers = Lotto.sortLottoNumbers(lottoNumbers);
            Lotto lotto = new Lotto(sortedNumbers);
            checkLottoTickets(allLottery, lotto);
            allLottery.add(lotto);
        }
        System.out.println();
        lottoTickets = new LottoTickets(allLottery);
    }

    public static void checkLottoTickets(List<Lotto> allLottery, Lotto uncheckedLotto) {
        for (Lotto lotto : allLottery) {
            lotto.checkDuplicateLotto(uncheckedLotto);
        }
    }
    private static void enterWinningNumbers() {
        String winningInput = Console.readLine();

        System.out.println(Record.getWinningNumbers());
        System.out.println(winningInput + ReferenceValue.LINE_BREAK);

        if (checkWinningNumbersError(winningInput)) {
            throw new IllegalArgumentException();
        }
        List<Integer> numbers = Lotto.getLottoNumbers(winningInput);
        winningNumbers = new Lotto(numbers);
    }

    private static void enterBonus() {
        String bonusInput = Console.readLine();

        System.out.println(Record.getBonusNumber());
        System.out.println(bonusInput + ReferenceValue.LINE_BREAK);

        if (checkNumberError(bonusInput) || checkBonusDuplicateError(bonusInput) || checkBonusRangeError(bonusInput)) {
            throw new IllegalArgumentException();
        }

        bonus = Integer.valueOf(bonusInput);
    }
    private static boolean checkWinningNumbersError(String winningInput) {

        String[] splitWinningInput = winningInput.split(",");

        for (String winningOne : splitWinningInput) {
            if (checkNumberError(winningOne)) {
                return true;
            }
        }

        return false;
    }
    private static boolean checkBonusRangeError(String bonusInput) {

        int bonus = Integer.valueOf(bonusInput);

        if (bonus < ReferenceValue.Lotto.START_RANGE.getValue()
                || bonus > ReferenceValue.Lotto.END_RANGE.getValue()) {
            Record.printRangeError();
            return true;
        }

        return false;
    }

    private static boolean checkBonusDuplicateError(String bonusInput) {
        int bonus = Integer.valueOf(bonusInput);
        return winningNumbers.checkBonusDuplicate(bonus);
    }

    public static void checkInputError(String input) {
        Record.printEnterPrice();
        System.out.println(input + ReferenceValue.LINE_BREAK);

        if (checkNumberError(input) || checkPriceRangeError(input) || checkPriceError(input)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkPriceRangeError(String input) {
        Long price = Long.valueOf(input);
        Long minPrice = (long) ReferenceValue.Lotto.PRICE.getValue();
        Long maxPrice = minPrice * ReferenceValue.Lotto.MAX_COUNTS.getValue();

        if (price < minPrice || price > maxPrice) {
            Record.printPriceRangeError();
            return true;
        }

        return false;
    }

    private static boolean checkPriceError(String input) {
        Long price = Long.valueOf(input);

        if (price % ReferenceValue.Lotto.PRICE.getValue() != ReferenceValue.NOTHING) {
            Record.printPriceError();
            return true;
        }

        return false;
    }

    public static boolean checkNumberError(String input) {
        try {
            Long.valueOf(input);
        } catch (NumberFormatException e) {
            Record.printNumberError();
            return true;
        }
        return false;
    }

}
