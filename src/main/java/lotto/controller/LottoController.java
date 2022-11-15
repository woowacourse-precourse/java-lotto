package lotto.controller;

import lotto.service.LottoSystemService;
import lotto.service.UserService;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;

public class LottoController {

    private UserService userService = new UserService();
    private LottoSystemService lottoSystemService;
    private final String START_MESSAGE = "구입금액을 입력해 주세요.";
    private final String BUY_MESSAGE = "개를 구매했습니다.";
    private final String ANSWER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final String BONUS_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final String STATISTICS_MESSAGE = "당첨 통계\n---";
    private final String REVENUE_MESSAGE_ONE = "총 수익률은 ";
    private final String REVENUE_MESSAGE_TWO = "%입니다.";

    public void inputUserMoney(){
        System.out.println(START_MESSAGE);
        userService.setPayMent();
        this.lottoSystemService = userService.buyLotto();
    }

    public void printLottoNumber(){
        List<List<Integer>> lottoNumber = userService.getUserLottoNumber();
        System.out.println(lottoNumber.size() + BUY_MESSAGE);

        for (int i=0; i<lottoNumber.size(); i++){
            System.out.println(lottoNumber.get(i));
        }
    }

    public void inputWinningNumber(){
        System.out.println(ANSWER_MESSAGE);
        lottoSystemService.setAnswerLottoNumbers();
        lottoSystemService.saveLottoNumbers();
    }

    public void inputBonusNumber(){
        System.out.println(BONUS_MESSAGE);
        lottoSystemService.setBonusLottoNumbers();
    }

    public void printStatistics(){
        List<String> total;
        System.out.println(STATISTICS_MESSAGE);
        lottoSystemService.setTotal();
        total = lottoSystemService.getTotal();

        for(int i=0; i<total.size(); i++){
            System.out.println(total.get(i));
        }
    }

    public void printRevenue(){
        userService.setRevenue();
        float revenue = userService.getRevenue();
        System.out.println(REVENUE_MESSAGE_ONE + revenue + REVENUE_MESSAGE_TWO);
    }
}
