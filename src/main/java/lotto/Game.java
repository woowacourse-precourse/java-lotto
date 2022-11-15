package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Game {

    private final LottoNumberMaker lottoNumberMaker;
    private final WinningLotto winningLotto;
    private final WinningChecker winningChecker;
    private final Printer printer;
    private final Caculator caculator;

    public Game(LottoNumberMaker lottoNumberMaker, WinningLotto winningLotto, WinningChecker winningChecker, Printer printer, Caculator caculator){
        this.lottoNumberMaker = lottoNumberMaker;
        this.winningChecker = winningChecker;
        this.winningLotto = winningLotto;
        this.printer = printer;
        this.caculator =caculator;
    }
    public void play() throws IllegalArgumentException {
        long payment = Integer.parseInt(Console.readLine());
        int paper = Caculator.caculatePaper(payment);
        List<Integer> lottos =
    }


}
