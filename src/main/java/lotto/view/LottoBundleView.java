package lotto.view;

import java.util.List;
import java.util.StringJoiner;
import lotto.data.dto.LottoBundleDto;
import lotto.data.dto.LottoDto;

public class LottoBundleView {

    public LottoBundleView() {}

    private final String COUNT_MESSAGE = "%d개를 구입하셨습니다.";

    public String stringify(LottoBundleDto lottoBundleDto) {
        StringJoiner stringJoiner = new StringJoiner("\n");
        List<LottoDto> lottos = lottoBundleDto.getLottos();
        stringJoiner.add(String.format(COUNT_MESSAGE, lottos.size()));
        lottos.forEach(lottoDto -> stringJoiner.add(lottoDto.getNumbers().toString()));
        return stringJoiner.toString();
    }
}
