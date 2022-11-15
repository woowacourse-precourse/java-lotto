package lotto.controller;



import java.util.AbstractMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.abstraction.InternalMatcher;
import lotto.shell.WinningNumber;


public class Matcher implements InternalMatcher {

    List<Integer> winningNumberList = new WinningNumber().addWinningNumber();
    Map<Integer, List<Integer>> a = new AbstractMap<Integer, List<Integer>>() {
        @Override
        public Set<Entry<Integer, List<Integer>>> entrySet() {
            return null;
        }
    }


    private int matchCount = 0;

    // 발행 로또 번호와 추첨 번호의 일치 여부의 횟수 세기
    @Override
    public int countMatcher() {

        for ( int index = 0; index < winningNumberList.size(); index++ ) {

            boolean match = winningNumberList.contains(lottoNumberList.get(index));

            if ( match ) {    matchCount++;    }

        }

        return matchCount;

    }

    // 당첨 번호 일치 여부 검사의 결과 반영
    @Override
    public int resultByMatcher() {

        int matchCount = this.matchCount;


        return this.matchCount;

    }

}
