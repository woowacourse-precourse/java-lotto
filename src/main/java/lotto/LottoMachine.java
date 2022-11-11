package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public void requestWantBuyAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void canBuyAmountMessage(int canBuyAmount) {
        System.out.println();
        System.out.println(canBuyAmount + "개를 구매했습니다.");
    }

    public int canBuyAmount(int wantBuyAmountInput) {
        return wantBuyAmountInput / 1000;
    }

    public List<Integer> makeUserRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public Lotto makeLotto(List<Integer> makeUserRandomLottoNumbers) {
        return new Lotto(makeUserRandomLottoNumbers);
    }

    public void requestWinningNumbersMessage() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public List<Lotto> lottoList(int canBuyAmount) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < canBuyAmount; i++) {
            Lotto lotto = makeLotto(makeUserRandomLottoNumbers());
            lottoList.add(lotto);
        }

        return lottoList;
    }

    public void requestBonusNumbersMessage() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void scoreBoardMessage() {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public List<Integer> countCorrect(List<Lotto> lottoList, List<Integer> winningNumbers) {
        List<Integer> collectNumbers = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            int cnt = 0;
            for (Integer winningNumber : winningNumbers) {
                if (lotto.getNumbers().contains(winningNumber)) {
                    cnt++;
                }
            }
            collectNumbers.add(cnt);
        }

        System.out.println(collectNumbers);

        return collectNumbers;
    }

    public boolean isContainBonusNumber(List<Lotto> lottoList, int bonusNumber) {
        for (Lotto lotto : lottoList) {
            if (lotto.getNumbers().contains(bonusNumber)) {
                return true;
            }
        }

        return false;
    }

    public List<Boolean> isContainBonusNumberList(List<Lotto> lottoList, int bonusNumber) {
        List<Boolean> isContainBonusNumberList = new ArrayList<>();

        for (Lotto lotto : lottoList) {
            isContainBonusNumberList.add(isContainBonusNumber(lottoList, bonusNumber));
        }

        return isContainBonusNumberList;
    }

    public int[] makeScoreBoard(List<Integer> correctCntList,List<Boolean> containBonusNumberList) {
        int[] scoreBoard = new int[5];

        for (int i = 0; i < correctCntList.size(); i++) {
            if (correctCntList.get(i) == 3) {
                scoreBoard[0]++;
            }
            if (correctCntList.get(i) == 4) {
                scoreBoard[1]++;
            }
            if (correctCntList.get(i) == 5 && !containBonusNumberList.get(i)) {
                scoreBoard[2]++;
            }
            if (correctCntList.get(i) == 5 && containBonusNumberList.get(i)) {
                scoreBoard[3]++;
            }
            if (correctCntList.get(i) == 6) {
                scoreBoard[4]++;
            }
        }

        return scoreBoard;
    }

    public int totalIncome(List<Integer> correctCntList,List<Boolean> containBonusNumberList) {
        int totalIncome = 0;

        for (int i = 0; i < correctCntList.size(); i++) {
            if (correctCntList.get(i) == 3) {
                totalIncome+=5000;
            }
            if (correctCntList.get(i) == 4) {
                totalIncome+=50000;
            }
            if (correctCntList.get(i) == 5 && !containBonusNumberList.get(i)) {
                totalIncome+=1500000;
            }
            if (correctCntList.get(i) == 5 && containBonusNumberList.get(i)) {
                totalIncome+=30000000;
            }
            if (correctCntList.get(i) == 6) {
                totalIncome+=2000000000;
            }
        }

        return totalIncome;
    }

    public void makeYield(int totalIncome,int wantBuyAmount) {
        double yield = ((double)totalIncome / wantBuyAmount) * 100;
        yield = Math.round((yield * 100));
        System.out.println("총 수익률은 "+yield/100+"%입니다.");
    }

    public void scoreBoardMessage(int[] scoreBoard) {
        for (int i = 0; i < scoreBoard.length; i++) {
            System.out.println(scoreToWinningEnumMessage(i)+" - "+scoreBoard[i]+"개");
        }
    }

    public String scoreToWinningEnumMessage(int score) {
        if (score == 0) {
            return Winning.FIFTH.getMessage();
        }
        if (score == 1) {
            return Winning.FOURTH.getMessage();
        }
        if (score == 2) {
            return Winning.THIRD.getMessage();
        }
        if (score == 3) {
            return Winning.SECOND.getMessage();
        }
        if (score == 4) {
            return Winning.FIRST.getMessage();
        }
        return Winning.NOPE.getMessage();
    }

}
