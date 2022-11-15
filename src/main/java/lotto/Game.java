package lotto;

import lotto.domain.*;
import lotto.message.ErrorMessage;
import lotto.message.GameMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    HashMap<Integer, List<Integer>> userLottoNumbers;
    List<Integer> lottoNumbers = new ArrayList<>();
    int bonusNumber;
    HashMap<Integer, Integer> winningStat = new HashMap<>();

    public Game() {
        for(int i = 0; i < 5; i++) {
            this.winningStat.put(i + 1, 0);
        }
    }

    public void play() {
        start();
        Purchase purchase = new Purchase(readLine());
        userLottoNumbers = purchase.lottoPurchase();

        inputLotto();
        Lotto lotto = new Lotto(lottoNumbers);
        lottoNumbers = lotto.lottoNumbers();

        inputBonus();
        Bonus bonus = new Bonus(readLine(), lottoNumbers);
        bonusNumber = bonus.bonusNumber();

        winningPlay();

        ReturnRate returnRate = new ReturnRate(purchase.userMoney(), winningStat);
    }

    private void start() {
        System.out.println(GameMessage.Input_Purchase.getMessage());
    }

    private void inputLotto() {
        System.out.println(GameMessage.Input_Lotto_Numbers.getMessage());
        validateLotto(readLine());
    }

    private void validateLotto(String numbers) {
        String[] numbersTmp;
        try {
            numbersTmp = numbers.split(",");
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.Lotto_Numbers_Not.getMessage());
        }

        for(int i = 0; i < numbersTmp.length; i++) {
            lottoNumbers.add(Integer.valueOf(numbersTmp[i]));
        }
    }

    private void inputBonus() {
        System.out.println(GameMessage.Input_Bonus.getMessage());
    }

    private void winningPlay() {
        Winning winning = new Winning(lottoNumbers, bonusNumber);
        int key, value;

        for(int i = 0; i < userLottoNumbers.size(); i++) {
            key = winning.checkWinning(userLottoNumbers.get(i));

            if(key == 0) {
                continue;
            }

            value = winningStat.get(key);
            winningStat.put(key, value + 1);
        }

        totalStat();
    }

    private void totalStat() {
        System.out.println(GameMessage.Winnig_Stat.getMessage());
        System.out.println(GameMessage.Three_Match.getMessage() + winningStat.get(5) + "개");
        System.out.println(GameMessage.Four_Match.getMessage() + winningStat.get(4) + "개");
        System.out.println(GameMessage.Five_Match.getMessage() + winningStat.get(3) + "개");
        System.out.println(GameMessage.Five_Bonus_Match.getMessage() + winningStat.get(2) + "개");
        System.out.println(GameMessage.Six_Match.getMessage() + winningStat.get(1) + "개");
    }
}
