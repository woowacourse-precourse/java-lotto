package lotto.domain;

import lotto.view.ErrorMessage;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public long validMoney(long money)throws IllegalArgumentException{
        if(money < 1000)
            throw new IllegalArgumentException(ErrorMessage.LESS_COAST.getErrorMessage());
        if(money % 1000 != 0)
            throw new IllegalArgumentException(ErrorMessage.NOT_COAST.getErrorMessage());
        return money;
    }
    public void containOthers(String input)throws IllegalArgumentException{
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT.getErrorMessage());
        }
    }
    public void validateUserInput(String input)throws IllegalArgumentException{
        String [] checkInput = input.split(",");
        for (String num : checkInput) {
            containOthers(num);
        }
    }
    public void validateBonusNumber(List<Integer> winningNumber, String userInput)throws IllegalArgumentException{
        containOthers(userInput);
        int bonusNumber = Integer.parseInt(userInput);
        correctNumberRange(bonusNumber);
        if(winningNumber.contains(bonusNumber))
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_WINNING_NUMBER.getErrorMessage());
    }
    public void validUserWinningNumber(List<Integer> winningNumber)throws IllegalArgumentException{
        Set<Integer> duplicatedNumber = new HashSet<>(winningNumber);
        if (duplicatedNumber.size() != winningNumber.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_NUMBER.getErrorMessage());
        }
        for (Integer lottoNumber : winningNumber) {
            correctNumberRange(lottoNumber);
        }
    }
    public void correctNumberRange(int number)throws IllegalArgumentException{
        if(number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER_RANGE.getErrorMessage());
            }
        }
}
