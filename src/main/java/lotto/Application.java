package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1 : User Number Make

        User user = new User();

        MakeNumber makeNumber = new MakeNumber();

        List<List> lottoNumber = makeNumber.makeUserNumber(user.buyCount);


        // 2 : Lotto validate Check

        MakeLotto makeLotto = new MakeLotto();

        Lotto lotto = new Lotto(makeLotto.lottoNumber);

        // 3 : Lotto Number Make


        // 4 : has Check Number

        // 5 : 당첨결과출력

    }
}
