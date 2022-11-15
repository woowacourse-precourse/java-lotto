package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.validator.PaymentValidator;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.Winning;
import lotto.logic.Exchanger;
import lotto.logic.LottoMachine;
import lotto.logic.LottoService;
import lotto.view.View;

public class Game {

    private final LottoMachine lottoMachine;
    private final LottoService lottoService;
    private final Exchanger exchanger;
    private final View view;

    public Game(LottoMachine lottoMachine, LottoService lottoService, Exchanger exchanger, View view) {
        this.lottoService = lottoService;
        this.lottoMachine = lottoMachine;
        this.exchanger = exchanger;
        this.view = view;
    }

    public void play() throws IllegalArgumentException {
        long payment = inputPayment();
        List<Lotto> lottos = createLottos(payment);
        Winning target = inputTargetNumbers();
        outputResult(payment, lottos, target);
    }

    private long inputPayment() throws IllegalArgumentException {
        view.printStart();
        String payment = Console.readLine();
        PaymentValidator.validateNumberFormat(payment);
        return Long.parseLong(payment);
    }

    private List<Lotto> createLottos(long payment) throws IllegalArgumentException {
        List<Lotto> lottos = lottoMachine.generateLottos(payment);
        view.printStartFeedback(lottos);
        return lottos;
    }

    private Winning inputTargetNumbers() throws IllegalArgumentException {
        view.printWinningNumbersInputRequest();
        String[] inputNumbers = Console.readLine()
                                       .replace(" ", "")
                                       .split(",");

        List<Integer> numbers = Arrays.stream(inputNumbers)
                                      .map(Integer::parseInt)
                                      .distinct()
                                      .collect(Collectors.toList());

        view.printBonusNumberInputRequest();
        int bonusNumber = Integer.parseInt(Console.readLine());

        return new Winning(numbers, bonusNumber);
    }

    private void outputResult(long payment, List<Lotto> lottos, Winning target) {
        Map<Rank, Integer> countOfWinning = lottoService.getResult(lottos, target);
        double profitRate = exchanger.calculateProfitRate(countOfWinning, payment);
        view.printWinningResult(countOfWinning, profitRate);
    }

}
