package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> winSevenNumber(String bonusNumber) {

        this.numbers.add(Integer.parseInt(bonusNumber));

        return this.numbers;
    }

    public int compareWinNumberAndLottoPaperPoint (List<Integer> LottoPaperLine) {
        int rankNumber = 0;

        for (int i = 0; i < 6; i++) {
            if (LottoPaperLine.contains(numbers.get(i))) {
                rankNumber++;
            }
        }

        if (LottoPaperLine.contains(numbers.get(6))) {
            rankNumber += 100;
        }

        return rankNumber;
    }

    public void RankLineUnderHundred (int rankPoint) {
        if (rankPoint == 3) {
            GameData.FIFTH.addCount();
        }
        if (rankPoint == 4) {
            GameData.FOURTH.addCount();
        }
        if (rankPoint == 5) {
            GameData.THIRD.addCount();
        }
        if (rankPoint == 6) {
            GameData.FIRST.addCount();
        }
    }

    public void RankLineOverHundred (int rankPoint) {
        if (rankPoint == 103) {
            GameData.FIFTH.addCount();
        }
        if (rankPoint == 104) {
            GameData.FOURTH.addCount();
        }
        if (rankPoint == 105) {
            GameData.SECOND.addCount();
        }
    }


}
