package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Buyer;
import lotto.domain.Judgment;
import lotto.domain.LottoWinningNumber;
import lotto.domain.enums.WinningAmount;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        int lottoAmount = inputAmount();
        Buyer buyer = new Buyer(lottoAmount);

        System.out.println(buyer.calculateLottoCount() + "개를 구매했습니다.");
        buyer.buyLotto();
        buyer.printLotto();

        String inputWinningNumber = inputWinningNumber();
        List<Integer> winningNumbers = LottoWinningNumber.winningNumberConversion(inputWinningNumber);

        String inputBonusNumber = inputBonusNumber();
        int bonusNumber = LottoWinningNumber.bonusNumberConversion(inputBonusNumber);

        LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(winningNumbers, bonusNumber);

        int[] wins = Judgment.calculateWins(
                buyer.getPurchaseLotto(),
                lottoWinningNumber.getWinningNumbers(),
                lottoWinningNumber.getBonusNumber()
        );
        buyer.setMyWins(wins);

        System.out.println("당첨 통계");
        System.out.println("---");
        buyer.calculateTotalMoney();
        buyer.calculateTotalRate();

        printResult(wins,buyer.getTotalRate());


    }

    static int inputAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        String inputValue = Console.readLine();
        return Buyer.lottoAmountConversion(inputValue);
    }

    static String inputWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputValue = Console.readLine();
        return inputValue;
    }

    static String inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputValue = Console.readLine();
        return inputValue;
    }
     static void printResult(int[] myWins,double rate) {
        WinningAmount[] values = WinningAmount.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].getPrizeMessage()+" - "+myWins[i]+"개");
        }
         System.out.println("총 수익률은 "+rate+"%입니다.");
    }
}
