package handler.console;

import handler.OutputHandler;

/**
 * Console 을 통해 출력하는 OutputHandler 의 구상클래스 입니다
 */
public class ConsoleOutput implements OutputHandler {

    /**
     * Console 을 통해 동일한 포맷이 적용된 형태로 출력을합니다
     *
     * @param format 포맷 스트링
     * @param args   들어갈 수 있는 인자들
     */
    @Override
    public void printf(String format, Object... args) {
        System.out.printf(format, args);
    }

    /**
     * 한 줄을 콘솔을 통해 출력합니다
     *
     * @param content 출력할 내용
     */
    @Override
    public void println(String content) {
        System.out.println(content);
    }
}
