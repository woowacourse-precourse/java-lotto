package lotto;

import lotto.model.LottoGroup;
import lotto.view.input.LottosGenerator;
import lotto.view.input.UserInput;
import lotto.view.output.Guide;

public class Application {
    static Guide guide = new Guide();
    static UserInput userInput = new UserInput();
    static LottosGenerator generator = new LottosGenerator();

    public static void main(String[] args) {
        guide.printInputPriceGuide();
        int lottoCount = userInput.getLottoCount();

        guide.printLottoCount(lottoCount);
        LottoGroup lottoGroup = new LottoGroup(generator.generateLottos(lottoCount));
        // 사용자 로또 번호 출력

        // 당첨번호 입력 문장 출력
        guide.printInputLottoGuide();
        // 당첨번호 입력

        // 보너스 번호 입력문장
        guide.printInputBonusGuide();
        // 보너스 번호 입력 받음

        // 결과 출력
    }
}
