package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DrawerTest {

    private Drawer drawer;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        drawer = new Drawer();
        lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    }

    static Stream<Arguments> generateCompareData() {
        Lotto wonLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), wonLotto, Rank.FIRST),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 45)), wonLotto, Rank.SECOND),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 5, 7)), wonLotto, Rank.THIRD),
                Arguments.of(new Lotto(List.of(1, 2, 3, 4, 7, 8)), wonLotto, Rank.FOURTH),
                Arguments.of(new Lotto(List.of(1, 2, 3, 7, 8, 9)), wonLotto, Rank.FIFTH),
                Arguments.of(new Lotto(List.of(7, 8, 9, 10, 11, 12)), wonLotto, Rank.LOSE)
        );
    }


    @ParameterizedTest
    @MethodSource("generateCompareData")
    void compareTest(Lotto generatedLotto, Lotto wonLotto, Rank rank) {
        List<Lotto> lottoTickets = new ArrayList<Lotto>();
        lottoTickets.add(generatedLotto);
        Integer bonusNumber = Integer.valueOf(45);
        assertTrue(drawer.compare(lottoTickets, wonLotto, bonusNumber).contains(rank));
    }

}