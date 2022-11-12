package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Player {


    public int putMoneyforLotto(String money){
        int totalPayment;
        try {
            totalPayment = Integer.parseInt(money);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 정수를 입력해야 합니다.");
        }
        checkDivideBy1000(totalPayment);

        return (int)totalPayment/1000;
    }
    public void checkDivideBy1000(int totalPayment) {
        if(totalPayment % 1000 !=0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야합니다.");
        }
    }
}
