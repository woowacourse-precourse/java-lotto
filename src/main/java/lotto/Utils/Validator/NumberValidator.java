package lotto.Utils.Validator;

import lotto.View.OutputView;

import java.util.List;

public class NumberValidator {
    public static void isBonusOverlap(List<Integer>lotto, int bonusNumber){
        if(lotto.contains(bonusNumber)){
            OutputView.errorMessage("보너스 번호가 중복됩니다.");
            throw new IllegalArgumentException();
        }
    }
}
