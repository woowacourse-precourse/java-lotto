package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Game {
    public void start(){
        System.out.println("구입금액을 입력해 주세요.");
        int inputCost = Integer.parseInt(Console.readLine());

        if (inputCost%1000 != 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력하세요");
        }
    }
}
