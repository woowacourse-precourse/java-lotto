package lotto;

import lotto.controller.LottoController;
public class Application {
    public static void main(String[] args) {
       LottoController lottoController = new LottoController();
       try {
           lottoController.startLotto();
       }
       catch (IllegalArgumentException error){
           System.out.println(error.getMessage());
       }
    }
}
