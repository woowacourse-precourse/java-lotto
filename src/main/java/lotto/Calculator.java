package lotto;

public class Calculator {
    private Lotto winNumbers;
    private Integer bonusNumber;

    public Calculator(Lotto lotto, Integer bonus) {
        this.winNumbers = lotto;
        this.bonusNumber = bonus;
    }

    // public void calculate(Lotto generatedNumbers) {
    //     calcul and save earnings somewhere;
    // }
}
