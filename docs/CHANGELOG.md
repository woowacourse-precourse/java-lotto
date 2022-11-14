style(Lotto): 사용하지 않는 import를 제거

test(EarningRateCalculateTest): 수익률 계산 기능의 테스트 코드를 추가

fix(LottoGenerator): 생성된 번호가 정렬되지 않는 문제 수정 및 가격이 음수일 때 예외 처리 추가

test(LottoGenerationTest): LottoGenerator로 생성한 Lotto가 요구사항에 부합하는지 검증하는 테스트를 작성

style(Application): 사용하지 않는 import 제거 및 공백 및 줄바꿈 변경

fix(EarningRateCalculator): 소수점 표현을 위한 원시 타입 변수를 포장

fix(Message): 입력의 유효하지 않을때 에러 메시지를 함수로 변경하여 제공

fix(WinningLotto): 보너스 번호의 유효성 검사 메소드를 LottoNumberValidator로 이동

fix(Application): 예외 상황 처리시 프로그램 종료 방식으로 변경

fix(Application,Message): 출력 형식을 지키기 위한 Message 및 출력 형식 변경

debug(LottoGenerator): 생성된 로또 번호 리스트를 정렬하는 기능 삭제

fix(Prize): getValues로 생성된 리스트의 순서 변경

feat(Application): 로또 게임 메인 로직 구현

feat(Prize): Lotto 등수 정보를 1등부터 5등까지 리스트로 전달하는 기능 추가

fix(LottoInfo): 로또 정보에 관한 변수들을 LottoInfo 클래스로 이동

fix(LottoComparator, EarningRateCalculator): 싱글톤 패턴으로 객체 생성 방법 수정

feat(EarningRateCalculator): 지불한 금액과 당첨 금액을 이용해 수익률 계산하는 기능 추가

fix(WinningLotto): isContain 메소드 삭제

test(LottoCompareTest): 당첨 내역을 비교하는 테스트하는 클래스 작성

fix(Prize): 당첨 내역이 존재하지 않을 때 null 리턴 하도록 변경

feat(LottoComparator): 로또 번호를 당첨 번호와 비교하는 기능을 구현

refactor(Lotto): 로또 번호의 검증 기능을 LottoNumberValidator 클래스로 분리함

feat(Prize): 로또 당첨 내역과 당첨금을 가지는 Prize 구현

feat(LottoGenerator): 로또 번호를 자동으로 생성하여 로또 객체를 생성하는 기능 추가

test(LottoTest): 생성한 로또가 유효한지 검증하는 테스트를 작성

feat(WinningLotto): 보너스 번호를 갖는 당첨 로또 클래스 구현

feat(Lotto): 로또 번호가 유효한 범위를 가지는지 검사하는 기능 추가

feat(Lotto): 로또 번호의 유효성을 검사하는 기능 추가

feat(ConsoleInputManager): 콘솔창에서 출력을 담당하는 클래스 생성

feat(ConsoleInputManager): 콘솔창에서 입력을 담당하는 클래스 생성

docs(README.md): 설계 문서 작성 및 구현할 기능 목록 추가

feat: setup precourse lotto project
