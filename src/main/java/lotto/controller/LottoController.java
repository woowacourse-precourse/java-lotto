package lotto.controller;

import lotto.service.LottoService;

public class LottoController {

    private static LottoService lottoService;

    public LottoController(){
        lottoService = new LottoService();
    }

    public void run(){
        //input price

        //print guess number

        //input Lotto number

        //input bonus number

        //print statistics
    }

    private String inputPrice(){
        System.out.println(LottoControllerString.INPUT_PURCHASE_PRICE);
        return "ok";
    }

    private void printGuessNumber(){

    }
    private String inputLottoNumber(){
        return "ok";
    }
    private String inputBonusNumber(){
        return "ok";
    }
    private void statistics(){

    }
}
