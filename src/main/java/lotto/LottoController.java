package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.CommonView;
import lotto.view.PublishView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine;
    private List<Lotto> lottos;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    public void play() {
        try {
            buyLotto();
            setAnswer();

        } catch (Exception err) {
            CommonView.printExceptionMessage(err);
        }
    }

    private void buyLotto() {
        CommonView.printInputMoneyMessage();
        String money = Console.readLine().replace(" ", "");
        validateNumberInput(money);
        lottos = lottoMachine.publish(Integer.parseInt(money));
        PublishView.printPublishInformation(lottos);
    }

    private void setAnswer() {
        CommonView.printInputAnswerMessage();
        String answerInput = Console.readLine().replace(" ", "");
        validateAnswerInput(answerInput);

        CommonView.printInputBonusMessage();
        String bonusInput = Console.readLine().replace(" ", "");
        validateNumberInput(bonusInput);

        int bonus = Integer.parseInt(bonusInput);
        lottoMachine.setLuckyNumber(makeAnswerIntoList(answerInput), bonus);
    }

    private List<Integer> makeAnswerIntoList(String answer) {
        List<Integer> ilist = new ArrayList<>();
        Arrays.stream(answer.split(",")).mapToInt(Integer::parseInt).forEach(ilist::add);
        return ilist;
    }

    private void getResult() {

    }

    private void validateAnswerInput(String input) {
        try {
            for (String str : input.split(",")) {
                Integer.parseInt(str);
            }
        } catch (Exception err) {
            throw new IllegalArgumentException("콤마(,)를 이용해 6개의 숫자를 입력해주세요.");
        }
    }

    private void validateNumberInput(String input) {
        if (!input.matches("^[0-9]*$")) throw new IllegalArgumentException("숫자만 입력하실 수 있습니다.");
    }
}
