package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import lotto.data.dto.LottoBundleDto;
import lotto.data.dto.LottoDto;
import lotto.type.MessageType;

public class LottoBundleView {

    public LottoBundleView() {}

    public String stringify(LottoBundleDto lottoBundleDto) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        List<LottoDto> lottos = lottoBundleDto.getLottos();
        stringJoiner.add(String.format(MessageType.COUNT_MESSAGE.getMessage(), lottos.size()));
        lottos.forEach(lottoDto -> stringJoiner.add(lottoDto.getNumbers().toString()));
        return stringJoiner.toString();
    }
}
