package lotto;

import java.util.ArrayList;
import java.util.Arrays;
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

    }

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            String numbers = lotto.getNumbers().stream()
                    .map(i -> Integer.toString(i))
                    .collect(Collectors.joining(", "));
            System.out.printf("[%s]" + System.lineSeparator(), numbers);
        }
        System.out.println();
    }

    private WinningNumbers printWinningNumber() {
        List<LottoItem> lottoItems = new ArrayList<>();
        for (Integer number : winningNumber()) {
            lottoItems.add(new LottoItem(number));
        }

        LottoItem lottoItem = new LottoItem(bonusNumber());

        return new WinningNumbers(lottoItems, lottoItem);
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
            System.out.println();
        }

        double rate = Math.floor(lottoResult.getRate() * 100) / 100 ;
        System.out.printf("총 수익률은 %.2f 입니다.", rate);
    }

    public String generateResultMessage(LottoPrize prize, int number) {
        if (prize == LottoPrize.MISS) {
            return "";
        }
        if (prize == LottoPrize.SECOUND) {
            return String.format("%d개, 보너스 볼 일치 %d개 (%d)원 ", prize.getLottoNumberMatches(), prize.getReward().get(), number);
        }
        return String.format("%d개, 보너스 볼 일치 %d개 (%d)원", prize.getLottoNumberMatches(), prize.getReward().get(), number);
    }
}
