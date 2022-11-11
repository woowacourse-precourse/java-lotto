package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validate {
    public long isValidMoney(long money)throws IllegalArgumentException{
        if(money < 1000)
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력하세요.");
        if(money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 유효한 값을 입력하세요.");
        return money;
    }
    public void isContainOthers(String input)throws IllegalArgumentException{
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
    }
    public void validateUserInput(String input)throws IllegalArgumentException{
        String [] checkInput = input.split(",");
        for (String num : checkInput) {
            isContainOthers(num);
        }
    }
    public void validateBonusNumber(List<Integer> winningNumber, String userInput)throws IllegalArgumentException{
        int bonusNumber = Integer.parseInt(userInput);
        if(userInput.length() > 2)
            throw new IllegalArgumentException("[ERROR] 올바른 숫자를 입력하세요.");
        isContainOthers(userInput);
        if(bonusNumber < 1 || bonusNumber > 45)
            throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력하세요.");
        if(winningNumber.contains(bonusNumber))
            throw new IllegalArgumentException("[ERROR] 당첨번호와 겹치지 않는 숫자를 입력하세요.");
    }
    public void validUserWinningNumber(List<Integer> winningNumber) {
        Set<Integer> overlapCheck = new HashSet<>(winningNumber);
        if (overlapCheck.size() != winningNumber.size())
            throw new IllegalArgumentException("[ERROR] 중복된 숫자가 있습니다.");
        for (Integer lottoNumber : winningNumber) {
            if (lottoNumber < 1 || lottoNumber > 45)
                throw new IllegalArgumentException("[ERROR] 1 ~ 45 사이의 숫자를 입력하세요.");
        }
    }
}
