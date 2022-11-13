package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class UserInterface {

    public String getUserInput(String changeWord) {
        System.out.println(changeWord + "을 입력해 주세요.");
        return Console.readLine();
    }


}
