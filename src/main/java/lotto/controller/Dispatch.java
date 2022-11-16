package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.LottoConfig;
import lotto.domain.lotto.LottoInfo;
import lotto.domain.lotto.WinLotto;
import lotto.domain.user.User;
import lotto.error.ErrorMsg;
import lotto.view.Message;
import lotto.view.RankingView;
import lotto.view.Store;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dispatch {
    private final LottoConfig lottoConfig;
    private User user;

    public Dispatch(LottoConfig lottoConfig) {
        this.lottoConfig = lottoConfig;
    }

    public void buyLotto(){
        System.out.println(Message.SELLING_MSG);
        int money = convertMoney(Console.readLine());
        this.user = new User(money);

        Store store  = lottoConfig.userController().buyLotto(user);
        store.show();
    }

    public void drawLotto(){
        System.out.println(Message.CHOOSE_WINNING_NUMBERS);
        List<Integer> winning = convertWinningNumbers(Console.readLine());
        WinLotto winLotto = new WinLotto(winning);

        System.out.println(Message.CHOOSE_BONUS_NUMBER);
        int bonus = convertBonus(Console.readLine());
        winLotto.setBonusNumber(bonus);

        RankingView rankingView = lottoConfig.rankController()
                .statistics(this.user, winLotto);
        rankingView.show();
    }

    public Integer convertMoney(String money) throws IllegalArgumentException{
        int validMoney = 0;
        try {
            validMoney = Integer.parseInt(money);
        }catch (Exception e){
            throw new IllegalArgumentException(ErrorMsg.INPUT_ERROR.toString());
        }
        if (validMoney == 0)
            throw new IllegalArgumentException(ErrorMsg.NO_MONEY.toString());

        if (validMoney % LottoInfo.PRICE.getValue() != 0)
            throw new IllegalArgumentException(ErrorMsg.WRONG_BUYING_UNIT.toString());

        return validMoney;
    }

    public List<Integer> convertWinningNumbers(String numbers){
        try {
            List<Integer> lotto = Arrays.stream(numbers.split(","))
                    .map(Integer::parseInt).collect(Collectors.toList());

            for (Integer num : lotto)
                if (num < LottoInfo.MIN.getValue() || num > LottoInfo.MAX.getValue())
                    throw new IllegalArgumentException(ErrorMsg.WRONG_LOTTO_NUMBER.toString());

            return lotto;
        }catch (Exception e){
            throw new IllegalArgumentException(ErrorMsg.INPUT_ERROR.toString());
        }
    }

    public int convertBonus(String number){
        int num = 0;
        try{
            num = Integer.parseInt(number);
        }catch (Exception e){
            throw new IllegalArgumentException(ErrorMsg.INPUT_ERROR.toString());
        }
        if (num < LottoInfo.MIN.getValue() || num > LottoInfo.MAX.getValue())
            throw new IllegalArgumentException(ErrorMsg.WRONG_LOTTO_NUMBER.toString());
        return num;
    }
}
