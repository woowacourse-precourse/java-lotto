package lotto.Console;

import camp.nextstep.edu.missionutils.Console;

/***
 * 입력받는 클래스
 */
public class InputConsole {

    public String Money(){
        System.out.println("구입금액을 입력해 주세요.");
        return Console.readLine();
    }

    public String Number(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public String bonusNum(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Console.readLine();
    }

}
