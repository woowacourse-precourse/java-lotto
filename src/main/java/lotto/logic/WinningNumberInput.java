package lotto.logic;

import camp.nextstep.edu.missionutils.Console;

public class WinningNumberInput {

    public String inputWinningNum(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningnum = Console.readLine();
        return winningnum;
    }
}
