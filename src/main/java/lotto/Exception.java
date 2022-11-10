package lotto;

import java.util.List;

public class Exception {
    public boolean validMoney(int money)throws IllegalArgumentException{
        if(money < 1000)
            throw new IllegalArgumentException("[ERROR] 1000원 이상의 금액을 입력하세요.");
        if(money % 1000 != 0)
            throw new IllegalArgumentException("[ERROR] 유효한 값을 입력하세요.");
        return true;
    }
    public boolean validUserInputMoney(String inputMoney)throws IllegalArgumentException{
        for(int i = 0; i < inputMoney.length(); i++){
            if(!Character.isDigit(inputMoney.charAt(i)))
                throw new IllegalArgumentException("[ERROR] 숫자를 입력하세요.");
        }
        return true;
    }
    public void validUserInputStringNumber(String inputMoney){
        char [] checkNumber = inputMoney.toCharArray();
        for(int i = 1; i < inputMoney.length(); i += 2){
            if(checkNumber[i] != ',')
                throw new IllegalArgumentException("");
        }
    }
    public boolean validUserWinningNumber(List<Integer> winningNumber)throws IllegalArgumentException{
        if(winningNumber.size() != 6)
            throw new IllegalArgumentException("[ERROR] 번호 6개를 입력하세요.");
        for (Integer lottoNumber : winningNumber) {
            if (lottoNumber < 1 || lottoNumber > 45)
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 숫자를 입력하세요.");
        }
        return true;
    }
}
