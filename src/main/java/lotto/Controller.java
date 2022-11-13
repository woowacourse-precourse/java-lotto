package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Controller {

    public void run(int lottoCount) {

        System.out.println("\n" + lottoCount + "개를 구매했습니다.");

        Set<List<Integer>> lottoNumbers = lottoGenerator(lottoCount);
        lottoNumbers.forEach(System.out::println);

        GameStart gameStart = new GameStart();
        gameStart.play(lottoNumbers);
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
