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

    public void create(){
        output.moneyInform();
        issue = new Issue(input.money());
        history = issue.lotto();
    }

    public void showHistory(){
        output.amount(history.size());
        output.lottoHistory(history);
    }


    public void createWinNum(){
        output.winningNum();
        Integer[] numbers = Stream.of(input.winningNum().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        win = new Lotto(Arrays.asList(numbers));
    }

    public void createBonusNum(){
        output.bonusNum();
        win.addBonusNum(input.bonusNum());
    }

    public void winStatistics(){
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

    public void revenue() {
        double revenue = 0;
        for (CoincideNumber coincideNumber : CoincideNumber.values()){
            if(coincideNumber.count()!=0) {
                revenue = revenue + coincideNumber.calculateRevenue();
            }
        }
        output.revenue(issue.revenue(revenue));
    }
}
