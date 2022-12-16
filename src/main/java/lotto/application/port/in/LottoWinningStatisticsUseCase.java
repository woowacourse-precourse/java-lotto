package lotto.application.port.in;

import lotto.application.port.in.dto.RequestAnalyzeRevenueDto;
import lotto.application.port.in.dto.ResponseAnalyzeRevenueDto;

public interface LottoWinningStatisticsUseCase {
    ResponseAnalyzeRevenueDto analyzeRevenue(
            RequestAnalyzeRevenueDto requestAnalyzeResponseDto, int count);


}
