package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class User {
    public List<Lotto> lottoSet;

    public User(){
        System.out.println("구입 금액을 입력해주세요.");
        int numberOfLotto = getNumberOfLotto();

    }
    public static int getNumberOfLotto(){
        String totalPrice = readLine();

        // 예외 검사 실시 - 순서대로 - "사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다."
        // 1. 숫자로만 이루어졌어?
        // 2. 1000원으로 나누어 떨어져?
        // 3.  --  또 있나 생각해보기  --
        // 따로 메서드 만들어서 test하기!! -> 구현할 기능 목록에도 추가하기
        int numberOfLotto = Integer.parseInt(totalPrice);
        return numberOfLotto;
    }
}
