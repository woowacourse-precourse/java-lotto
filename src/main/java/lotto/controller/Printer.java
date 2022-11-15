package lotto.controller;

import lotto.abstraction.PrintInterface;
import lotto.abstraction.ResultRepository;
import lotto.domain.MatchResult;
import lotto.domain.YieldResult;

// 전략 패턴 도전
// 로또 결과 출력기
public class Printer implements ResultRepository {

    private PrintInterface printResult;
    private String printMatchResult;
    private String printYieldResult;

    public Printer(PrintInterface printResult) {
        this.printMatchResult = String.valueOf(new MatchResult());
        this.printYieldResult = String.valueOf(new YieldResult());
    }


    @Override
    public void keepHistory() {

    }
}
