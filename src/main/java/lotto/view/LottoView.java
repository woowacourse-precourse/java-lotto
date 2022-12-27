package lotto.view;

import lotto.domain.Lotto;
import lotto.util.OutputMessage;
import lotto.util.ResultMessage;

import java.util.Comparator;
import java.util.List;

public class LottoView {
    // UI를 담당하는 로직

    // 로또 금액 입력 요청
    public static void inputLottoAmount() {
        System.out.println(OutputMessage.INPUT_AMOUNT.printMessage());
    }

    // 로또 구매 수량 출력
    public static void printLottoCount(int count) {
        System.out.println();
        System.out.printf(ResultMessage.LOTTO_COUNT.printMessage(), count);
    }

    // 로또 발행 리스트 출력
    public static void printLottoNumbers(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            lottoNumbers.sort(Comparator.naturalOrder());
            System.out.println(lottoNumbers);
        }
    }

    // 당첨 번호 입력 요청
    public static void inputLottoNumber() {
        System.out.println();
        System.out.println(OutputMessage.INPUT_LOTTO_NUMBER.printMessage());
    }

    // 보너스 번호 입력 요청
    public static void inputBonusNumber() {
        System.out.println();
        System.out.println(OutputMessage.INPUT_BONUS_NUMBER.printMessage());
    }
    
    // 당첨 통계 출력

}
