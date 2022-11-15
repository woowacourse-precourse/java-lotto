package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import static lotto.util.Message.*;
import lotto.domain.*;
import lotto.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class LottoService {

    private final NumberGenerator numberGenerator;
    private WinningTicket winningTicket;
    
    public LottoService() {
        numberGenerator = new NumberGenerator();
    }

    public Lottos publishLotto(long lottoCount) {
        List<Lotto> result = LongStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(numberGenerator.createDuplicateNumbers()))
                .collect(Collectors.toList());

        return new Lottos(result);
    }

    public void getLottosByMoney(Buyer buyer) throws IllegalArgumentException {
        Money money = new Money(buyer.inputMoney());
        buyer.setMoney(money);
        buyer.buyLottos(publishLotto(buyer.getLottoCount()));
    }

    public void publishWinningNumbersWithBonusNumber(View view) throws IllegalArgumentException {
        winningTicket = new WinningTicket(inputWinningNumbers(view), inputBonusNumber(view));
    }

    public List<Integer> inputWinningNumbers(View view) throws IllegalArgumentException {
        view.printInputWinningMessage();
        return separateInputWinningNumbers(Console.readLine());
    }

    public List<Integer> separateInputWinningNumbers(String input) throws IllegalArgumentException {
        try {
            return Arrays.stream(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(WINNING_INPUT_MESSAGE.getValue());
        }
    }

    public int inputBonusNumber(View view) throws IllegalArgumentException {
        try {
            view.printInputBonusMessage();
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(BONUS_INPUT_MESSAGE.getValue());
        }
    }

    public void getWinningStatics(Buyer buyer, Rank rank) {
        buyer.getLottos().forEach((lotto) ->
                rank.setCount(lotto.countWinningNumbers(winningTicket.getWinnings()),
                        lotto.isExistWinningNumber(winningTicket.getBonusNumber())));
    }
}
