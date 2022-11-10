package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer {

    public List<List<Integer>> issuedLotto(int amount) {
        List<List<Integer>> lottoList = new ArrayList<>();
        printAmount(amount);
        generateLotto(amount, lottoList);
        sortLotto(lottoList);
        printLottoList(lottoList);
        return lottoList;
    }

    public void printAmount(int amount) {
        System.out.println(amount + "개를 구매했습니다.");
    }

    public void generateLotto(int amount, List<List<Integer>> lottoList) {
        List lotto = new ArrayList();
        for (int idx = 0; idx < amount; idx++) {
            lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(lotto);
        }
    }

    public void sortLotto(List<List<Integer>> lottoList) {
        for (List lotto : lottoList) {
            Collections.sort(lotto);
        }
    }

    public void printLottoList(List<List<Integer>> lottoList) {
        for (List lotto : lottoList) {
            System.out.println(lotto);
        }
    }
}