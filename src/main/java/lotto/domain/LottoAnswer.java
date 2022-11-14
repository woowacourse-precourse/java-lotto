package lotto.domain;

import java.util.NoSuchElementException;

public class LottoAnswer extends Lotto {

    private int bonusNumber;

    public LottoAnswer(String numbers, String bonusNumber) {
        super((numbers));
        this.bonusNumber = makeBonus(bonusNumber);
    }

    public int makeBonus(String bonus){
        checkInputBonusIsValid(bonus);
        return Integer.parseInt(bonus);
    }

    public void checkInputBonusIsValid(String bonus) {
        try {
            checkNumberFormatOrThrows(bonus);
            int bonusNum = Integer.parseInt(bonus);
            checkNumberArea(bonusNum);
            checkDuplicatedNumberOrThrows(bonusNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new NoSuchElementException();
        }
    }

    protected void checkDuplicatedNumberOrThrows(int bonus){
        if(numbers.contains(bonus)){
            throw new IllegalArgumentException("[ERROR] 숫자는 중복될 수 없습니다.");
        }
    }

    private void checkNumberFormatOrThrows(String bonus){
        try{
            Integer.parseInt(bonus);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 보너스 번호 입력이 잘못 되었습니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
