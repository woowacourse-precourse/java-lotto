package lotto;

import java.util.List;
import lotto.controller.LottoMachine;
import lotto.enums.LottoInfo;
import lotto.veiw.UserInterface;

public class Application {
    public static final UserInterface userInterface = new UserInterface();
    public static final LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int buyCount = lottoMachine.getLottoBuyCount(userInterface.inputOnlyNumber());
            lottoMachineBuyLottos(buyCount);
            System.out.println("\n당첨 번호를 입력해 주세요.");
            List<Integer> winning = lottoMachine.getWinningNumbers(userInterface.inputWinningNumbers());
            System.out.println("\n보너스 번호를 입력해 주세요.");
            int bonus = lottoMachine.getBonusNumber(userInterface.inputOnlyNumber(), winning);
            lottoMachineCalculateResult(buyCount, winning, bonus);
            userInterface.printResult(lottoMachine.getStatistics(), lottoMachine.getRevenue());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void lottoMachineBuyLottos(int buyCount) {
        lottoMachine.buyLottos(buyCount);
        userInterface.printLottos(lottoMachine.getLottos());
    }

    private static void lottoMachineCalculateResult(int buyCount, List<Integer> winning, int bonus) {
        lottoMachine.calculateResult(winning, bonus);
        lottoMachine.calculateRevenue(buyCount * LottoInfo.PRICE.getValue());
    }
}
