package Print;

public enum Error_Message {
	DEFAULT("[ERROR] "),
	INPUT_NUMBER("숫자를 입력해야 합니다."),
	INPUT_DIVIDE_TEN("1000원 단위로 입력해야 합니다."),
	INPUT_NUMBER_SIX("숫자를 여섯개 입력해야 합니다."),
	INPUT_NUMBER_DISTINCT("중복되지 않는 숫자를 입력해야 합니다."),
	INPUT_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
	
	String msg;
	
	Error_Message(String msg){
		this.msg = msg;
	}
	
	public String print_error() {
		return Error_Message.DEFAULT.msg + msg;
	}
}
