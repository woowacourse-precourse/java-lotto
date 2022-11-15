package lotto.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.utils.Constant;
import lotto.view.InputView;

public class InputController {
    private static final int COUNT_END = 0;
    private static final List<Integer> LOTTO_ANSWER_END = new ArrayList<Integer>();
    private static final int BONUS_END = 0;
    private int checkTicketAmount(){
        int amount;
        String countInput = InputView.getTicketCount();
        try {
            Validator.isNumber(countInput);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return COUNT_END;
        }
        amount = Integer.parseInt(countInput);
        return amount;
    }
    public int checkTicketCount(){
        int count;
        int amount = checkTicketAmount();
        try {
            Validator.checkAmount(amount);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return COUNT_END;
        }
        count = amount / Constant.PURCHASE_UNIT;
        return count;
    }
    public List<Integer> checkLottoNumbers(){
        List <Integer> lottoNumber = checkLottoNumbersValid(checkLottoNumbersDigit());
        return lottoNumber;
    }

    public int checkBonus(Lotto lotto){
        int bonusNumber = checkBonusNumberValid(lotto, checkBonusNumberDigit());
        return bonusNumber;
    }

    private int checkBonusNumberValid(Lotto lotto, int bonusNumber){
        Bonus bonus;
        try{
            bonus = new Bonus(bonusNumber, lotto);
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return BONUS_END;
        }
        return bonusNumber;
    }
    private int checkBonusNumberDigit(){
        String bonusInput = InputView.getBonusNumbers();
        int bonusNumber;
        try{
            Validator.isNumber(bonusInput);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return BONUS_END;
        }
        return (Integer.parseInt(bonusInput));
    }
    private List<Integer> checkLottoNumbersValid(List<Integer> lottoNumber){
        Lotto lotto;
        try {
            lotto = new Lotto(lottoNumber);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return LOTTO_ANSWER_END;
        }
        return lottoNumber;
    }
    private List<Integer> checkLottoNumbersDigit(){
        String[] lottoInput = InputView.getLottoNumbers();
        List<Integer> lottoNumber = new ArrayList<Integer>();
        for (String ticketInput : lottoInput){
            try{
                Validator.isNumber(ticketInput);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return LOTTO_ANSWER_END;
            }
        }
        Arrays.asList(lottoInput).stream().forEach((item) -> lottoNumber.add(Integer.parseInt(item)));
        return lottoNumber;
    }
}
