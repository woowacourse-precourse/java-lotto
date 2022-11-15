package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import lotto.data.dto.LottoBundleResponseDto;
import lotto.data.dto.LottoDto;
import lotto.type.MessageType;

public class LottoBundleResponseView {

    public LottoBundleResponseView() {}

    public String stringify(LottoBundleResponseDto lottoBundleResponseDto) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        List<LottoDto> lottos = lottoBundleResponseDto.getLottoDtos();
        stringJoiner.add(String.format(MessageType.COUNT_MESSAGE.getMessage(), lottos.size()));
        lottos.forEach(lottoDto -> stringJoiner.add(lottoDto.getNumbers().toString()));
        return stringJoiner.toString();
    }
}
