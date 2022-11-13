package lotto.Output;

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
        PrintOutput.BUY.printMessage(publishLottosNum);
        for(Set<Integer> lotto : publishedLottos) {
            System.out.println(lotto);
        }
    }
}
