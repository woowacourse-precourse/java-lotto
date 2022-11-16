package lotto.service;

import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class NumberMatcher {


    //모든 로또에 대해 당첨 번호와 비교하고, 각 로또의 당첨번호와 매칭되는 숫자의 개수를 리스트로 반환.

    public List<Integer> matchedNums(List<Lotto> allLotto, List<Integer> winningNumber) {
        List<Integer> countSameNum = new ArrayList<>();
        for (Lotto lotto : allLotto) {
            int countOfSameNum = countSameNumber(lotto.getNumbers(), winningNumber);
            countSameNum.add(countOfSameNum);
        }
        return countSameNum;
    }

    //단일 로또에 대해 당첨 넘버와 비교
    public static int countSameNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int lottoNumber : lottoNumbers) {
            for (int winningNumber : winningNumbers) {
                if (winningNumber == lottoNumber) {
                    count++;
                }
            }
        }
        return count;
    }

}
