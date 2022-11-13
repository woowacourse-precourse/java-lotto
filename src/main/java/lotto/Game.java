package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Game {

    public void play(int lottoCount) {
        System.out.println("게임 시작~");
        System.out.println(lottoCount);

        Set<List<Integer>> lottoNumbers = lottoGenerator(lottoCount);

        System.out.println(lottoNumbers);

    }

    private Set<List<Integer>> isValidCntLottoNumbers(int lottoCount, Set<List<Integer>> lottoNumbers) {

        while (lottoNumbers.size() != lottoCount) {
            lottoNumbers.add(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        }

        return lottoNumbers;
    }

    private Set<List<Integer>> lottoGenerator(int lottoCount) {

        Set<List<Integer>> lottoNumbers = new HashSet<>();

        for(int count =0; count < lottoCount; count++) {

            List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.add(lottoNumber);
        }
        return isValidCntLottoNumbers(lottoCount,lottoNumbers);
    }
}
