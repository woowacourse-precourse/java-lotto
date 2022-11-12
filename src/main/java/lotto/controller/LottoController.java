package lotto.controller;

import lotto.domain.Validator;
import lotto.view.View;

public class LottoController {
    private static final View view = new View();
    private static final Validator  validator= new Validator();
    public void lottoGame(){
        String input = view.startLottoView();
        try{
        validator.validateInputAmount(input);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }
    }

}
