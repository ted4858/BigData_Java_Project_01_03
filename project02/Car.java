package project02;

public class Car{
	Tire tire = new HankookTire();
//	Tire frontLeftTire = new HankookTire(); 타이어 위치별 교환할 때 사용
//	Tire frontRightTire = new HankookTire();
//	Tire backLeftTire = new HankookTire();
//	Tire backRightTire = new HankookTire();
	
	Window frontLeftWindow = new WindowClose();
	Window frontRightWindow = new WindowClose();
	Window backLeftWindow = new WindowClose();
	Window backRightWindow = new WindowClose();
	
	Blinker blinker = new BlinkingOff();
	
	private String gear;
	private String speed;
	private boolean wiper;
	
	public Car() {
		this.gear = "N(중립)";
		this.speed = "0 km";
		this.wiper = false;
	}
	
	public String getGear() {
		return gear;
	}
	
	public void setGear(String gear) {
		this.gear = gear;
	}
	
	public String getSpeed() {
		return speed;
	}
	
	public void setSpeed(String speed) {
		this.speed = speed;
	}
	
	public void setSpeedAndGear(String gear) {
		this.gear = gear;
		
		if(gear.equals("1단")) {
    		this.speed = "10 km";
    	} else if(gear.equals("2단")) {
    		this.speed = "20 km";
    	} else if(gear.equals("3단")) {
    		this.speed = "30 km";
    	} else if(gear.equals("4단")) {
    		this.speed = "40 km";
    	} else if(gear.equals("5단")) {
    		this.speed = "50 km";
    	} else if(gear.equals("6단")) {
    		this.speed = "100 km 이상";
    	} else if(gear.equals("R단")) {
    		this.speed = "후진";
    	}
	}
	
	public void setTire(int tireNum) {
		if(tireNum == 1) {
			tire = new Michelin();
    	} else if(tireNum == 2) {
    		tire = new KumhoTire();
    	} else if(tireNum == 3) {
    		tire = new HankookTire();
    	} else if(tireNum == 4) {
    		tire = new Continental();
    	}
	}
	
	public void setWindow(int openAndClose, int windowNum) {
		if(openAndClose == 1) {
			if(windowNum == 1) {
	    		frontLeftWindow = new WindowOpen();
	    		System.out.println("운전석 창문이 열렸습니다.");
	    	} else if(windowNum == 2) {
	    		frontRightWindow = new WindowOpen();
	    		System.out.println("조수석 창문이 열렸습니다.");
	    	} else if(windowNum == 3) {
	    		backLeftWindow = new WindowOpen();
	    		System.out.println("뒷창문 왼쪽 창문이 열렸습니다.");
	    	} else if(windowNum == 4) {
	    		backRightWindow = new WindowOpen();
	    		System.out.println("뒷창문 오른쪽 창문이 열렸습니다.");
	    	}
		} else {
			if(windowNum == 1) {
	    		frontLeftWindow = new WindowClose();
	    		System.out.println("운전석 창문이 닫혔습니다.");
	    	} else if(windowNum == 2) {
	    		frontRightWindow = new WindowClose();
	    		System.out.println("조수석 창문이 닫혔습니다.");
	    	} else if(windowNum == 3) {
	    		backLeftWindow = new WindowClose();
	    		System.out.println("뒷창문 왼쪽 창문이 닫혔습니다.");
	    	} else if(windowNum == 4) {
	    		backRightWindow = new WindowClose();
	    		System.out.println("뒷창문 오른쪽 창문이 닫혔습니다.");
	    	}
		}
	}
	
	public void setBlinker(int blinkerNum) {
		if(blinkerNum == 1) {
			blinker = new LeftBlinker();
    	} else if(blinkerNum == 2) {
    		blinker = new RightBlinker();
    	} else if(blinkerNum == 3) {
    		blinker = new EmergencyBlinker();
    	} else if(blinkerNum == 4) {
    		blinker = new BlinkingOff();
    	}
	}
	
	public void wiperState() {
		if(this.wiper = true) {
			System.out.println("와이퍼가 켜졌습니다.");
		} else {
			System.out.println("와이퍼가 꺼졌습니다.");
		}
	}
	
	public void setWiper(int num) {
		if(num == 1) {
			this.wiper = true;
		} else {
			this.wiper = false;
		}
	}
	
	public int showSpeed() {
		int speedState = 0;
		
		if(gear.equals("1단")) {
			speedState = 1;
    	} else if(gear.equals("2단")) {
    		speedState = 2;
    	} else if(gear.equals("3단")) {
    		speedState = 3;
    	} else if(gear.equals("4단")) {
    		speedState = 4;
    	} else if(gear.equals("5단")) {
    		speedState = 5;
    	} else if(gear.equals("6단")) {
    		speedState = 10;
    	} else if(gear.equals("R단")) {
    		speedState = 1;
    	} else if(gear.equals("N(중립)")) {
    		speedState = 0;
    	}
		
		return speedState;
	}
}
