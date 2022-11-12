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

    public void checkInputBonusIsValid(String bonus) {
        try {
            checkNumberFormatOrThrows(bonus);
            int bonusNum = Integer.parseInt(bonus);
            checkNumberArea(bonusNum);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw new IllegalArgumentException();
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
