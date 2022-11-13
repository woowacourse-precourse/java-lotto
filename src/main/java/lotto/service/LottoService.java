package lotto.service;

import lotto.domain.Issue;
import lotto.domain.Lotto;
import lotto.ui.Input;
import lotto.ui.Output;

import java.util.ArrayList;
import java.util.List;

public class LottoService {
    List<Lotto> history;
    Output output;
    Input input;
    Issue issue;
    Lotto lotto;
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

    //보너스 번호 안내 문구 출력
    //보너스 번호 입력

    //당첨통계 출력
}
