# 미션 - 로또

이 프로젝트는 2022년 우아한 테크코스-프리코스의 3주차 미션인 '로또'를 수행한 것으로, 1) 클래스를 분리하고, 2) 도메인 로직에 대한 단위 테스트를 작성하는 법을 익히는 것을 목표로 한다.

## 기능 목록

+ 형식 : 기능 설명 - 소속 클래스 #메소드 명(혹은 생성자)
+ 들여쓰기의 의미: 함수의 부분 기능을 담당하지만 따로 분리되었을때. 들여쓰기된 기능은 상위 기능에 의해 호출된다.

[도메인]

- 로또 금액 만큼 로또를 발행한다. - LottoGenerator #generateLottos()
    - 로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외 처리한다 - LottoGenerator #validate()
    - 발행할 로또 개수를 구한다. - LottoGenerator #getIssueCount()
    - 1개의 로또를 발행한다.(1부터 45까지의 숫자 중 서로 다른 숫자 6개 숫자를 뽑는다) - LottoGenerator #generateLotto()
- 발행된 로또를 저장한다. - Lotto #Lotto()
    - 발행된 로또가 유효한지 검사한다 - Lotto #validate()
        - 숫자가 1~45사이를 벗어나는지 확인한다. - Lotto #isOutOfRange()
        - 숫자가 중복되는지 확인한다. - Lotto #hasDuplication()
- 총 발행된 로또들, 구입 금액, 총 로또 수를 저장한다. - Lottos #Lottos()
- 해당 회차의 당첨 숫자 및 보너스 숫자를 저장한다. - WinningNumbers - WinningNumbers()
    - 당첨 숫자 및 보너스 숫자가 유효한지 검사한다 - WinningNumbers #validate()
        - 숫자가 1~45사이를 벗어나는지 확인한다. - WinningNumbers #isOutOfRange()
        - 숫자가 중복되는지 확인한다. - WinningNumbers #hasDuplication()
- 매 로또마다 몇 개의 숫자가 당첨 숫자와 일치하는지 확인한다. - LottoCalculator #calculate()
    - 각 숫자가 당첨 숫자에 포함되는지 확인한다. - WinningNumbers #contains()
    - 각 숫자가 보너스 숫자와 일치하는 확인한다. - WinningNumbers #isEqualToBonusNumber()
    - 당첨된 숫자 개수를 저장한다. - Lottos #setResultOfLotto()
- 전체 로또에 대해서 수익률을 계산한다. -LottoCalculator #calculateEarningsRatio()
    - 수익률을 저장한다. -Lottos #setEarningsRatio()

[입, 출력]

- 로또 구입 금액을 입력받는다.
    - '구입 금액을 입력해 주세요.' 출력
    - 숫자가 아닌 수를 입력할 경우 예외를 발생시킨다.
- 총 로또 구입 갯수를 출력한다.
- 각 로또 번호를 출력한다.
- 당첨 번호를 입력받는다.
    - '당첨 번호를 입력해 주세요.' 출력
    - ','와 숫자를 제외한 입력이 들어있으면 예외를 발생시킨다.
    - ','를 기준으로 분리한다.
- 보너스 번호를 입력받는다.
    - '보너스 번호를 입력해 주세요.' 출력
    - 숫자가 아닌 수를 입력할 경우 예외를 발생시킨다.
- 당첨 통계 출력
    - '당첨 통계\n---' 출력
    - 1~5등 각 등수별 통계 내림차순 출력: n개 일치 (#,###원) - x개.
    - 수익률 출력.