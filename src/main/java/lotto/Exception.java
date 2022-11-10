package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exception {
    public int isvalidMoney(int money)throws IllegalArgumentException{
        if(money < 1000)
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력하세요.");
        if(money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 유효한 값을 입력하세요.");
        return money;
    }
    public boolean isContainOthers(String input)throws IllegalArgumentException{
        for(int i = 0; i < input.length(); i++){
            if(!Character.isDigit(input.charAt(i)))
                throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
        return true;
    }
    public boolean isProperComma(String input)throws IllegalArgumentException{
        char [] checkNumber = input.toCharArray();
        for(int i = 1; i < input.length(); i += 2){
            if(checkNumber[i] != ',')
                throw new IllegalArgumentException("[ERROR] 입력을 올바르게 하세요.");
        }
        return true;
    }
    public boolean validUserWinningNumber(List<Integer> winningNumber) {
        Set<Integer> overlapCheck = new HashSet<>(winningNumber);
        if(winningNumber.size() != 6)
            return false;
        if (overlapCheck.size() != winningNumber.size())
            return false;
        for (Integer lottoNumber : winningNumber) {
            if (lottoNumber < 1 || lottoNumber > 45)
                return false;
        }
        return true;
    }
}
