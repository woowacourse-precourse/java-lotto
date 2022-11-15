package lotto.applications;

import lotto.domains.Lotto;
import lotto.domains.Place;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class GameServiceTest {
    private static final GameService gameService = GameService.getInstance();

    @Nested
    class Describe_getNumberOfLotto {
        @Nested
        class Context_when_gives_money {
            private static final int money = 8000;

            @Test
            void It_returns_number_of_lotto() {
                int numberOfLotto = gameService.getNumberOfLotto(money);
                assertThat(numberOfLotto).isEqualTo(8);
            }

        }
    }

    @Nested
    class Describe_createLotteries {
        @Nested
        class Context_when_gives_numberOfLotto {
            private static final int numberOfLotto = 8;

            @Test
            void It_returns_lotto_list() {
                List<Lotto> lotteries = gameService.createLotteries(numberOfLotto);
                assertThat(lotteries).isNotEmpty();
                assertThat(lotteries).isNotNull();

                Lotto lotto = lotteries.get(0);
                List<Integer> numbers = lotto.getNumbers()
                        .stream()
                        .sorted()
                        .collect(Collectors.toList());

                assertThat(numbers.get(0)).isBetween(1,45);
            }
        }
    }

    @Nested
    class Describe_getRewardMap {
        @Nested
        class Context_when_gives_valid_parameters  {
            Lotto lotto = new Lotto(List.of(1,2,3,4,5,6), 7);
            List<Lotto> userBoughtLotteries = List.of(lotto);

            @Test
            void It_returns_reward_map() {
                Map<Place, Integer> rewardMap = gameService.getRewardMap(userBoughtLotteries, lotto);
                assertThat(rewardMap.get(Place.FIRST)).isEqualTo(1);
            }
        }
    }

    @Nested
    class Describe_geProfitResult {
        @Nested
        class Context_when_gives_money_and_valid_prize_map  {
            private static final int money = 1000;
            private final Map<Place, Integer> prizeMap = new HashMap<>();

            @BeforeEach
            void setUp() {
                prizeMap.put(Place.FIRST, 1);
            }

            @Test
            void It_returns_reward_map() {
                double profitResult = gameService.getProfitResult(money, prizeMap);
                assertThat(profitResult).isEqualTo(200000000);
            }
        }
    }

}
