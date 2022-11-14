package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

/**
 * 도메인에 관한 출력 UI
 */
public class OutputUi {

    /**
     * 사용자에게 로또 구입금액을 입력해 달라는 문구 출력
     */
    public void printBuyAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    /**
     * 로또 수량과 로또 번호 출력 하기
     */
    public void printLottoAmountAndNumber(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (Lotto lottery : lotteries) {
            System.out.println(lottery.toString());
        }
    }
}
