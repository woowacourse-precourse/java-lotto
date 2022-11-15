package lotto.views;

import camp.nextstep.edu.missionutils.Console;

import lotto.utils.Constants;

public class LottoWinningView {
    public static String lottoWinningNumberRequestMessage(){
        System.out.println(Constants.LOTTO_WINNING_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public static String lottoBonusRequestMessage(){
        System.out.println(Constants.LOTTO_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
