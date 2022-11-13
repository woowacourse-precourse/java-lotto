package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.CommonView;
import lotto.view.PublishView;

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
        } catch (Exception err) {
            CommonView.printExceptionMessage(err);
        }
    }

    private void buyLotto() {
        CommonView.printInputMoneyMessage();
        String input = Console.readLine().replace(" ", "");
        validateNumberInput(input);
        lottos = lottoMachine.publish(Integer.parseInt(input));
        PublishView.printPublishInformation(lottos);
    }

    private void setAnswer() {

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
