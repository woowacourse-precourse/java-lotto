# 기능 분류서
- ### 로또 프로그램을 실행시킬 수 있다. [ # LottoProgram.run() ]
- ### 로또 구매 금액을 입력 받을 수 있다. [ # LottoProgram.getOrderPrice() ]
- ### 로또 구매 금액으로 로또 구매 수량을 구할 수 있다. [ # LottoService.getOrderQuantity(int orderPrice)]
  - 로또 1장은 1000원이다. [ # LottoService.LOTTO_PRICE ]
- ### 로또 구매 수량을 출력할 수 있다. [ # LottoProgram.alertOrderQuantity(int orderQuantity) ]
  - `N개를 구매했습니다.` 
- ### 로또 번호를 생성할 수 있다. [ # LottoFactory.createLottoNumbers() ]
  - 로또 번호는 랜덤으로 선택된다. [ # Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER, LOTTO_NUMBER_COUNT) ]
  - 로또 번호는 오름차순으로 정렬한다. [ # LottoFactory.sortInAscending(List<Integer> numbers) ]
- ### 구매한 로또 수 만큼 로또 번호를 생성할 수 있다. [ # LottoFactory.createLottos(int quantity) ]
  - 생성된 로또 번호를 모두 출력할 수 있다. [ # LottoFactory.alertUserLottos(List<Lotto> lottos) ]
- ### 입력 받은 숫자로 당첨 번호를 만들 수 있다. [LottoProgram.createWinningLotto()]
  - 당첨 번호는 서로 다른 6개의 숫자이다.
- ### 보너스 번호를 입력 받을 수 있다. [ # LottoProgram.getBonusNumber() ]
  - 보너슨 번호는 담청 번호와 중복되지 않는 1개의 번호이다.
- ### 당첨 로또는 6개의 당첨 번호와 1개의 보너스 번호로 이루어진다. [ # WinningLotto ]
- ## [ # LottoAccountant.getLottoResults ] 당첨 내역을 계산할 수 있다.
  - 당첨 숫자와 사용자 로또 숫자의 일치하는 숫자 갯수를 계산할 수 있다. [ # LottoResultMaker.countLottoNumberMatch ]
  - 보너스 숫자와 사용자 로또 숫자 사이에 일치하는 숫자가 있는지 확인할 수 있다. [ # LottoResultMaker.countBonusNumberMatch ]
  [ # LottoWinnings ]
  - ```
    - 3개 일치 시 5,000원
    - 4개 일치 시 50,000원
    - 5개 일치 시 1,500,000원
    - 5개 일치, 보너스 볼 일치 시 30,000,000원
    - 6개 일치 시 2,000,000,000원
  ```
    

- ### [ LottoAccountant.calculateRateOfReturn ] 총 수익률을 계산할 수 있다.
  - 수익률은 소숫점 둘째 자리에서 반올림한다.

- ### 당첨 통계를 콘솔에 출력할 수 있다.

- ### [  ] 사용자가 잘못된 값을 입력한 경우를 감지할 수 있다.
    - [  ] 로또 구매 금액이 1000으로 나누어 떨어지지 않는 경우
    - [  ] 로또 번호가 `1이상 45이하`를 벗어난 경우
    - [  ] 로또 번호가 중복되는 경우
- ### [  ] 사용자가 잘못된 값을 입력한 경우, 예외를 발생시키고 에러메시지를 출력할 수 있다.
    - 예외 상황에 `IllegalArgumentException`을 발생시킨다.
      - [  ] 로또 구매 금액이 1000으로 나누어 떨어지지 않는 경우
        - [  ] `[ERROR] 로또는 1000원 단위로 구매할 수 있습니다.`를 출력하고 프로그램을 종료 시킨다.
      - [  ] 로또 번호가 `1이상 45이하`를 벗어난 경우    
        - [  ] `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`를 출력하고 프로그램을 종료 시킨다.
      - [  ] 로또 번호가 중복되는 경우
        - [  ] `[ERROR] 로또 번호는 중복되지 않아야 합니다.`를 출력하고 프로그램을 종료시킨다.

***
🚀 기능 요구 사항

로또 게임 기능을 구현해야 한다. 로또 게임은 아래와 같은 규칙으로 진행된다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
      로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
      로또 1장의 가격은 1,000원이다.
      당첨 번호와 보너스 번호를 입력받는다.
      사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
      사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 종료한다.