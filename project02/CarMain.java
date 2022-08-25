package project02;

//import java.util.InputMismatchException;
import java.util.Scanner;

public class CarMain {

    private static Scanner scanner = new Scanner(System.in);
    private static Car myCar = new Car();
 
    //자동차 프로그램 메인 코드
    public static void main(String[] args) {
    	
    	long startTime = System.currentTimeMillis();
        boolean run = true;
        int selectNo = 0;
        
        System.out.println("\n\t      자동차가 출발합니다, 안전 운전 하세요.\n");
        
        //자동차 메뉴 선택 무한 반복문
        while(run) {
        	try {
        		System.out.println("\n--------------------- < 메뉴 선택 > ----------------------");
                System.out.println("--------------------------------------------------------");
                System.out.println("1.기어 변속 | 2.현재 속도 | 3.타이어 교체 | 4.창문 | 5.와이퍼 선택 | ");
                System.out.println("6.깜빡이 선택 | 7.자동차의 현재 상태 보여주기 | 8.급브레이크 | 9.종료");
                System.out.println("--------------------------------------------------------");
                System.out.print("선택 >> ");
     
                selectNo = scanner.nextInt();
                
                System.out.println();
     
                if(selectNo == 1) {
                	gearShift();
                } else if(selectNo == 2) {
                	currentSpeed();
                } else if(selectNo == 3) {
                	tireReplacement();
                } else if(selectNo == 4) {
                	window();
                } else if(selectNo == 5) {
                	wiper();
                } else if(selectNo == 6) {
                	blinker();
                } else if(selectNo == 7) {
                	currentStateOfTheCar();
                } else if(selectNo == 8) {
                	suddenBreak();
                } else if(selectNo == 9) {
                	System.out.println("9. 종료");
                    run = false;
                } else {
                	System.out.println("잘못 입력하셨습니다. 다시 입력하세요! (입력값 : 1 ~ 9)\n");
                }
			} catch (Exception e) {
				scanner = new Scanner(System.in);
				System.out.println("\n잘못 입력하셨습니다. (정수만 입력 가능)\n");
//				e.printStackTrace();
			}
        }
        
        long endTime = System.currentTimeMillis();
        
        //운행 시간(MilliSecond)을 시, 분, 초로 저장
        int second = (int) ((endTime - startTime) / 1000) % 60;
        int minute = (int) ((endTime - startTime) / 1000 / 60) % 60;
        int hour = (int) (endTime - startTime) / 1000 / 60 / 60;
        
        System.out.println("\nㅇ 운행 시간 : " + hour + "시간 " + minute + "분 " + second + "초");
        System.out.println("ㅇ 안녕히계세요.");
    }
    
    //자동차 기어 선택 메소드
    private static void gearShift() {
    	System.out.println("1. 몇 단(단수입력)? [ 1, 2, 3, 4, 5, 6, R 중에 하나 입력 ]");
    	while(true) {
	    	System.out.print("사용자 입력 >> ");
	    	String selectGear = scanner.next();
	    	
	    	if(selectGear.equals("1") || selectGear.equals("2") || selectGear.equals("3") || 
	    		selectGear.equals("4") || selectGear.equals("5") || selectGear.equals("6") || selectGear.equals("R")) {
	    		myCar.setSpeedAndGear(selectGear+"단");
	    		System.out.println("\n기어를 " + selectGear + "단으로 변경합니다.");
	    		break;
	    	} else {
	    		System.out.println("\n잘못 입력하셨습니다. 다시 입력하세요! (입력값 : 1, 2, 3, 4, 5, 6, R)");
	    	}
    	}
    }
    
    //자동차의 현재 속도 출력 메소드
    private static void currentSpeed() {
    	System.out.println("2. [ 현재 속도 ]");
    	System.out.println(myCar.getGear() + " : " + myCar.getSpeed());
    }
    
    //자동차의 타이어 종류 선택 메소드
    private static void tireReplacement() {
    	System.out.println("3. 타이어 선택 (1.미쉐린, 2.금호, 3.한국타이어, 4.컨티넨탈)");
    	while(true) {
	    	System.out.print("타이어 선택 >> ");
	    	int num = scanner.nextInt();
	    	
	    	if(num == 1 || num == 2 || num == 3 || num == 4) {
	    			System.out.println();
		    		myCar.setTire(num);
		    		myCar.tire.tireState();
		    		System.out.println("를 선택하셨습니다.");
		    		break;
	    	} else {
	    		System.out.println("\n잘못 입력하셨습니다. 다시 입력하세요! (입력값 : 1, 2, 3, 4)");
	    	}
    	}
    }

