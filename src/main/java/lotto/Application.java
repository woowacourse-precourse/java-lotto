package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static List<Integer> winningNumbers = new ArrayList<>();

    public static void main(String[] args) {

        // 구입금액 입력받고 개수 출력
        LottoInput.inputNumber();
        LottoInput.theNumberOfLotto();

        //구입한 만큼 로또 생성
        LottoGenerator.myLottoNumber();

        //1등 번호 입력
        Lotto winnerLotto = new Lotto(winningNumbers);
        winnerLotto.inputLotto(winningNumbers);

        // 보너스 번호 입력
        Lotto.bonusNum();

        //당첨번호와 비교하기
        CompareLotto.compareLotto();
        CompareLotto.printCompareLotto();
        CompareLotto.printRateOfReturn();
    }

}
