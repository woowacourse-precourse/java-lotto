package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // 보너스 숫자를 추가하는 메서드
    public void addBonus(int bonus){
        if(this.numbers.contains(bonus)) {
            System.out.println("[ERROR] 이미 선택한 숫자입니다.");
            throw new IllegalArgumentException();
        }
        numbers.add(bonus);
    }

    // 로또 최종 맞춘 개수 확인
    public List<Grade> saveResult(List<List<Integer>> boughtLotto){
        List<Grade> gradeList = new ArrayList<>();
        for (List<Integer> lotto : boughtLotto) {
            int correct = calculCorrect(lotto);
            int bonus = 0;
            if (correct == 5) bonus = calculBonus(lotto);
            if(Grade.getGrade(correct,bonus) != null) gradeList.add(Grade.getGrade(correct, bonus));
        }
        return gradeList;
    }

    // 로또 번호맞추기 (보너스 제외)
    public int calculCorrect(List<Integer> boughtLotto){
        int correct = 0;
        List<Integer> correctNumbers = this.numbers.subList(0,6);
        for (Integer lotto : boughtLotto) {
            if (correctNumbers.contains(lotto)) correct++;
        }
        return correct;
    }

    // 보너스 번호 맞추기
    public int calculBonus(List<Integer> boughtLotto){
        int bonus = 0;
        if(boughtLotto.contains(this.numbers.get(6))) bonus++;
        return bonus;
    }

    // 당첨총액 산정
    public int totalPrice(List<Grade> gradeList){
        int totalPrice = 0;
        for(Grade grade : gradeList){
            totalPrice += grade.getReward();
        }
        return totalPrice;
    }

    // 당첨 금액 출력
    public void printResult(List<Grade> gradeList){
        System.out.println("3개 일치 (5,000원) - " + Collections.frequency(gradeList, Grade.FIFTH) +"개");
        System.out.println("4개 일치 (50,000원) -" + Collections.frequency(gradeList, Grade.FOURTH) +"개");
        System.out.println("5개 일치 (1,500,000원) - " + Collections.frequency(gradeList, Grade.THIRD) +"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + Collections.frequency(gradeList, Grade.SECOND) +"개");
        System.out.println("6개 일치 (2,000,000,000원) - " + Collections.frequency(gradeList, Grade.FIRST) +"개");
    }
}
