package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 1 : User Number Make

        User user = new User();

        MakeNumber makeNumber = new MakeNumber();

        List<List> lottoNumber = makeNumber.makeUserNumber(user.buyCount);


        // 2 : Lotto Number Make
        MakeLotto makeLotto = new MakeLotto();


        // 3 : Lotto validate Check
        Lotto lotto = new Lotto(makeLotto.lottoNumber);

        lotto.numberValidate(Arrays.asList(makeLotto.lottoBonusNumber));//보너스숫자 체크


        // 4 : has Check Number

        CountingLotto countingLotto = new CountingLotto();
        List<Integer> counting = countingLotto.hasCheckNumber(lottoNumber,makeLotto.lottoNumber,makeLotto.lottoBonusNumber);

        // 5 : 당첨결과출력

        RankSystem rankSystem = new RankSystem();
        rankSystem.hasPrintCount(counting);
        rankSystem.calYield(user.buyMoney);

    }
}
