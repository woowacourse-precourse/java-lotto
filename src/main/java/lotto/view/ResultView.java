package lotto.view;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lotto.domain.Prize;
import lotto.dto.LottoNumbersDTO;
import lotto.dto.RoundResult;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class ResultView {
    public static void printLottoNumbers(List<LottoNumbersDTO> lottoNumbers) {
        System.out.printf("%d개를 구매했습니다.%n", lottoNumbers.size());
        lottoNumbers.forEach(ResultView::printLottoNumbers);
    }

    private static void printLottoNumbers(LottoNumbersDTO lottoNumbersDTO) {
        List<String> numbers = lottoNumbersDTO.getLottoNumbers()
                .stream()
                .mapToInt(Integer::valueOf)
                .mapToObj(Integer::toString)
                .collect(Collectors.toList());
        String lottoFormat = String.format("[%s]", String.join(",", numbers));
        System.out.println(lottoFormat);
    }

    public static void printResult(RoundResult roundResult) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        printByPrize(roundResult.getPrizes());
        System.out.printf("총 수익률은 %.2f%% 입니다.%n", roundResult.getRateOfReturn()*100);
    }

    private static void printByPrize(List<Prize> prizes) {
        Map<Prize, Long> prizeCountMap = prizes.stream()
                .collect(groupingBy(p -> p, HashMap::new, counting()));


        Arrays.stream(Prize.values())
                .filter(prize -> prize != Prize.NOTHING)
                .forEach(prize -> {
                    long count = prizeCountMap.getOrDefault(prize, 0L);
                    String message = makeResultMessage(prize, count);
                    System.out.println(message);
                });
    }

    private static String makeResultMessage(Prize prize, long count) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("%d개 일치 ", prize.getCondition()));
        if (prize == Prize.SECOND) {
            stringBuilder.append(", 보너스 볼 일치");
        }
        stringBuilder.append(String.format("(%d원) -%d개", prize.getWinnings().intValue(), count));
        return stringBuilder.toString();
    }
}
