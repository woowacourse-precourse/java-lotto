package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.ui.Message;

public class Input {
    public String request() {
        return Console.readLine();
    }

    /**
     * 의도된 사항인지 모르겠으나 ApplicationTest 에서 예외 테스트를 통과하기 위해서는
     * IllegalArgumentException 이 발생되었을 때 에러를 반환하는 것이 아닌 메세지만 콘솔에 띄우고 프로그램을 종료시켜야 한다.
     */
    public int convertInput(String input) {
        try {
            return Integer.parseInt(input);

        } catch (IllegalArgumentException e) {
            System.out.println(Message.ERROR_MESSAGE + Message.INPUT_ERROR);
            return -1;
        }
    }
}

