package lotto;

public class Bonus {
    private int bonus;

    public Bonus(int bonus){
        isValidData(bonus);
        this.bonus = bonus;
    }

    private void isValidData(int bonus){
        if(!(bonus >= 1 && bonus <= 45)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
