package lotto.Output.MainValue;

import java.util.List;
import java.util.Set;

public class PublishedLottoOutput {
    private final List<Set<Integer>> publishedLottos;
    private final int publishLottosNum;

    public PublishedLottoOutput(List<Set<Integer>> publishedLottos, int publishLottosNum){
        this.publishedLottos = publishedLottos;
        this.publishLottosNum = publishLottosNum;
    }

    public void printPublishedLotto() {
        System.out.printf(PrintOutput.BUY.message(),publishLottosNum);
        for(Set<Integer> lotto : publishedLottos) {
            System.out.println(lotto);
        }
    }
}
