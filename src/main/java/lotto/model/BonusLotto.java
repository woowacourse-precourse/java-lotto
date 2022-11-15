package lotto.model;

public class BonusLotto {
    private int bonusNumber;

    public BonusLotto(String input){
        try {
            int number = Integer.parseInt(input);
            if(number <= 0 || number > 45){
                throw  new IllegalArgumentException();
            }
            this.bonusNumber = number;
        } catch (IllegalArgumentException e){
            throw  new IllegalArgumentException("[ERROR] 알맞은 숫자를 입력해주세요.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
