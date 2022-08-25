package project02;

public class EmergencyBlinker implements Blinker {
	@Override
	public void blinkerState() {
		System.out.println("비상등이 깜빡이고 있습니다.");
	}
}
