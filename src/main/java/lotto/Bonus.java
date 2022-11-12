package lotto;

public class Bonus {
    private int bonus;

    public Bonus(int bonus, Lotto winningLotto) {
        isValidData(bonus, winningLotto);
        this.bonus = bonus;
    }

    private void isValidData(int bonus, Lotto winningLotto) {
        if (!(bonus >= 1 && bonus <= 45)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
        if (winningLotto.getNumbers().contains(bonus)){
            throw new IllegalArgumentException("중복되는 번호를 보너스 번호로 선택할 수 없습니다.");
        }
    }

    public int getBonus() {
        return this.bonus;
    }
}
