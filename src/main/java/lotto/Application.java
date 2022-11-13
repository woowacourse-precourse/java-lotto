package lotto;

import lotto.view.input.UserInput;
import lotto.view.output.Guide;

public class Application {
    static Guide guide = new Guide();
    static UserInput userInput = new UserInput();

    public static void main(String[] args) {
        // 금액 입력 문장 출력
        guide.printInputPriceGuide();
        // 사용자 입력 -> 로또 개수 반환
        long lottoCount = userInput.getLottoCount();

        // 사용자 로또 개수 출력
        guide.printLottoCount(lottoCount);
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
