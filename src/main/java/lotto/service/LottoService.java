package lotto.service;

import lotto.domain.Issue;
import lotto.domain.Lotto;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LottoService {
    private List<Lotto> history;
    private Lotto win;
    private Output output;
    private Input input;
    private Issue issue;
    public LottoService(){
        output = new Output();
        input = new Input();
    }

    final public void start(){
        create();
        showHistory();
        createWinNum();
        createBonusNum();
        winStatistics();
        revenue();
    }

    private void create(){
        output.moneyInform();
        issue = new Issue(input.money());
        history = issue.lotto();
    }

    private void showHistory(){
        output.amount(history.size());
        output.lottoHistory(history);
    }


    private void createWinNum(){
        output.winningNum();
        Integer[] numbers = Stream.of(input.winningNum().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        win = new Lotto(Arrays.asList(numbers));
    }

    private void createBonusNum(){
        output.bonusNum();
        win.addBonusNum(input.bonusNum());
    }

    private void winStatistics(){
        for(Lotto numbers : history) {
            int count = win.compare(numbers);
            if(count == 5 && numbers.hasBonusNum(win)){
                CoincideNumber.plusCountOfRank(5);
                continue;
            }
            int rank = 7-count;
            if(rank < 5) {
                CoincideNumber.plusCountOfRank(rank);
            }
        }
        output.winStatistics();
    }

    private void revenue() {
        double revenue = 0;
        for (CoincideNumber coincideNumber : CoincideNumber.values()){
            if(coincideNumber.count()!=0) {
                revenue = revenue + coincideNumber.calculateRevenue();
            }
        }
        output.revenue(issue.revenue(revenue));
    }


}
