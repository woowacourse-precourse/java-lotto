package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    public static final int SECOND_WINNER_COUNT = 7;
    public Lotto(List<Integer> numbers) {
        isUnique(numbers);
        validate(numbers);
        this.numbers = numbers;
    }
    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            System.out.println("[ERROR] 로또 번호는 6개 입력되어야 합니다.");
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개 입력되어야 합니다.");
        }
        for (int i = 0; i < 6; i++) {
            if (numbers.get(i) < 1 || numbers.get(i) > 45) {
                System.out.println("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이여야 합니다.");
            }
        }
    }
    public void isUnique(List<Integer> numbers) {
        if (numbers.size()!=Arrays.asList(numbers.stream().distinct().toArray()).size()){
            System.out.println("[ERROR]: 중복된 입력은 불가합니다");
            throw new IllegalArgumentException();
        }
    }
    public LottoProperties lotteryCheck(Lotto awardLotto, int bonusNumber){
        int correct = numberCheck(awardLotto,bonusNumber);
        LottoProperties lottoProperties = LottoProperties.findType(correct);
        if (lottoProperties == LottoProperties.LOTTO_THIRDWINNER && isBonusCorrect(bonusNumber) == true){
            lottoProperties = LottoProperties.LOTTO_SECONDWINNER;
        }
        return lottoProperties;
    }
    public int numberCheck(Lotto awardLotto,int bonusNumber){
        int correct = 0;
        int i =0;
        int j =0;
        int inputNumber;
        int awardNumber;
        while (i<numbers.size() && j<awardLotto.getNumbers().size()) {
            inputNumber = numbers.get(i);
            awardNumber = awardLotto.getNumbers().get(i);
            if (inputNumber == awardNumber) {
                correct++;
                i++;
                j++;
            }
            if (inputNumber < awardNumber) {
                i++;
            }
            if (awardNumber < inputNumber) {
                j++;
            }
        }
        return correct;
    }
    public Boolean isBonusCorrect(int bonusNumber){
        for(int i =0;i<numbers.size();i++){
            if (bonusNumber==numbers.get(i)){
                return true;
            }
        }
        return false;
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
