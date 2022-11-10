package lotto;

public class EarningsRate {

    public Long calculationTotalPrizeMoney() {
        Long fifth = WinnersCase.FIFTH.getPrizeMoney();
        Long fourth = WinnersCase.FOURTH.getPrizeMoney();
        Long third = WinnersCase.THIRD.getPrizeMoney();
        Long second = WinnersCase.SECOND.getPrizeMoney();
        Long first = WinnersCase.FIRST.getPrizeMoney();

        return fifth + fourth + third + second + first;
    }

    public String calculationEarningsRate(String amount) {
        Double principal = Double.valueOf(amount);
        Double totalPrizeMoney = Double.valueOf(calculationTotalPrizeMoney());

        double earningsRate = totalPrizeMoney / principal * 100;

        return String.format("%,.1f", earningsRate);
    }

}