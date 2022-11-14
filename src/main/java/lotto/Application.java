package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import lotto.buy.Payment;
import lotto.input.InputConvert;
import lotto.result.LottoCompare;
import lotto.result.ResultPrint;
import lotto.situation.Lotto;
import lotto.situation.QuickPick;

public class Application {

    public static void main(String[] args) {
        try {
            play();
        } catch (IllegalArgumentException ignored) {
        }
    }
    private static void play() {
        System.out.println("구입금액을 입력해 주세요.");
        Payment payment = new Payment(InputConvert.oneNumber(readLine()));
        System.out.println("\n" + payment.purchase() + "개를 구매했습니다.");
        List<List<Integer>> quickPicks = QuickPick.bulkPick(payment.purchase());
        for (List<Integer> quickPick : quickPicks) {
            System.out.println(quickPick);
        }

        System.out.println("\n당첨 번호를 입력해 주세요.");
        Lotto lotto = new Lotto(InputConvert.lottoNumber(readLine()));
        System.out.println("\n보너스 번호를 입력해 주세요.");
        int bonusNumber = InputConvert.oneNumber(readLine());

        LottoCompare lottoCompare = new LottoCompare(quickPicks, lotto.getNumbers(), bonusNumber);
        ResultPrint.printingResult(lottoCompare.getPrizesMap());
    }

}
