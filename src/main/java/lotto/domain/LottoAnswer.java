package lotto.domain;

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

    public int checkInputBonusIsValid(String bonus) {
        checkNumberFormat(bonus);
        int bonusNum = Integer.parseInt(bonus);
        checkNumberArea(bonusNum);
        return bonusNum;
    }

    private void checkNumberFormat(String bonus){
        try{
            Integer.parseInt(bonus);
        }catch (NumberFormatException e){
            System.out.println("[ERROR] 보너스 번호 입력이 잘못 되었습니다.");
            throw new IllegalArgumentException();
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
