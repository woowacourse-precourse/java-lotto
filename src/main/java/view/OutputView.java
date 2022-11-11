package view;

import model.Lotto;
import java.util.List;

import static model.NoticeMessage.LOTTO_COUNT;

public class OutputView {

    public void outputLotto(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + LOTTO_COUNT.toString());
        for (Lotto lottery : lotteries) {
            System.out.println(lottery.getNumbers());
        }
        System.out.println();
    }

}
