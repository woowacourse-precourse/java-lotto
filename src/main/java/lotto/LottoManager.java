package lotto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.extension.InvocationInterceptor;

public class LottoManager {
    static final int firstGrade = 6;
    static final int thirdGrade = 5;
    static final int fourthGrade = 4;
    static final int fifthGrade = 3;

    private List<Lotto> lottos = new ArrayList<Lotto>();
    private List<Integer> prizes = List.of(0, 2000000000, 30000000, 1500000, 50000, 5000);
    private int inputMoney;
    private List<Integer> winNumbers;
    private int bonusNumber;
    private List<Integer> winCounts = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));

    public void InputMoney(int money) throws IllegalArgumentException{
        if (money % 1000 != 0 || money == 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위 금액으로 입력해주십시오.");
        }
        this.inputMoney = money;
        try{
            //lottos.add(new Lotto(new ArrayList<>(List.of(1, 3, 5, 14, 22, 46))));
            makeLottos(money / 1000);
        }
        catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
    private void makeLottos(int amount) throws IllegalArgumentException{
        for (int i = 0; i < amount; i++){
            try {
                Lotto lotto = new Lotto(makeLottoNumbers());
                lottos.add(lotto);
            }
            catch (IllegalArgumentException e){
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

    private List<Integer> makeLottoNumbers(){
        while (true) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            if (!haveSameNumbers(numbers)){
                return numbers;
            }
        }
    }

    private boolean haveSameNumbers(List<Integer> numbers){
        for (Lotto lotto : lottos){
            List<Integer> tmp = lotto.getNumbers();
            if (tmp.equals(numbers)){
                return true;
            }
        }
        return false;
    }

    public void matchLottos(){
        for (Lotto lotto : lottos){
            int grade = calculateGrade(lotto);
            winCounts.set(grade, winCounts.get(grade) + 1);
        }

        calculateTotalPrize();
    }

    public float getEarningRate(){
        float ret = (float)calculateTotalPrize() / (float)inputMoney;
        return ret * 100;
    }

    public long calculateTotalPrize(){
        long total = 0;

        for (int i = 1; i < 6; i++){
            total += winCounts.get(i) * prizes.get(i);
        }

        return total;
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

    public void setWinNumbers(List<Integer> numbers){
        winNumbers = numbers;
    }

    public void setBonusNumber(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public int getInputMoney(){
        return inputMoney;
    }

    public int getWinCount(int idx){
        return winCounts.get(idx);
    }

    public List<Lotto> getLottos(){
        return lottos;
    }
}
