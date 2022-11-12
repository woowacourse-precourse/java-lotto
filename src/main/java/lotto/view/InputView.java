package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.IOMessage;
import lotto.verifier.BonusNumberVerifier;
import lotto.verifier.MoneyVerifier;
import lotto.verifier.LottoVerifier;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class InputView {
    private static MoneyVerifier moneyVerifier = new MoneyVerifier();
    private static BonusNumberVerifier bonusNumberVerifier = new BonusNumberVerifier();
    private static LottoVerifier lottoVerifier = new LottoVerifier();

    private InputView() {
    }

    public static int readAmount() {
        OutputView.printIOMessage(IOMessage.READ_AMOUNT_MESSAGE);
        String line = Console.readLine();
        moneyVerifier.check(line);

        return Integer.parseInt(line);
    }

    public static List<Integer> readWinningNumber() {
        OutputView.printIOMessage(IOMessage.READ_WINNING_NUM_MESSAGE);
        String line = Console.readLine();
        lottoVerifier.check(line);

        return Arrays.stream(line.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int readBonusNumber() {
        OutputView.printIOMessage(IOMessage.READ_BONUS_NUM_MESSAGE);
        String line = Console.readLine();
        bonusNumberVerifier.check(line);
        
        return Integer.parseInt(line);
    }
}
