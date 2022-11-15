package handler.console;

import camp.nextstep.edu.missionutils.Console;
import handler.InputHandler;

/**
 * 콘솔에서 입력을 받는 InputHandler 의 구상클래스 입니다
 */
public class ConsoleInput implements InputHandler {

    /**
     * Console 에서 한 줄을 읽어옵니다
     *
     * @return 읽어드린 String
     */
    @Override
    public String readLine() {
        return Console.readLine();
    }
}
