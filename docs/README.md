## 기능목록

### 예외처리 - IllegalArgumentException
- [X] 모든 예외 메시지의 "[ERROR]" 를 앞에 붙여 출력. - ExceptionUtil.class

### LottoServiceUseCase - Lotto 관련 기능 정의 인터페이스.
- [X] 받은 금액을 통해 로또 티켓 생성. - LottoService.class
- [ ] 당첨로또번호와 몇개 일치 하는지 확인 -  

### 어플리케이션 (비즈니스 로직)
- [X] buyLotto 구현 - LottoService.class
- []

### 도메인 
#### Money
- 유효성 검사.(1000원 으로 나누어 떨어지는지.)

#### Bonus
- 유효성 검사

#### Lotto
#### ResultTable
- 유효성 검사

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
