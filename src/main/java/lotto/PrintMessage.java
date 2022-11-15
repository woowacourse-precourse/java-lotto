package lotto;


public enum PrintMessage{
	
	INPUT_NUMBER("당첨 번호를 입력해 주세요."),
	INPUT_BONUS("보너스 번호를 입력해 주세요."),
	INPUT_MONEY("구입 금액을 입력해 주세요."),
	INPUT_DUPLICATE_ERR("[ERROR] 중복된 번호는 허용하지 않습니다."),
	INPUT_DEFINE_ERR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");

	private final String message;
	
	PrintMessage(String message) {
		this.message = message;
	}
	
	//public void printMessage(PrintMessage message) {
	//	 System.out.println(message.message);
	//}
	public String getName() {
		return message;
	}
	
}