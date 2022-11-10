package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;
import lotto.exception.Exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Service {

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String money = Console.readLine();
        Exception.verifyMoney(money);

        return Integer.parseInt(money);
    }

    public static int getVolume(int money) {
        int volume = money / 1000;
        System.out.println(volume + "개를 구매했습니다.");
        return volume;
    }

    public static List<Lotto> getLotto(int volume) {
        List<Lotto> lottoList = new ArrayList<>();
        for(int i = 0; i < volume; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1,45,6);
            Collections.sort(numbers);
            Lotto lotto = new Lotto(numbers);
            lottoList.add(lotto);
            System.out.println(numbers);
        }
        Exception.verifyLottoListVolume(lottoList, volume);

        return lottoList;
    }
}
