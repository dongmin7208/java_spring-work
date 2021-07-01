package spring02;

public class VersionPrinter {
	private int major;
	private int minor;
	public void setMajor(int major) {
		this.major = major;
	}
	public void setMinor(int minor) {
		this.minor = minor;
	}
	
	public void print() {
		System.out.printf("프로그램 버전 %d.%d\n\n", major, minor);
	}
}
