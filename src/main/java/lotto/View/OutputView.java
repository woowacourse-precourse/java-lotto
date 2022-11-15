package lotto.View;

import lotto.Domain.LottoPublisher;

import java.util.List;

public class OutputView {

    LottoPublisher lottoPublisher;

    public void printTheNumberOfLotto(int theNumberOfLotto) {
        System.out.println(String.format("%d개를 구매했습니다.", theNumberOfLotto));
    }

    public void printLottoNumber(List<List<Integer>> userInputLottoNumberList) {
        for (List<Integer> column : userInputLottoNumberList) {
            System.out.println(column);
        }
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
