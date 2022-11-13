package lotto;

import lotto.domain.LottoGroup;
import lotto.domain.WinningNumber;
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
        WinningNumber winningNumber = new WinningNumber(userInput.getWinningNumber());

        guide.printInputBonusGuide();
        winningNumber.updateBonus(userInput.getBonusNumber());

        // 결과 출력
    }
}
