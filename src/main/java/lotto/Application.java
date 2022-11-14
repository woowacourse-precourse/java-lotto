package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        AboutInputOutput io = new AboutInputOutput();

        // 구매액 입력
        System.out.println(io.PLEASE_ENTER_MONEY);
        int money = io.inputMoney();

        // 구매할 로또 수 계산 후 안내문구 출력
        BuyLotto buyLotto = new BuyLotto(money);
        io.outputLottoCount(buyLotto.lottoCount);

        // 구매한 로또 목록 리스트 생성
        List<List<Integer>> lottoSet = buyLotto.getLottoSet(buyLotto.lottoCount);

        // 응모 로또 출력
        io.printLottoSet(lottoSet);

        // 당첨번호 입력
        System.out.println(io.PLEASE_ENTER_NUMBERS);
        List<Integer> inputNumbers = io.inputNumbers();

        // 당첨번호를 Lotto 클래스에 입력 + 검증
        new Lotto(inputNumbers);

        // 보너스 번호 입력
        System.out.println(io.PLEASE_ENTER_BONUS_NUMBER);
        io.inputBonusNumber(inputNumbers);

        // 응모한 로또들과 정답 로또를 비교하여 몇 등을 몇 번 했는지에 대한 결과를 리스트로 반환
        Calculator calculator = new Calculator(lottoSet, inputNumbers);
        List<Integer> result = calculator.getResult();

        // 결과 리스트에 따른 문구 출력
        io.printResult(result);

        // 수익률 계산
        io.printRateOfReturn(calculator.getRateOfReturn(money, result));
    }
}
