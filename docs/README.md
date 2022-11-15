## 기능 목록
-[x] 구입금액을 입력할 경우 해당 금액에 맞는 개수 만큼 로또 번호를 생성 LottoGenerator
  -[x] 사용자로 부터 구매 금액을 입력 받고, 해당 금액에 맞는 로또 구매 개수를 구한다. LottoGenerator#inputMoney()
      -[x] __<예외>__ 구매 금액이 1,000원으로 나누어 떨어지지 않을 경우 예외 처리한다.           
  -[x] 로또 구매 개수만큼 로또 번호를 생성한다. LottoGenerator#numberGenerator() -> finalGenerator()
- [x] 사용자로부터 번호를 입력 받아 로또 당첨번호를 생성 WinningNumberInPut 
  -[x] 사용자로부터 6개의 당첨 번호를 쉼표로 구분하여 입력받는다. WinningNumberInPut # winningNumberInput()
      -[x] __<예외>__ 입력받은 당첨 번호가 쉼표로 나누어지지 않을 경우 예외 처리 한다.
      -[x] __<예외>__ 입력받은 당첨 번호가 여섯개가 아닌 경우 예외 처리 한다.
      -[x] __<예외>__ 입력받은 당첨 번호가 1~45의 범위가 아닐 경우 예외 처리 한다.
  -[x] 사용자로부터 보너스 번호를 입력받는다. WinningNumberInPut # bonusNumberInput()
      -[x] __<예외>__ 입력받은 당첨 번호가 1~45의 범위가 아닐 경우 예외 처리 한다.
      -[x] __<예외>__ 입력받은 당첨 번호가 6개의 당첨 번호와 중복 될 경우 예외 처리 한다.
-[x] 구입한 로또 번호와 당첨번호를 비교하여 등수 별 당첨 개수 생성 WinnerGenerator# compare()

## 추가 구현 항목
- [x] 각 게임에 맞는 메시지 리턴 기능 순차 구현 util # Message
- [x] Error 메시지 정리 
