package lotto.io;
import camp.nextstep.edu.missionutils.Console;

public class InputControl {

    public static int readInt() {
        try {
            return Integer.parseInt(readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 수가 정수 형식이 아닙니다.");
        }
    }

    public static String readLine() {
        return Console.readLine();
    }
}
