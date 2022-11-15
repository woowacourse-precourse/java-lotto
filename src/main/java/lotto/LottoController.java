package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoController {
    public void start() {
        Money userInputMoney = new Money(Money.init());
        LottoGame lottoGame = new LottoGame();
        lottoGame.buy(userInputMoney);
        printLottos(lottoGame.getLottos());

        WinningNumbers winningNumbers = printWinningNumber();
        LottoResult lottoResult = lottoGame.checkWinning(winningNumbers);

        printResult(lottoResult);
    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            String numbers = lotto.getNumbers().stream()
                    .map(i -> Integer.toString(i))
                    .collect(Collectors.joining(", "));
            System.out.printf("[%s] \n", numbers);
        }
        System.out.println();
    }

    private WinningNumbers printWinningNumber() {
        List<Integer> lottoItems = new ArrayList<>();
        for (Integer number : winningNumber()) {
            lottoItems.add(number);
        }

        Integer bonusNumber = new Integer(bonusNumber());

        return new WinningNumbers(lottoItems, bonusNumber);
    }

    public static List<Integer> winningNumber() {
        String input = readLine();

        return Arrays.stream(input.split(","))
                .map(i -> Money.changeInt(i.trim()))
                .collect(Collectors.toList());
    }

    public static Integer bonusNumber() {
        Integer bonusNumber = Money.changeInt(readLine());
        System.out.println();
        return bonusNumber;
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        for (LottoPrize prize : LottoPrize.values()) {
            int number = lottoResult.getPrize(prize);
            System.out.printf(generateResultMessage(prize, number));
        }

        double rate = lottoResult.getRate() * 100 ;
        System.out.printf("총 수익률은 %.1f%%입니다.", rate);
    }

    public String generateResultMessage(LottoPrize prize, int number) {
        if (prize == LottoPrize.MISS) {
            return "";
        }
        if (prize == LottoPrize.SECOUND) {
            return String.format("%d개 일치, 보너스 볼 일치 (30,000,000원) - %d개 \n", prize.getLottoNumberMatches(), number);
        }
        if (prize == LottoPrize.FIFTH) {
            return String.format("%d개 일치 (5,000원) - %d개 \n", prize.getLottoNumberMatches(), number);
        }
        if (prize == LottoPrize.FOURTH) {
            return String.format("%d개 일치 (50,000원) - %d개 \n", prize.getLottoNumberMatches(), number);
        }
        if (prize == LottoPrize.THIRD) {
            return String.format("%d개 일치 (1,500,000원) - %d개 \n", prize.getLottoNumberMatches(), number);
        }
        if (prize == LottoPrize.FIRST) {
            return String.format("%d개 일치 (2,000,000,000원) - %d개 \n", prize.getLottoNumberMatches(), number);
        }
        return "";
    }
}
