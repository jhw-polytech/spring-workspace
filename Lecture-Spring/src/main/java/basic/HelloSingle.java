package basic;

public class HelloSingle {
	
	private static HelloSingle instance = null;
	private String msg = "æ»≥Á ≥≠ ΩÃ±€≈œ¿Ãæﬂ!!";
	
	private HelloSingle() {
		System.out.println("HelloSingle ∞¥√º ∑Œµ˘ . . .");
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
