package lotto.view;

import java.util.List;
import java.util.StringJoiner;

public class OutputView {

    public void announceInputMoney() {
    }

    public void announceBuyResult(int lottoCount) {

    }

    public void announceInputBonusNumber() {

    }

    public void announceResult() {

    }

    public void printBoughtLotto(List<List<Integer>> boughtLottos) {
        for (List<Integer> lotto : boughtLottos) {
            printLottoNumbersInFormat(lotto);
        }
    }

    private void printLottoNumbersInFormat(List<Integer> numbers) {
        String delimiter = ", ";
        StringJoiner joiner = new StringJoiner(delimiter);
        numbers.forEach(item -> joiner.add(String.valueOf(item)));
        System.out.print("[");
        System.out.print(joiner);
        System.out.println("]");
    }

    public void printDivider() {

    }

    public void printSpacer() {

    }
}
