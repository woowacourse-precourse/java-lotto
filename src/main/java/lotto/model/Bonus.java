package lotto.model;


public class Bonus {
    private final int bonusNumber;
    private static final String REGEX="^[1-9]{1}$|^[1-3]{1}[0-9]{1}$|^4{1}[0-5]{1}$";

    public Bonus(int bonusNumber){
        validateValue(bonusNumber);
        this.bonusNumber=bonusNumber;
    }


}