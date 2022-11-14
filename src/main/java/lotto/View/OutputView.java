package lotto.View;

import lotto.Domain.LottoPublisher;

public class OutputView {

    LottoPublisher lottoPublisher;

    public void printTheNumberOfLotto(int theNumberOfLotto) {
        System.out.println(String.format("%d개를 구매했습니다.", theNumberOfLotto));
    }

    public void printLottoNumber(int theNumberOfLotto) {
        for (int i = 0; i < theNumberOfLotto; i++) {
            System.out.println(lottoPublisher.makeRandomLottoNumber());
        }
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
