## 기능 구현 목록

- [x] 로또 구입 금액을 입력받는 기능 - Input#inputCoin()
  - [x] 1,000원 단위가 아닐시 예외 처리 - Input#coinError()
- [x] 구입 개수만큼 랜덤 번호를 부여(1~45) - NumberGenerator#createRandomNumber()
  - [x] 랜덤 번호를 부여한 로또 출력
- [x] 6자리 번호를 입력 받음 - Input#inputWinningNumber()
- [x] 1자리 보너스 번호를 입력 받음 - Input#inputBonusNumber()
- [x] 당첨 번호를 입력받는 기능((,)를 기준으로 구분) - Input#inputNumber()
  - [x] 입력받은 숫자에 반복되는 숫자가 있을 시 에러처리 - Error#numberRepeatError()
  - [x] 입력받은 숫자에 1~45 사이의 숫자가 아닐 시 에러처리 - Error#numberRangeError()
- [x] 몇 개의 숫자가 일치하는지 확인 기능 - NumberCompare#compare()
- [x] 등수 마다 일치 여부 개수 출력하는 기능 - Output#outputLottoRank()
- [x] 로또 당첨 수익 구하는 기능 - Calculator#revenue()
- [x] 로또 당첨 수익률 구하는 기능(소수 둘째자리 반올림) - Calculator#yield()