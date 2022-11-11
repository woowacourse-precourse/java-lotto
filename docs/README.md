미션 - 로또
-

- [ ] 사용자의 입력을 검사함 - Class InputException
  - [x] 사용자가 입력한 돈이 마이너스일 경우 IllegalArgumentException 예외 처리 구현 - checkBuyerInputIsMinus()
  - [x] 사용자가 입력한 돈이 숫자가 아닐 경우 IllegalArgumentException 예외 처리 구현 - checkBuyerInputIsNotNumber()
  - [x] 사용자가 입력한 돈이 1000원 단위로 나누어 떨어지지 않을 경우 IllegalArgumentException 예외 처리 구현 - checkBuyerInputIsNotDivided()
  - [x] 사용자가 입력한 당첨 번호가 1~45가 아닐 경우 IllegalArguemntException 예외 처리 구현 - checkBuyerInputIsNotNumberRange()
  - [x] 사용자가 입력한 당첨 번호에 ','의 5개가 아닐 경우 IllegalArguemntException 예외 처리 구현 - checkBuyerInputIsNotFiveComma()
  - [x] 사용자가 입력한 당첨 번호가 6개가 아닐 경우 IllegalArguemntException 예외 처리 구현
  - [ ] 사용자가 입력한 보너스 번호에 숫자 이외의 문자가 있을 경우 IllegalArguemntException 예외 처리 구현

- [ ] 로또 구매자 - Class LottoBuyer
  - [ ] 로또를 구매할 돈을 입력 구현
  - [ ] 로또의 당첨 번호를 입력 구현
  - [ ] 로또의 보너스 번호를 입력 구현

- [ ] 복권 - Class Lotto
  - [ ] 로또 마킹 기능 구현

-[ ] 로또 판매자 - Class LottoSeller
  - [ ] 랜덤 마킹 구현

-[ ] 로또 통계 - Class Statistics
  - [ ] 사용자가 구매한 로또의 당첨 여부 구현
  - [ ] 당첨된 로또 등수 판별 구현
  - [ ] 당첨된 로또 등수별 당첨 갯수 구현
  - [ ] 총 수익률 출력 구현

-[ ] 유틸 - Class Util
  - [x] 문자열이 숫자열인지 아닌지 판별 여부 구현 - isNumberic()
  - [x] 문자열이 1000으로 나누어 떨어지는지 판별 여부 - isDividedBuyThousand()
  - [x] 문자열내의 특정 문자의 갯수를 반환 기능 구현 - countChar()
  - [x] 문자열을 특정 문자열을 기준으로 나누는 기능 구현 - splitInteger()