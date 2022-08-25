package project02;

public class BlinkingOff implements Blinker {
	@Override
	public void blinkerState() {
		System.out.println("깜빡이가 꺼져 있습니다.");
	}
}
