package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResults {
    private List<LottoResult> lottoResults;
    private int firstPlace;
    private int secondPlace;
    private int thirdPlace;
    private int fourthPlace;
    private int fifthPlace;

    public LottoResults(List<LottoMachine> lottoMachines) {
        this.lottoResults = lottoMachines
                .stream()
                .map(machine -> machine.getResult())
                .collect(Collectors.toList());
        calcResult();
    }

    private void calcResult() {
        this.firstPlace = (int)this.lottoResults.stream().filter(s -> s == LottoResult.FIRST_PLACE).count();
        this.secondPlace = (int)this.lottoResults.stream().filter(s -> s == LottoResult.SECOND_PLACE).count();
        this.thirdPlace = (int)this.lottoResults.stream().filter(s -> s == LottoResult.THIRD_PLACE).count();
        this.fourthPlace = (int)this.lottoResults.stream().filter(s -> s == LottoResult.FOURTH_PLACE).count();
        this.fifthPlace = (int)this.lottoResults.stream().filter(s -> s == LottoResult.FIFTH_PLACE).count();
    }

    public int getFirstPlace() {
        return firstPlace;
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public int getFourthPlace() {
        return fourthPlace;
    }

    public int getFifthPlace() {
        return fifthPlace;
    }
}
