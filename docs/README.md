## 기능목록

### 예외처리 - LottoIllegalArgumentException
- 모든 예외 메시지의 "[ERROR]" 를 앞에 붙여 출력.

### LottoServiceUseCase - Lotto 관련 기능 정의 인터페이스.
- 받은 금액을 통해 로또 티켓 출력. - buyLotto 

### View - 화면에 보여지는 것을 담당하는 클래스.
- [X] 로또 거래 View - BuyLottoView
  - [X] 구입금액 입력 View
  - [X] 구매한 로또의 정보를 보여주는 View
    - [X] 구매한 로또의 개수를 보여주는 View
    - [X] 구매한 로또의 번호를 보여주는 View

- [X] 당첨 로또에 대한 View - LottoAnswerView
  - [X] 당첨 번호 View
  - [X] 보너스 번호 View

- [ ] 당첨 결과에 대한 View - ResultView
  - [ ] 당첨 결과에 대한 View
  - [ ] 수익률에 대한 View
