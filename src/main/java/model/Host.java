package model;

import java.util.List;

public class Host {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public int           bonusNumber  (){ return bonusNumber; }
    public List<Integer> winningNumber(){ return winningNumber;}

    public Host(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }


}
