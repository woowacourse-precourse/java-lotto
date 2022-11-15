package lotto.controller;


import static java.lang.String.valueOf;
import lotto.domain.MatchResult;
import lotto.domain.YieldResult;

// 전략 패턴 도전
// 로또 결과 출력기
public class Printer{

    private String printMatchResult;
    private String printYieldResult;

    public Printer() {

        this.printMatchResult = printMatchResult();
        this.printYieldResult = printYieldResult();

    }


    public String printMatchResult() {
        return valueOf(new MatchResult());
    }

    public String printYieldResult() {
        return valueOf(new YieldResult());
    }

}
