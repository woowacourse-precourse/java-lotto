package lotto.application.port.in.dto;

public class ResponseMatchDto {

    int rank;
    double rateOfReturn;

    /**
     * 5등 이하는 -1 로 처리.
     * @param rateOfReturn
     */
    public ResponseMatchDto(double rateOfReturn) {
        this.rank = -1;
        this.rateOfReturn = rateOfReturn;
    }

    public ResponseMatchDto(int rank, double rateOfReturn) {
        this.rank = rank;
        this.rateOfReturn = rateOfReturn;
    }

    public int getRank() {
        return rank;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
