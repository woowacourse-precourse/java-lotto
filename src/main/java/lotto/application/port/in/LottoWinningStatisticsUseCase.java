package lotto.application.port.in;

import lotto.application.port.in.dto.RequestAnalyzeResponseDto;
import lotto.application.port.in.dto.ResponseAnalyzeRevenueDto;

public interface LottoWinningStatisticsUseCase {
    ResponseAnalyzeRevenueDto analyzeRevenue(
            RequestAnalyzeResponseDto requestAnalyzeResponseDto, int count);


}
