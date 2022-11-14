package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class User {
    public List<Lotto> userLotto;
    public int achieveMoney;

    public User() {
        userLotto = new ArrayList<>();
    }

    public void getUserLotto(int price) {
        int lottoCount = price / 1000;
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 15, 6);
            List<Integer> sortedList = numbers.stream().sorted().collect(Collectors.toList());
            userLotto.add(new Lotto(sortedList));
        }
    }

    public void printUserLotto(int price) {
        int lottoCount = price / 1000;
        Message.printLottoCountMessage(lottoCount);

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = userLotto.get(i);
            List<Integer> printList = lotto.printLottoNumber();
            System.out.println(printList);
        }
    }

    public void printWinningResult(List<Integer> lottoAnswer, String bonusNumber) {
        HashMap<Score, Integer> scoreBoard = new HashMap<>();
        putScore(scoreBoard);

        for (Lotto userLottoCase : userLotto) {
            Score score = calculatorResult(userLottoCase.printLottoNumber(), lottoAnswer, bonusNumber);
            if (scoreBoard.containsKey(score)) {
                scoreBoard.put(score, scoreBoard.get(score) + 1);
                achieveMoney += score.getMoney();
            }
        }
        Message.printResultMessage(scoreBoard);
    }

    private void putScore(HashMap<Score, Integer> scoreBoard) {
        scoreBoard.put(Score.third, 0);
        scoreBoard.put(Score.fourth, 0);
        scoreBoard.put(Score.fifth, 0);
        scoreBoard.put(Score.fifthBonus, 0);
        scoreBoard.put(Score.six, 0);
    }

    public Score calculatorResult(List<Integer> userLottoCase, List<Integer> lottoAnswer, String bonusNumber) {
        int count = 0;

        for (Integer a : userLottoCase) {
            if (lottoAnswer.contains(a)) {
                count++;
            }
        }
        if (count == 5 && lottoAnswer.contains(Integer.parseInt(bonusNumber))) {
            count = 55;
        }

        return Score.getWinValue(count);
    }

    public void printWinningRatio(int correctLottoNum, int purchasePrice) {
        Message.printWinningRatioMessage(((double) correctLottoNum / purchasePrice * 100));
    }
}
