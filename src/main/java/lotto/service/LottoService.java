package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.view.View;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoService {

    private static final String WINNING_INPUT_MESSAGE = "정확히 숫자를 입력하고 `,`로 구분 지을 수 있습니다.";
    private static final String BONUS_INPUT_MESSAGE = "보너스 번호는 숫자만 입력할 수 있습니다.";
    public NumberGenerator numberGenerator;
    private WinningTicket winningTicket;
    
    public LottoService() {
        this.numberGenerator = new NumberGenerator();
    }

    public Lottos publishLotto(String input) {
        List<Lotto> result = IntStream.range(0, new Money(input).getLottoCount())
                .mapToObj(i -> new Lotto(this.numberGenerator.createDuplicateNumbers()))
                .collect(Collectors.toList());

        return new Lottos(result);
    }

    public void getLottosByMoney(Buyer buyer, String input) {
        buyer.buyLottos(publishLotto(input));
    }

    public void publishWinningNumbersWithBonusNumber(View view) throws IllegalArgumentException {
        this.winningTicket = new WinningTicket(inputWinningNumbers(view), inputBonusNumber(view));
        System.out.println(this.winningTicket.getWinnings());
        System.out.println(this.winningTicket.getBonusNumber());
    }

    public List<Integer> inputWinningNumbers(View view) throws IllegalArgumentException {
        try {
            view.printInputWinningMessage();
            return Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            throw new IllegalArgumentException(WINNING_INPUT_MESSAGE);
        }
    }

    public int inputBonusNumber(View view) throws IllegalArgumentException {
        try {
            view.printInputBonusMessage();
            return Integer.parseInt(Console.readLine());
        } catch (Exception e) {
            throw new IllegalArgumentException(BONUS_INPUT_MESSAGE);
        }
    }
}
