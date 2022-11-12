package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.service.LottoService;
import org.junit.platform.commons.util.StringUtils;

import java.util.stream.IntStream;


public class LottoController {

    private static LottoService lottoService;

    public LottoController(){
        lottoService = new LottoService();
    }

    public void run(){
        //input price
        inputPrice();

        //print guess number

        //input Lotto number

        //input bonus number

        //print statistics
    }

    private Integer inputPrice(){
        System.out.println(LottoControllerString.INPUT_PURCHASE_PRICE);
        String userInput = Console.readLine();
        int price = 0;
        try {
            price = validePrice(userInput);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
        return price;
    }

    private int validePrice(String price) {
        IntStream.range(0, price.length()).filter(
            i -> !Character.isDigit(price.charAt(i))).forEach(i -> {
            throw new IllegalArgumentException(LottoControllerString.UNMATCH_PRICE_UNIT);
        });
        int priceInt = Integer.parseInt(price);
        if(priceInt % 1000 != 0){
            throw new IllegalArgumentException(LottoControllerString.UNMATCH_PRICE_UNIT);
        }
        return priceInt;
    }

    public int doValidatePrice(String price){
        return validePrice(price);
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
