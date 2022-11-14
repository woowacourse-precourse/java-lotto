package lotto;


import lotto.LottoManager.LottoDrawingMachine;
import lotto.LottoShop.Consumer;
import lotto.LottoShop.LottoShop;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final List<Consumer> consumers = new ArrayList<>();

    public static void main(String[] args) {
        LottoShop lottoShop = LottoShop.getInstance();

        Consumer new_consumer = lottoShop.takeOneConsumer();
        consumers.add(new_consumer);

//        추첨
        LottoDrawingMachine lottoDrawingMachine = new LottoDrawingMachine();

//        당첨 확인
        consumers.forEach(consumer ->
                consumer.checkPrize(
                        lottoDrawingMachine.getWinning_numbers(), lottoDrawingMachine.getBonus_number()
                ));
    }

}
