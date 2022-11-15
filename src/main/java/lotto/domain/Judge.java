package lotto.domain;

import lotto.Enum.Errors;
import lotto.Lotto;

import java.util.List;

public class Judge {

    public void correctAmount(String amount) {
        if(Integer.parseInt(amount) % 1000 != 0){
            throw new IllegalArgumentException(Errors.NOT_CORRECT_AMOUNT.getName());
        }
    }
    public void amountIsNaturalNumber(String amount) {
        if(Integer.parseInt(amount) <= 0) {
            throw new IllegalArgumentException(Errors.IS_NATURAL_NUMBER.getName());
        }
    }
    public void amountIsValid(String amount) {
        isNumber(amount);
        correctAmount(amount);
        amountIsNaturalNumber(amount);
    }
    public int containCount(List<Integer> lotto, List<Integer> winningNumbers) {
        int contained = 0;
        for (int i = 0; i < lotto.size(); i++) {
            if(!winningNumbers.contains(lotto.get(i))) {
                continue;
            }
            contained++;
        }
        return contained;
    }

    public void isNumber(String num) {
        try{
            Integer.parseInt(num);
        } catch(Exception e) {
            throw new IllegalArgumentException(Errors.NOT_CORRECT_INPUT.getName());
        }
    }

    public void isAllNumber(String numbers) {
        String[] num = numbers.split(",");
        for(String n : num) {
            isNumber(n);
        }
    }

    public void isNotContain(Lotto lotto, int bonus) {
        if(lotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException(Errors.BONUS_NUMBER_NOT_UNIQUE.getName());
        }
    }
}
