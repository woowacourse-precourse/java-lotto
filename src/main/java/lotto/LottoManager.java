package lotto;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoManager {
    static final int firstGrade = 6;
    static final int thirdGrade = 5;
    static final int fourthGrade = 4;
    static final int fifthGrade = 3;

    private List<Lotto> lottos = new ArrayList<Lotto>();
    private int inputMoney;
    private List<Integer> winNumbers;
    private int bonusNumber;
    private List<Integer> winCounts = new ArrayList<>(6);

    private void makeLottos(int amount){
        for (int i = 0; i < amount; i++){
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.add(lotto);
        }
    }

    void matchLottos(){
        for (Lotto lotto : lottos){
            int grade = calculateGrade(lotto);
            winCounts.set(grade, winCounts.get(grade) + 1);
        }
    }

    private int calculateGrade(Lotto lotto){
        int matchCount = getMatchCount(lotto);

        if (matchCount < fifthGrade){
            return 0;
        }
        if (matchCount == fifthGrade){
            return 5;
        }
        if (matchCount == fourthGrade){
            return 4;
        }
        if (matchCount == thirdGrade){
            if (!lotto.getNumbers().contains(bonusNumber)){
                return 3;
            }
            return 2;
        }
        return 1;
    }

    private int getMatchCount(Lotto lotto){
        List<Integer> numbers = lotto.getNumbers();
        int matchCount = 0;

        for (int number : numbers){
            if (winNumbers.contains(number)){
                matchCount++;
            }
        }
        return matchCount;
    }

    void setWinNumbers(List<Integer> numbers){
        winNumbers = numbers;
    }

    void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    void InputMoney(int money){
        if (money % 1000 != 0){
            throw new IllegalArgumentException();
        }
        this.inputMoney = money;
        makeLottos(money / 1000);
    }

    int getInputMoney(){
        return inputMoney;
    }

    int getWinCount(int idx){
        return winCounts.get(idx);
    }

    List<Lotto> getLottos(){
        return lottos;
    }
}
