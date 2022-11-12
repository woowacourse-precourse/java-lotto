package lotto;

import camp.nextstep.edu.missionutils.Console;

public class User {
    static int totalPayment;

    public void putMoneyforLotto(){
        try {
            totalPayment = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
        if(totalPayment % 1000 !=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야합니다.");
        }
    }
}
