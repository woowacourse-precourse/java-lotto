package lotto.view;

public enum OutputLottoResult {
    OUTPUT_FIFTH_PRIZE("3개 일치 (5,000원) - %d개"),
    OUTPUT_FORTH_PRIZE("4개 일치 (50,000원) - %d개"),
    OUTPUT_THIRD_PRIZE("5개 일치 (1,500,000원) - %d개"),
    OUTPUT_SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    OUTPUT_FIRST_PRIZE("6개 일치 (2,000,000,000원) - %d개");

    private static final OutputLottoResult[] OUTPUT_LOTTO_RESULTS = OutputLottoResult.values();
    private final String outputMessage;

    OutputLottoResult(String outputMessage) {
	this.outputMessage = outputMessage;
    }

    public String getValue() {
	return outputMessage;
    }

    public static OutputLottoResult of(int index) {
	return OUTPUT_LOTTO_RESULTS[index];
    }
}
