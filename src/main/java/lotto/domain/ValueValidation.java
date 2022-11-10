package lotto.domain;

public class ValueValidation {

    public void checkDividedByThousand(int value){
        if(value % 1000 != 0){
            throw new IllegalArgumentException();
        }
    }

}
