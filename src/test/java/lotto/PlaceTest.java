package lotto;

import lotto.domain.Place;
import lotto.domain.PlaceStatus;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlaceTest {
    @Test
    void 등수_1등() {
        Place place = new Place(6,0);
        PlaceStatus result = place.selectPlace();
        assertThat(result).isEqualTo(PlaceStatus.FIRST);
    }

    @Test
    void 등수_2등() {
        Place place = new Place(5,1);
        PlaceStatus result = place.selectPlace();
        assertThat(result).isEqualTo(PlaceStatus.SECOND);
    }

    @Test
    void 등수_3등() {
        Place place = new Place(5,0);
        PlaceStatus result = place.selectPlace();
        assertThat(result).isEqualTo(PlaceStatus.THIRD);
    }

    @Test
    void 등수_4등() {
        Place place = new Place(4,0);
        PlaceStatus result = place.selectPlace();
        assertThat(result).isEqualTo(PlaceStatus.FOURTH);
    }

    @Test
    void 등수_5등() {
        Place place = new Place(3,0);
        PlaceStatus result = place.selectPlace();
        assertThat(result).isEqualTo(PlaceStatus.FIFTH);
    }

    @Test
    void 등수_낫싱() {
        Place place = new Place(2,0);
        PlaceStatus result = place.selectPlace();
        assertThat(result).isEqualTo(PlaceStatus.NOTHING);

        Place place2 = new Place(2,1);
        PlaceStatus result2 = place2.selectPlace();
        assertThat(result2).isEqualTo(PlaceStatus.NOTHING);
    }
}
