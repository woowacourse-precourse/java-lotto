package lotto.application.service;

import lotto.application.port.in.dto.RequestAnalyzeRevenueDto;
import lotto.application.port.in.dto.ResponseAnalyzeRevenueDto;
import lotto.domain.reward.Reward;
import lotto.domain.reward.RewardTable;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningStatisticsServiceTest {

    LottoWinningStatisticsService service;

    @BeforeEach
    void init() {
        service = new LottoWinningStatisticsService();
    }

    @Test
    void analyzeRevenueTest() {
        //given
        Reward reward1 = Reward.FIFTH;
        List<Reward> rewards = new ArrayList<>();
        rewards.add(reward1);

        RewardTable rewardTable = new RewardTable(rewards);
        RequestAnalyzeRevenueDto requestDto = new RequestAnalyzeRevenueDto(rewardTable);

        //when
        ResponseAnalyzeRevenueDto responseDto = service.analyzeRevenue(requestDto, 5);

        //then
        assertThat(responseDto.getRevenueAverage()).isEqualTo(100.0);
    }


}