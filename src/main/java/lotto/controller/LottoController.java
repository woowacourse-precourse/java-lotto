package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoString;
import lotto.domain.Lotto;
import lotto.global.ErrorMessage;
import lotto.service.LottoService;

import java.util.ArrayList;
import java.util.List;


public class LottoController {

    private static LottoService lottoService;

    public LottoController(){
        lottoService = new LottoService();
    }

    public void run(){
        //input price
        Integer price = inputPrice();

        //print guess number
        List<Lotto> guessNumberSet = printGuessNumber(price);

        //input Lotto number
        List<Integer> lottoNumber = inputLottoNumber();

        //input bonus number

        //print statistics
    }

    private Integer inputPrice(){
        System.out.println(LottoString.INPUT_PURCHASE_PRICE);
        String userInput = Console.readLine();
        int price = 0;
        try {
            price = lottoService.validePrice(userInput);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }
        return price;
    }

    private List<Lotto> printGuessNumber(int price){
        try {
            List<Lotto> guessSet = makeNumbers(price);
            guessSet.stream().map(Object::toString).forEach(System.out::println);
            return guessSet;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            throw e;
        }catch (Exception e){
            System.out.println(ErrorMessage.SERVER_INTERNAL_ERROR);
            throw e;
        }
    }

    private static List<Lotto> makeNumbers(int price) {
        List<Lotto> guessNumber = new ArrayList<>();
        while(price > 0){
            Lotto lotto = new Lotto(lottoService.makeRandomNumber());
            guessNumber.add(lotto);
            price -= 1000;
        }
        return guessNumber;
    }

    private List<Integer> inputLottoNumber(){
        System.out.println(LottoString.INPUT_LOTTO_NUMBRES);
        String userInput = Console.readLine();

        lottoService.validateUserInput(userInput);

        List<Integer> numbers = new ArrayList<>();

        return numbers;
    }


    private String inputBonusNumber(){
        return "ok";
    }
    private void statistics(){

    }
}
