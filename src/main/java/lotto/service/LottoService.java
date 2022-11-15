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

    public NumberGenerator numberGenerator;
    private WinningTicket winningTicket;
    
    public LottoService() {
        this.numberGenerator = new NumberGenerator();
    }

    public Lottos publishLotto(long lottoCount) {
        List<Lotto> result = LongStream.range(0, lottoCount)
                .mapToObj(i -> new Lotto(this.numberGenerator.createDuplicateNumbers()))
                .collect(Collectors.toList());

        return new Lottos(result);
    }

    public void getLottosByMoney(Buyer buyer) throws IllegalArgumentException {
        Money money = new Money(buyer.inputMoney());
        buyer.setMoney(money);
        buyer.buyLottos(publishLotto(buyer.getLottoCount()));
    }

    public void publishWinningNumbersWithBonusNumber(View view) throws IllegalArgumentException {
        this.winningTicket = new WinningTicket(inputWinningNumbers(view), inputBonusNumber(view));
    }

    public List<Integer> inputWinningNumbers(View view) throws IllegalArgumentException {
        try {
            view.printInputWinningMessage();
            return Arrays.stream(Console.readLine().split(","))
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
                rank.setCount(lotto.countWinningNumbers(this.winningTicket.getWinnings()),
                        lotto.isExistWinningNumber(this.winningTicket.getBonusNumber())));
    }
}
