package lotto.view;

import java.text.MessageFormat;
import java.util.List;
import lotto.dto.LottoInformationDto;

public enum OutputView {
    INSTANCE;

    private static final String LOTTO_COUNT_MESSAGE = "\n{0}개를 구매했습니다.";
    private static final String LOTTO_INFO_MESSAGE = "\n{0}";

    public void printLottoInformation(LottoInformationDto lottoInformationDto) {
        System.out.println(generateLottoInformation(lottoInformationDto));
    }

    private String generateLottoInformation(LottoInformationDto lottoInformationDto) {
        StringBuilder sb = new StringBuilder();
        sb.append(MessageFormat.format(LOTTO_COUNT_MESSAGE, lottoInformationDto.getSize()));
        for (List<Integer> lotto : lottoInformationDto.getLottoTicket()) {
            sb.append(MessageFormat.format(LOTTO_INFO_MESSAGE, lotto));
        }
        return sb.toString();
    }
}

