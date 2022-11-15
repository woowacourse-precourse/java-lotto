package lotto.mvc.dto.output;

import lotto.mvc.model.LottoStore;

public final class OutputPlayerInfoDto {

    private final String playerInfo;

    public OutputPlayerInfoDto(final LottoStore lottoStore) {
        this.playerInfo = lottoStore.findPlayerInfo();
    }

    public String getPlayerInfo() {
        return playerInfo;
    }
}
