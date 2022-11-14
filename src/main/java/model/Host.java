package model;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
