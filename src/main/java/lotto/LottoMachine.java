package lotto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.engine.LottoGenerator;
import lotto.io.Input;
import lotto.io.Output;
import lotto.model.Lotto;
import lotto.model.LottoWallet;
import lotto.model.Winning;
import lotto.model.WinningInformation;
import lotto.model.WinningNumber;

public class LottoMachine implements Runnable {
    private final Input input;
    private final Output output;
    private final LottoGenerator lottoGenerator;

    public LottoMachine(Input input, Output output, LottoGenerator lottoGenerator) {
        this.input = input;
        this.output = output;
        this.lottoGenerator = lottoGenerator;
    }

    @Override
    public void run() {
        try {
            int count = getCount();

            LottoWallet wallet = new LottoWallet(lottoGenerator.createLottos(count));
            output.printLottos(count, wallet.getLottos());

            WinningNumber winningNumber = getWinningNumber();
            WinningInformation winningInformation = getWinningInformation(wallet, winningNumber);

            output.printResult(winningInformation.getWinningCounts(), winningInformation.getYield(count));
        } catch (RuntimeException exception) {
            output.printError(exception);
        }
    }

    private WinningInformation getWinningInformation(LottoWallet wallet, WinningNumber winningNumber) {
        List<Lotto> lottos = wallet.getLottos();

        List<Winning> winnings = lottos.stream()
                .map(winningNumber::compareToWinningNumber)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        return new WinningInformation(winnings);
    }

    private int getCount() {
        output.printPurchasePrompt();
        String purchasePrice = input.getUserInput();
        return lottoGenerator.parseToLottoCount(purchasePrice);
    }

    private WinningNumber getWinningNumber() {
        output.printWinningNumberPrompt();
        String userInputWinningNumber = input.getUserInput();
        output.printBonusNumberPrompt();
        String userInputBonusNumber = input.getUserInput();

        return WinningNumber.of(userInputWinningNumber, userInputBonusNumber);
    }
}
