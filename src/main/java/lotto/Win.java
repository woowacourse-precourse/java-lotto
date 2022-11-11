package lotto;

import java.util.List;

public class Win {
    private int firstPlace;
    private int secondPlace;
    private int thirdPlace;
    private int fourthPlace;
    private int fifthPlace;

    public Win() {
        this.firstPlace = 0;
        this.secondPlace = 0;
        this.thirdPlace = 0;
        this.fourthPlace = 0;
        this.fifthPlace = 0;
    }

    public void threeMatchMessage() {
        System.out.println("3개 일치 (5,000원) - ");
    }

    public void fourMatchMessage() {
        System.out.println("4개 일치 (50,000원) - ");
    }

    public void fiveMatchMessage() {
        System.out.println("5개 일치 (1,500,000원) - ");
    }

    public void fiveAndBonusMatchMessage() {
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - ");
    }

    public void sixMatchMessage() {
        System.out.println("6개 일치 (2,000,000,000원) - ");
    }

    public int numberThatMatchesWinNumber(List<Integer> lottoNumbers, List<Integer> winNumbers) {
        int matchCount = 0;

        for (int winNumber : winNumbers) {
            if (lottoNumbers.contains(winNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    public int numberThatMatchesBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        int bonusMatchCount = 0;

        if (lottoNumbers.contains(bonusNumber)) {
            bonusMatchCount++;
        }

        return bonusMatchCount;
    }
}
