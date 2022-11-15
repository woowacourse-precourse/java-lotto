package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Map;

public class LottoSystem {
    private static final String inputSuffix = "을(를) 입력해 주세요.";
    private static final String resultPrefix = "당첨 통계\n---";

    private final WinNumber winNumber;
    private final LottoPeople lottoPeople;

    private LottoSystem(WinNumber winNumber, LottoPeople lottoPeople) {
        this.winNumber = winNumber;
        this.lottoPeople = lottoPeople;
    }

    public static LottoSystem start() {
        LottoPeople lottoPeople = generatePerson();
        WinNumber winNumber = generateWinningNumbers();
        return new LottoSystem(winNumber, lottoPeople);
    }

    private static LottoPeople generatePerson() {
        System.out.println(UniqueFile.MONEY + inputSuffix);
        LottoPeople lottoPeople = LottoPeople.from(Check.money(Console.readLine()));
        System.out.println(lottoPeople);
        return lottoPeople;
    }

    private static WinNumber generateWinningNumbers() {
        System.out.println(UniqueFile.WINNING_NUMBER + inputSuffix);
        Lotto winningNumbers = new Lotto(Check.numbers(Console.readLine()));

        System.out.println(UniqueFile.BONUS + inputSuffix);
        int bonusNumber = Check.number(Console.readLine());
        return new WinNumber(winningNumbers, bonusNumber);
    }

    public void result() {
        System.out.println(resultPrefix);
        printResult(lottoPeople.matchResult(winNumber));
    }

    private void printResult(Map<Rank, Integer> matchResult) {
        for (Rank rank : matchResult.keySet()) {
            if (rank == Rank.OUT) {
                continue;
            }
            System.out.printf(rank + " - %d개\n", matchResult.get(rank));
        }
        String printYield = String.format("총 수익률은 %.1f%%입니다.", lottoPeople.yield(matchResult));
        System.out.println(printYield);
    }
}
