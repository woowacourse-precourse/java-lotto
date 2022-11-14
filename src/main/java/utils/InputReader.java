package utils;

import camp.nextstep.edu.missionutils.Console;

/**
 * 만약 외부 라이브러리에 의존해야하는 기능이 있다면,
 * 라이브러리가 더이상 서비스되지 않을 때를 대비해
 * 메서드를 코드 내에 직접 삽입하지 않고
 * 따로 관리하는 것이 유지보수에 좋을 것 같다고 생각했습니다.
 */

public class InputReader {
    public static String readLine () {
        return Console.readLine();
    }
}
