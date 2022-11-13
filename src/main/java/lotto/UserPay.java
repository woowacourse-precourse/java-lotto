package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserPay {
    private String userInput;

    public void userPayment() throws IllegalArgumentException{

        System.out.println("구입금액을 입력해 주세요.");
        userInput = Console.readLine();

        for(int i=0; i<userInput.length(); i++){
            char userNumberChar = userInput.charAt(i);

            if(!Character.isDigit(userNumberChar)){
                throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
            }
        }
    }

    public int lottocount() throws IllegalArgumentException{
        int count = Integer.parseInt(userInput)/1000;

        if(Integer.parseInt(userInput)%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 천원 단위로 입력해주세요.");
        }

        return count;
    }
}
