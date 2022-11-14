package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    static int bonus;
    static Lotto winningNumbers;
    static LottoTickets lottoTickets;
    static StringBuilder totalLog = new StringBuilder();
    public static int price;

    Game(String input) {
        this.price = Integer.valueOf(input);
    }

    public static void play() {
        try {
            enterLottoTickets();
            enterWinningNumbers();
            enterBonus();
        } catch (IllegalArgumentException e) {
            return;
        }
        setLottoResults();
        totalLog.append(Record.getWinningStats(lottoTickets));
        System.out.println(totalLog);
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
        int counts = price / ReferenceValue.Lotto.PRICE.getValue();
        totalLog.append(Record.getBuyCounts(counts) + ReferenceValue.LINE_BREAK);

        List<Lotto> allLottery = new ArrayList<>();
        for (int i = 0; i < counts; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(ReferenceValue.Lotto.START_RANGE.getValue(),
                    ReferenceValue.Lotto.END_RANGE.getValue(), ReferenceValue.Lotto.SIZE.getValue());

            Lotto lotto = new Lotto(lottoNumbers);
            totalLog.append(Record.getLotto(lotto) + ReferenceValue.LINE_BREAK);
            allLottery.add(lotto);
        }

        lottoTickets = new LottoTickets(allLottery);
        totalLog.append(ReferenceValue.LINE_BREAK);
    }

    private static void enterWinningNumbers() {
        String winningInput = Console.readLine();

        totalLog.append(Record.getWinningNumbers() + ReferenceValue.LINE_BREAK);
        totalLog.append(winningInput + ReferenceValue.LINE_BREAK + ReferenceValue.LINE_BREAK);

        List<Integer> numbers = Lotto.getLottoNumbers(winningInput);
        winningNumbers = new Lotto(numbers);
    }

    private static void enterBonus() {
        String bonusInput = Console.readLine();

        totalLog.append(Record.getBonusNumber() + ReferenceValue.LINE_BREAK);
        totalLog.append(bonusInput + ReferenceValue.LINE_BREAK + ReferenceValue.LINE_BREAK);

        if (checkNumberError(bonusInput) || checkBonusDuplicateError(bonusInput) || checkBonusRangeError(bonusInput)) {
            throw new IllegalArgumentException();
        }

        bonus = Integer.valueOf(bonusInput);
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

    public static String checkInputError() {

        Record.printEnterPrice();
        String input = Console.readLine();

        System.out.println(input + ReferenceValue.LINE_BREAK);

        if (checkNumberError(input)
                || checkMinimumPriceError(input)
                || checkPriceError(input)) {
            return Record
                    .ErrorMessage
                    .IS_ERROR
                    .getMessage();
        }

        return input;
    }

    public static void checkError(boolean error) {
        if (error) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean checkMinimumPriceError(String input) {
        int price = Integer.parseInt(input);

        if (price < ReferenceValue.Lotto.PRICE.getValue()) {
            Record.printMinimumError();
            return true;
        }

        return false;
    }

    private static boolean checkPriceError(String input) {
        int price = Integer.parseInt(input);

        if (price % ReferenceValue.Lotto.PRICE.getValue() != ReferenceValue.NOTHING) {
            Record.printPriceError();
            return true;
        }

        return false;
    }

    public static boolean checkNumberError(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Record.printNumberError();
            return true;
        }
        return false;
    }

}
