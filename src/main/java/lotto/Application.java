package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 프로그램 시작
        createNum();
    }

    // 당첨 번호 생성
    public static void createNum(){
        List<Integer> WinningNum = Randoms.pickUniqueNumbersInRange(1,45,6);
        System.out.println(WinningNum);
    }
}
