package lotto.service;

import lotto.domain.Issue;
import lotto.domain.Lotto;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class LottoService {
    List<Lotto> history;
    Lotto win;
    Output output;
    Input input;
    Issue issue;
    public LottoService(){
        output = new Output();
        input = new Input();
    }

    //구입 금액 안내 문구 출력
    //구입 금액 입력
    public void create(){
        output.moneyInform();
        issue = new Issue(input.money());
        history = issue.lotto();
    }
    //구입 개수 안내 문구 출력
    //구입 번호 출력
    public void showHistory(){
        output.amount(Integer.toString(history.size()));
        output.lottoHistory(history);
    }



    //당첨 번호 안내 문구 출력
    //당첨 번호 입력
    public void createWinNum(){
        output.winningNum();
        Integer[] numbers = Stream.of(input.winningNum().split(","))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);
        win = new Lotto(Arrays.asList(numbers));
    }

    //보너스 번호 안내 문구 출력
    //보너스 번호 입력
    public void createBonusNum(){
        output.bonusNum();
        win.addBonusNum(input.bounsNum());
    }

    //당첨통계 출력
    public void winStaticics(){
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
    //수익률 출력
    public void revenue() {
        int revenue = 0;
        for (CoincideNumber coincideNumber : CoincideNumber.values()){
            if(coincideNumber.count()!=0) {
                revenue = revenue + coincideNumber.calculateRevenue();
            }
        }
        output.revenue(issue.calculate(revenue));
    }
}
