package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.Reward;
import lotto.model.WinningRecord;
import lotto.view.CommonView;
import lotto.view.PublishView;
import lotto.view.RecordView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LottoController {
    private final LottoMachine lottoMachine;
    private List<Lotto> lottos;
    private List<Integer> answer;
    private int bonus;

    public LottoController() {
        this.lottoMachine = new LottoMachine();
    }

    private void buyLotto() {
        CommonView.printInputMoneyMessage();
        String money = readLineWithoutWhiteSpace();
        validateNumberInput(money);
        lottos = lottoMachine.publish(Integer.parseInt(money));
    }

    private void getLottoInformation() {
        PublishView.printPublishInformation(lottos);
    }

    private void setLuckyNumber() {
        lottoMachine.setLuckyNumber(answer, bonus);
    }

    private void setAnswer() {
        CommonView.printInputAnswerMessage();
        String answerInput = readLineWithoutWhiteSpace();
        validateAnswerInput(answerInput);
        answer = makeAnswerInputIntoList(answerInput);
    }

    private void setBonus() {
        CommonView.printInputBonusMessage();
        String bonusInput = readLineWithoutWhiteSpace();
        validateNumberInput(bonusInput);
        bonus = Integer.parseInt(bonusInput);
    }

    private void getResult() {
        WinningRecord winningRecord = lottoMachine.drawAll(lottos);
        RecordView.printWinningRecord(winningRecord, Reward.values());
        RecordView.printYield(winningRecord);
    }

    private List<Integer> makeAnswerInputIntoList(String answerInput) {
        List<Integer> answer = new ArrayList<>();
        Arrays.stream(answerInput.split(","))
                .mapToInt(Integer::parseInt)
                .forEach(answer::add);
        return answer;
    }

    private void validateAnswerInput(String input) {
        try {
            for (String target : input.split(",")) {
                Integer.parseInt(target);
            }
        } catch (Exception err) {
            throw new IllegalArgumentException("콤마(,)를 이용해 6개의 숫자를 입력해주세요.");
        }
    }

    private void validateNumberInput(String input) {
        if (!input.matches("^[0-9]*$")) {
            throw new IllegalArgumentException("숫자만 입력하실 수 있습니다.");
        }
    }

    private String readLineWithoutWhiteSpace() {
        return Console.readLine().replace(" ", "");
    }

    public void play() {
        try {
            buyLotto();
            getLottoInformation();
            setAnswer();
            setBonus();
            setLuckyNumber();
            getResult();
        } catch (Exception err) {
            CommonView.printExceptionMessage(err);
        }
    }
}
