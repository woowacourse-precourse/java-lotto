package lotto.controller;


import lotto.abstraction.InternalMatcher;

// 당첨 번호, 로또 생성 번호 비교
public class Matcher implements InternalMatcher {

    private boolean match;
    private int matchCount;

    public Matcher() {
        this.matchCount = 0;
        this.match = false;
    }

    // 발행 로또 번호와 추첨 번호의 일치 여부의 횟수 세기
    @Override
    public int countMatcher() {

        checkMatch();
        if (checkMatch()) {
            matchCount++;
        }

        return matchCount;

    }

    // 일치 여부 탐색 순회
    private boolean checkMatch() {
        for (int i = 0; i < new MatchBuilder().ITERATOR_NUMBER(); i++){

            match = new MatchBuilder().
                    buildLottoNumbers().containsValue(
                            new MatchBuilder().buildWinningNumbers().get(i));
        }
        return match;
    }

    // 당첨 번호 일치 여부 검사의 결과 반영
    @Override
    public int buildMatchCount() {

        return matchCount;

    }

}
