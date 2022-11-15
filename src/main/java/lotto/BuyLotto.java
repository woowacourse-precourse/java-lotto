package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class BuyLotto {

    public static int numberOfLottoGames(int money){
        int games = money;

        games = games / 1000;

        return games;
    }

}
