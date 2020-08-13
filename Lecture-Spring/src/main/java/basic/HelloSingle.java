package basic;

public class HelloSingle {
	
	private static HelloSingle instance = null;
	private String msg = "�ȳ� �� �̱����̾�!!";
	
	private HelloSingle() {
		System.out.println("HelloSingle ��ü �ε� . . .");
	}

	public static HelloSingle getInstance() {
		if(instance == null)
			instance = new HelloSingle();
		return instance;
	}
	
	public void prnMsg() {
		System.out.println("msg : " + msg);
	}
}
