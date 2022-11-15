package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Service {

    public int getMoneyInput() {
        try{
            int input = Integer.parseInt(Console.readLine());
            if (!(input % 1000 == 0)) {
                throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
            }
            return input;
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }

    }
}
