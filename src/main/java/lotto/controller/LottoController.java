package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoString;
import lotto.WinningStatus;
import lotto.domain.Lotto;
import lotto.dto.LottoAndUserNumberDto;
import lotto.dto.LottoMatchDto;
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
        try {
            Integer purchaseCost = inputPrice();

            //print guess number
            List<Lotto> guessNumberSet = printGuessNumber(purchaseCost);

            //input Lotto number
            List<Integer> lottoNumber = inputLottoNumber();

            //input bonus number
            Integer bonusNumber = inputBonusNumber();

            //print statistics
            statistics(guessNumberSet, lottoNumber, bonusNumber, purchaseCost);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    private Integer inputPrice(){
        System.out.println(LottoString.INPUT_PURCHASE_PRICE);
        String userInput = Console.readLine();

        Integer price = lottoService.validePrice(userInput);

        System.out.println(LottoString.purchaseMessage(price));
        return price;
    }

    private List<Lotto> printGuessNumber(Integer price){
        List<Lotto> guessSet = makeNumbers(price);
        for (Lotto lotto : guessSet) {
            System.out.println(lotto);
        }
        return guessSet;
    }

    private List<Lotto> makeNumbers(Integer price) {
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

        return lottoService.validateUserInput(userInput);
    }


    private Integer inputBonusNumber() throws Exception {
        System.out.println(LottoString.INPUT_BONUS_NUMBER);
        String userInput = Console.readLine();

        return lottoService.validateBonusNumber(userInput);
    }
    private void statistics(List<Lotto> guessNumberSet, List<Integer> lottoNumber, 
                            Integer bonusNumber, Integer purchaseCost) {
        System.out.println(LottoString.WINNING_STATISTICS);
        LottoMatchDto lottoMatchDto = getWinningRate(guessNumberSet, lottoNumber,
                                                    bonusNumber, purchaseCost);

        printMatchGrade(lottoMatchDto.getWinningCount());

        System.out.println(LottoString.winningRateMessage(lottoMatchDto.getWinningRate()));
    }

    private void printMatchGrade(List<Integer> winningCount) {
        Integer sixMatch = winningCount.get(1);
        Integer fiveAndBonusMatch = winningCount.get(2);
        Integer fiveMatch = winningCount.get(3);
        Integer fourMatch = winningCount.get(4);
        Integer threeMatch = winningCount.get(5);

        String matching = LottoString.winningStatistic(threeMatch, fourMatch, fiveMatch,
                fiveAndBonusMatch, sixMatch);
        System.out.println(matching);
    }

    private LottoMatchDto getWinningRate(List<Lotto> guessNumberSet, List<Integer> lottoNumber,
                                  Integer bonusNumber, Integer purchaseCost) {
        LottoAndUserNumberDto lottoAndUserNumberDto =
                new LottoAndUserNumberDto(guessNumberSet, lottoNumber, bonusNumber, purchaseCost);
        LottoMatchDto lottoMatchDto = lottoService.getStatistic(lottoAndUserNumberDto);
        return lottoMatchDto;
    }
}
