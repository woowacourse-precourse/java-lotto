package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameConsole {

    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public int inputPurchase(){
        notice(INPUT_PURCHASE_MESSAGE);
        String purchase = Console.readLine();
        return Integer.parseInt(purchase);
    }

    public List<Integer> inputWinningNumber(){
        notice(INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumber = Console.readLine();

        return Arrays.stream(winningNumber.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void notice(String inputMessage) {
        System.out.println(inputMessage);
    }

    public int inputBonusNumber(){
        notice(INPUT_BONUS_NUMBER_MESSAGE);
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }

    public void outputLottos(int lottoCount, List<Lotto> lottos) {
        System.out.println(String.format("%d개를 구매했습니다.", lottoCount));
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void outputWinningAmount(Result result) {
        System.out.println(String.format("총 수익률은 %.1f%%입니다.", result.getWinningAmount()));
    }
}
