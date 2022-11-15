package lotto.domain;

import lotto.exception.ErrorHandler;
import lotto.view.InputLotto;
import lotto.view.InputPrintView;

import java.util.List;

public class LottoBonusNumber {
    private int bonusNumber;
    public LottoBonusNumber(Game game){
        InputPrintView.inputView_Second();
        List<Integer> bonusInput = InputLotto.getInput();
        isBonusJustOne(bonusInput);
        bonusNumber = bonusInput.get(0);
        isBonusUnique(game.getAwardLotto());
        isBonusCorrect();
    }
    private void isBonusJustOne(List<Integer> bonusInput){
        if(bonusInput.size()!=1){
            ErrorHandler.bonusSizeOverException();
        }
    }
    private void isBonusUnique(Lotto awardLotto){
        if(awardLotto.getNumbers().contains(bonusNumber)){
            ErrorHandler.mutualInputException();
        }
    }
    private void isBonusCorrect(){
        if(bonusNumber<1 || bonusNumber>45){
            ErrorHandler.numberUnCorrectException();
        }
    }
    public int getBonusNumber(){
        return bonusNumber;
    }
}