    //자동차 전 좌석 창문 열기, 닫기 선택 메소드
	private static void window() {
		System.out.println("4-1. 창문 개폐 선택 (1.열기, 2.닫기)");
		int selectOpenAndClose = 0;
		int selectWindow = 0;
		
    	while(true) {
	    	System.out.print("개폐 선택 >> ");
	    	selectOpenAndClose = scanner.nextInt();
	    	
	    	if(selectOpenAndClose == 1 || selectOpenAndClose == 2) {
		    	break;
	    	} else {
	    		System.out.println("\n잘못 입력하셨습니다. 다시 입력하세요! (입력값 : 1, 2)");
	    	}
    	}
    	
    	System.out.println("\n4-2. 창문 선택 (1.운전석, 2.조수석, 3.뒷창문 오른쪽, 4.뒷창문 왼쪽)");
    	while(true) {
	    	System.out.print("창문 선택 >> ");
	    	selectWindow = scanner.nextInt();
	    	
	    	if(selectWindow == 1 || selectWindow == 2 || selectWindow == 3 || selectWindow == 4) {
	    		System.out.println();
	    		myCar.setWindow(selectOpenAndClose, selectWindow);
		    	break;
	    	} else {
	    		System.out.println("\n잘못 입력하셨습니다. 다시 입력하세요! (입력값 : 1, 2, 3, 4)");
	    	}
    	}
	}
	
	//와이퍼 켜기, 끄기 선택 메소드
	private static void wiper() {
		System.out.println("5. 와이퍼 선택 (1.와이퍼 켜기, 2.와이퍼 끄기)");
		
    	while(true) {
	    	System.out.print("와이퍼 선택 >> ");
	    	int selectNum = scanner.nextInt();
	    	
	    	if(selectNum == 1 || selectNum == 2) {
	    		myCar.setWiper(selectNum);
	    		System.out.println();
	    		myCar.wiperState();
		    	break;
	    	} else {
	    		System.out.println("\n잘못 입력하셨습니다. 다시 입력하세요! (입력값 : 1, 2)");
	    	}
    	}
	}
	
	//깜빡이 선택 메소드
	private static void blinker() {
		System.out.println("6. 깜빡이 선택 (1.왼쪽, 2.오른쪽, 3.비상깜빡이, 4.끄기)");
    	while(true) {
	    	System.out.print("깜빡이 선택 >> ");
	    	int blinkerNum = scanner.nextInt();
	    	
	    	if(blinkerNum == 1 || blinkerNum == 2 || blinkerNum == 3 || blinkerNum == 4) {
	    		myCar.setBlinker(blinkerNum);
	    		System.out.println();
	    		myCar.blinker.blinkerState();
		    	break;
	    	} else {
	    		System.out.println("\n잘못 입력하셨습니다. 다시 입력하세요! (입력값 : 1, 2, 3, 4)");
	    	}
    	}
	}
	
	//자동차의 현재 상태 출력 메소드
	private static void currentStateOfTheCar() {
		System.out.println("7. 자동차의 현재 상태\n");
    	System.out.print("(1). 현재 속도 : ");
    	System.out.print("[");
    	for(int i = 0; i < myCar.showSpeed(); ++i) {
    		System.out.print("■■");
    	}
    	for(int i = 0; i < (10 - myCar.showSpeed()); ++i) {
    		System.out.print("□□");
    	}
    	System.out.print("], ");
    	System.out.println(myCar.getSpeed());
    	System.out.print("(2). 타이어 종류 : ");
    	myCar.tire.tireState();
    	System.out.println();
    	System.out.println("(3). 창문 상태 : ");
    	System.out.print("\t(3)-1. 운전석 : ");
    	myCar.frontLeftWindow.windowState();
    	System.out.print("\t(3)-2. 조수석 : ");
    	myCar.frontRightWindow.windowState();
    	System.out.print("\t(3)-3. 뒷창문 오른쪽 : ");
    	myCar.backRightWindow.windowState();
    	System.out.print("\t(3)-4. 뒷창문 왼쪽 : ");
    	myCar.backLeftWindow.windowState();
    	System.out.println("(4). 기어 변속 상태 : " + myCar.getGear());
    	System.out.print("(5). 와이퍼 상태 : ");
    	myCar.wiperState();
    	System.out.print("(6). 깜빡이 상태 : ");
    	myCar.blinker.blinkerState();
	}
	
	//급브레이크 메소드
	private static void suddenBreak() {
		System.out.println("8. 급브레이크");
		System.out.println("\n급정지 하셨습니다!!");
		myCar.setGear("N(중립)");
		myCar.setSpeed("0 km");
	}
}
