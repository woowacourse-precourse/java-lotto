package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.UserLotto;

public class LottoGame {
    private UserLotto user = new UserLotto();


    public LottoGame() {
    }

    public void startLotto(){
        System.out.println("구입 금액을 입력해주세요.");

        int input = Integer.parseInt(Console.readLine());

        validateUnit(input);

        input /= 1000;

        while(input>0){
            user.setRandomNumber();
            input--;
        }

    }

    public void validateUnit(int input){
        if(input % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액이 1000원 단위가 아닙니다.");
        }
    }
}
