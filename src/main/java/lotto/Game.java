package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    static int bonus;
    static Lotto winningNumbers;
    static LottoTickets lottoTickets;

    public static int price;

    Game(int price) {
        this.price = price;
    }

    public static void play() {
        enterLottoTickets();
        enterWinningNumbers();
        enterBonus();
        setLottoResults();
        Record.printWinningStats(lottoTickets);
    }

    private static void setLottoResults() {

        int size = lottoTickets.getLottoTicketsSize();

        List<Result> results = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Lotto lotto = lottoTickets.getLotto(i);
            List<Integer> result = lotto.getResult(winningNumbers, bonus);
            Result lottoResult = new Result(result);

            results.add(lottoResult);
        }

        lottoTickets.setLottoResults(results);
        lottoTickets.setMatches();
    }

    private static void enterLottoTickets() {
        int counts = price / ReferenceValue.LOTTO_PRICE;

        Record.printBuyCounts(counts);

        List<Lotto> allLottery = new ArrayList<>();
        for (int i = 0; i < counts; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(ReferenceValue.LOTTO_START_RANGE,
                    ReferenceValue.LOTTO_END_RANGE, ReferenceValue.LOTTO_SIZE);

            Lotto lotto = new Lotto(lottoNumbers);
            Record.printLotto(lotto);
            allLottery.add(lotto);
        }

        lottoTickets = new LottoTickets(allLottery);
        System.out.println();
    }

    private static void enterWinningNumbers() {
        String winningInput = Console.readLine();

        Record.printWinningNumbers();
        System.out.println(winningInput);

        List<Integer> numbers = Lotto.getLottoNumbers(winningInput);
        winningNumbers = new Lotto(numbers);
        System.out.println();
    }

    private static void enterBonus() {
        String bonusInput = Console.readLine();

        bonus = Integer.valueOf(bonusInput);
        Record.printBonusNumber();
        System.out.println(bonus);
        System.out.println();
    }

    public static int enterPrice() {
        Record.printEnterPrice();

        int price = 0;
        String input = Console.readLine();

        System.out.println(input);
        System.out.println();
        boolean error = checkPriceError(input);

        if (error) {
            throw new RuntimeException("[ERROR]");
        }

        price = Integer.parseInt(input);

        return price;
    }

    private static boolean checkPriceError(String input) {

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            Record.printNumberError();
            return true;
        }
        return false;
    }

}
