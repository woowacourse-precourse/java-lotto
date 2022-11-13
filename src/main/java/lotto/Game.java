package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {

    public void play(int lottoCount) {

        System.out.println("게임 시작~");
        System.out.println(lottoCount);

        for (int count = 0; count < lottoCount; count++) {

            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            System.out.println(lottoNumber);
        }
    }
}
