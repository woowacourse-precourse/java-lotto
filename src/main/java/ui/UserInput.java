package ui;

import camp.nextstep.edu.missionutils.Console;

// 사용자의 입력값을 읽어주는 클래스
public class UserInput {

    public static String buyLotto() {
        return Console.readLine();
    }

    public static String enterWinningLottoNumber() {
        return Console.readLine();
    }

    public static String enterBonusNumber() {
        return Console.readLine();
    }
}
