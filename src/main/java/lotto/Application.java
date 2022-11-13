package lotto;

import lotto.model.Lotto;
import lotto.model.LottoGroup;
import lotto.view.input.Generator;
import lotto.view.input.UserInput;
import lotto.view.output.Guide;

public class Application {
    static Guide guide = new Guide();
    static UserInput userInput = new UserInput();
    static Generator generator = new Generator();

    public static void main(String[] args) {
        guide.printInputPriceGuide();
        int lottoCount = userInput.getLottoCount();

        guide.printLottoCount(lottoCount);
        LottoGroup lottoGroup = new LottoGroup(
                generator.generateLottos(lottoCount));
        guide.printLottoGroup(lottoGroup);

        guide.printInputWinningNumberGuide();
        Lotto winningNumber = new Lotto(userInput.getWinningNumber());

        guide.printInputBonusGuide();
        // 보너스 번호 입력 받음

        // 결과 출력
    }
}
