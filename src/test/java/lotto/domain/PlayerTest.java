package lotto.domain;

import lotto.dto.GameResultResponseDtos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.dto.GameResultResponseDtos.GameResultResponseDto;
import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    @DisplayName("로또 플레이 후 결과 검증")
    @Test
    void playLotto() {
        Lottos lottos = LottosCashier.create(8000, createLottoNumbers());
        Player player = new Player(lottos, 8000);
        Answer answer = new Answer(List.of(1, 2, 3, 4, 5, 6), 7);

        GameResultResponseDtos responseDtos = player.playLotto(answer);
        GameResultResponseDto responseDto = responseDtos.getGameResultResponseDtos().get(0);

        assertThat(responseDtos.getEarningRate()).isEqualTo(62.5D);
        assertThat(responseDto.getSameNumberCount()).isEqualTo(3);
        assertThat(responseDto.getWinnerPrice()).isEqualTo(5000);
        assertThat(responseDto.getTotalCount()).isEqualTo(1);
    }

    private List<List<Integer>> createLottoNumbers() {
        return List.of(
                List.of(8, 21, 23, 41, 42, 43),
                List.of(3, 5, 11, 16, 32, 38),
                List.of(7, 11, 16, 35, 36, 44),
                List.of(1, 8, 11, 31, 41, 42),
                List.of(13, 14, 16, 38, 42, 45),
                List.of(7, 11, 30, 40, 42, 43),
                List.of(2, 13, 22, 32, 38, 45),
                List.of(1, 3, 5, 14, 22, 45)
        );
    }
}
