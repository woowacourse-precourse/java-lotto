package lotto;

import lotto.domain.*;
import lotto.message.ErrorMessage;
import lotto.message.GameMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    HashMap<Integer, List<Integer>> userLottoNumbers;
    List<Integer> lottoNumbers;
    int bonusNumber;
    HashMap<Integer, Integer> winningStat;

    public Game() {
        for(int i = 0; i < 5; i++) {
            this.winningStat.put(i + 1, 0);
        }
    }

    public void play() {
        start();
        Purchase purchase = new Purchase(readLine());
        userLottoNumbers = purchase.lottoPurchase(); // 구매, 발행까지 완

        inputLotto();
        Lotto lotto = new Lotto(lottoNumbers);
        lottoNumbers = lotto.lottoNumbers(); // 로또 번호 완

        inputBonus();
        Bonus bonus = new Bonus(readLine(), lottoNumbers);
        bonusNumber = bonus.bonusNumber();

        winningPlay();

        ReturnRate returnRate = new ReturnRate(purchase.userMoney(), winningStat);
    }

    private void start() {
        System.out.println(GameMessage.Input_Purchase);
    }

    private void inputLotto() {
        System.out.println(GameMessage.Input_Lotto_Numbers);
        validateLotto(readLine());
    }

    private void validateLotto(String numbers) {
        List<String> numbersTmp = new ArrayList<>();
        try {
            numbersTmp.add(Arrays.toString(numbers.split(",")));
        } catch (Exception e) {
            throw new IllegalArgumentException(String.valueOf(ErrorMessage.Lotto_Numbers_Not));
        }

        for(int i = 0; i < numbersTmp.size(); i++) {
            lottoNumbers.add(Integer.parseInt(numbersTmp.get(i)));
        }
    }

    private void inputBonus() {
        System.out.println(GameMessage.Input_Bonus);
    }

    private void winningPlay() {
        Winning winning = new Winning(lottoNumbers, bonusNumber);
        int key, value;

        for(int i = 0; i < userLottoNumbers.size(); i++) {
            key = winning.checkWinning(userLottoNumbers.get(i));
            value = winningStat.get(key);
            winningStat.put(key, value + 1);
        }

        totalStat();
    }

    private void totalStat() {
        System.out.println(GameMessage.Winnig_Stat);
        System.out.println(GameMessage.Three_Match + String.valueOf(winningStat.get(5)) + "개");
        System.out.println(GameMessage.Four_Match + String.valueOf(winningStat.get(4)) + "개");
        System.out.println(GameMessage.Five_Match + String.valueOf(winningStat.get(3)) + "개");
        System.out.println(GameMessage.Five_Bonus_Match + String.valueOf(winningStat.get(2)) + "개");
        System.out.println(GameMessage.Six_Match + String.valueOf(winningStat.get(1)) + "개");
    }
}
