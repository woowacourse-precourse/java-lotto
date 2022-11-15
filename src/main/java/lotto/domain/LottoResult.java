package lotto.domain;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoResult {

    public static LinkedHashMap<MapMatchPrize, Integer> getWinningResult(final List<Integer> countMatchNumber,
                                                                         final List<Boolean> bonusInLotto) {
        LinkedHashMap<MapMatchPrize, Integer> result = init();

        for (int index = 0; index < countMatchNumber.size(); ++index) {
            int match = countMatchNumber.get(index);
            boolean bonus = bonusInLotto.get(index);
            MapMatchPrize mapMatchPrize = MapMatchPrize.find(match);
            result.put(checkMap(match, bonus, mapMatchPrize), result.get(MapMatchPrize.find(match)) + 1);
        }
        return result;
    }

    private static LinkedHashMap<MapMatchPrize, Integer> init() {
        LinkedHashMap<MapMatchPrize, Integer> result = new LinkedHashMap<>();

        for (MapMatchPrize mapMatchPrize : MapMatchPrize.values()) {
            result.put(mapMatchPrize, 0);
        }
        return result;
    }

    private static MapMatchPrize checkMap(final int matchNumber, final boolean bonusInLotto, MapMatchPrize mapMatchPrize) {
        if (matchNumber == MapMatchPrize.FIVE.getNumberOfMatch() && !bonusInLotto) {
            return MapMatchPrize.FIVE;
        }

        if (matchNumber == MapMatchPrize.FIVE_AND_BONUS.getNumberOfMatch() && bonusInLotto) {
            return MapMatchPrize.FIVE_AND_BONUS;
        }
        return mapMatchPrize;
    }
}
