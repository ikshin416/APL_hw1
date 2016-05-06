package apl_hw1;

public class Application implements IPrintable{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DynamicClassProvider.registerProvider("test", "ikhee", "apl_hw1.TestClass");
		
		Object O1 = DynamicClassProvider.newInstance("test", "ikhee");
		((IPrintable)O1).printName();
		
		Object O2 = DynamicClassProvider.newInstance("test", "ikhee");
		((IPrintable)O2).printName();

	}

	@Override
	public void printName() {
		// TODO Auto-generated method stub
		System.out.println("Application");
	}

}
