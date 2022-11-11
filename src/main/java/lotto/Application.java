package lotto;

import lotto.controller.LottoController;

import static lotto.constant.MessageConstant.ERROR;

public class Application {
    public static void main(String[] args) {
        LottoController lottoController = LottoController.create();
        try{
            lottoController.run();
        } catch (Exception e){
            System.out.println(ERROR + e.getMessage());
        }
    }
}