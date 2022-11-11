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
        LotteryExceptionCase exceptionCase = new LotteryExceptionCaseImpl();
        exceptionCase.characterCheck(amount);
        Double principal = Double.valueOf(amount);
        Double totalPrizeMoney = Double.valueOf(calculationTotalPrizeMoney());

        double earningsRate = totalPrizeMoney / principal * 100;

        return String.format("%,.1f", earningsRate);
    }

    public void printStatistics() {
        System.out.println(WinnersCase.FIFTH.getRanking() + WinnersCase.FIFTH.getCount() + "개");
        System.out.println(WinnersCase.FOURTH.getRanking() + WinnersCase.FOURTH.getCount() + "개");
        System.out.println(WinnersCase.THIRD.getRanking() + WinnersCase.THIRD.getCount() + "개");
        System.out.println(WinnersCase.SECOND.getRanking() + WinnersCase.SECOND.getCount() + "개");
        System.out.println(WinnersCase.FIRST.getRanking() + WinnersCase.FIRST.getCount() + "개");
    }

}