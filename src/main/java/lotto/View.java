package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Model.Lotto;
import lotto.domain.WinningCount;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class View {
    public int askPrice() {
        System.out.println(Constant.ASK_PRICE);
        try {
            int price = Integer.parseInt(Console.readLine());
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Error.WRONG_MONEY_TYPE.getMessage());
        }
    }

    public void buyLottoList(int price, List<Lotto> lottoBundle) {
        System.out.println(price / 1000 + Constant.SHOW_BUY_COUNT);
        for (Lotto lotto : lottoBundle) {
            List<Integer> temporaryLotto = new ArrayList<>();
            temporaryLotto.addAll(lotto.getNumbers());
            Collections.sort(temporaryLotto);
            System.out.println(temporaryLotto.toString());
        }
        System.out.println();
    }

    public List<Integer> askWinningNumber() {
        List<Integer> winningLotto = new ArrayList<>();
        System.out.println(Constant.ASK_WINNING_NUMBER);
        String number = Console.readLine();
        System.out.println();
        number = number.replaceAll(" ", "");
        String[] winningNumbers = number.split(",");

        for (String winningNumber : winningNumbers) {
            winningLotto.add(Integer.parseInt(winningNumber));
        }
        return winningLotto;
    }

    public int askBonusNumber() {
        System.out.println(Constant.ASK_BONUS_NUMBER);
        String bonusNumber = Console.readLine();
        System.out.println();
        return Integer.parseInt(bonusNumber);
    }

    public void showWinCase(WinningCount winningCount) {
        System.out.println(Constant.WINNING_STATS);
        System.out.println("---");
        System.out.println(Constant.THREE_MATCH + winningCount.getCount().get(Constant.FIFTH_PLACE) + Constant.PIECE);
        System.out.println(Constant.FOUR_MATCH + winningCount.getCount().get(Constant.FOURTH_PLACE) + Constant.PIECE);
        System.out.println(Constant.FIVE_MATCH + winningCount.getCount().get(Constant.THIRD_PLACE) + Constant.PIECE);
        System.out.println(Constant.FIVE_BONUS_MATCH + winningCount.getCount().get(Constant.SECOND_PLACE) + Constant.PIECE);
        System.out.println(Constant.SIX_MATCH + winningCount.getCount().get(Constant.FIRST_PLACE) + Constant.PIECE);
    }

    public void showProfitRate(double rate) {
        System.out.println("총 수익률은 " + rate + "%입니다.");
    }
}
