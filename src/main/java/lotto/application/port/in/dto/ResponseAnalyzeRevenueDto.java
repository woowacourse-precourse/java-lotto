package lotto.application.port.in.dto;

public class ResponseAnalyzeRevenueDto {
    double revenueAverage;

    public ResponseAnalyzeRevenueDto(double revenueAverage) {
        this.revenueAverage = revenueAverage;
    }

    public double getRevenueAverage() {
        return revenueAverage;
    }
}
