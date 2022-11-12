package lotto;


import lotto.LottoManager.LottoDrawingMachine;
import lotto.LottoShop.LottoShop;

public class Application {
    public static void main(String[] args) {
        LottoShop lottoShop = LottoShop.getInstance();

        lottoShop.takeOneConsumer();

//        추첨
//        LottoDrawingMachine.drawLottoNumbers();

//        당첨 확인
    }

}
