package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoPurchaser;

import java.util.ArrayList;
import java.util.List;

public class NumberMatcher {

    //모든 로또에 대해 당첨 번호와 비교하고, 각 로또의 당첨번호와 매칭되는 숫자의 개수를 리스트로 반환.

    /**
     * 도메인 로직, 테스트 필요
     */
    public List<Integer> getMatchedNumberList(List<Lotto> allLotto, List<Integer> winningNumber) {
        List<Integer> matchedNumberList = new ArrayList<>();

        for (Lotto lotto : allLotto) {
            int countOfMatchingNumber = countSameNumber(lotto.getNumbers(), winningNumber);
            matchedNumberList.add(countOfMatchingNumber);
        }
        return matchedNumberList;
    }

    //단일 로또에 대해 당첨 넘버와 비교
    public int countSameNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int count = 0;
        for (int lottoNumber : lottoNumbers) {
            count = increaseCount(lottoNumber, winningNumbers, count);
        }
        return count;
    }

    private int increaseCount(int lottoNumber, List<Integer> winningNumbers, int count) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber == lottoNumber) {
                count++;
            }
        }
        return count;
    }

}
