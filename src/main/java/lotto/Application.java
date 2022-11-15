package lotto;

import lotto.LottoManagement.LottoDrawingMachine;
import lotto.LottoShop.Consumer;
import lotto.LottoShop.LottoShop;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final List<Consumer> consumers = new ArrayList<>();

    public static void main(String[] args) {
        try {
            LottoShop lottoShop = LottoShop.getInstance();

            Consumer new_consumer = lottoShop.takeOneConsumer();
            consumers.add(new_consumer);

//        추첨
            LottoDrawingMachine.drawLotto();

//        당첨 확인
            new_consumer.checkPrize();

        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }

}
