package lotto;

public class Bonus_number {

    private final String Bonus_Input;

    public Bonus_number(String Bonus_Input) {
        Bonus_number_validate(Bonus_Input);
        this.Bonus_Input = Bonus_Input;
    }

    private void Bonus_number_validate(String Bonus_Input) {
        try {
            Integer number = Integer.parseInt(Bonus_Input);
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }

    }
}
