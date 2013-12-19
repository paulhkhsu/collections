public class TestAbstract extends Abstract1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Abstract1 a = new TestAbstract();

		a.test2();
		a.test();
		a.test3();
	}

	@Override
	public void test() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName());
	}

	public void test3() {
		// TODO Auto-generated method stub
		System.out.println(this.getClass().getName());
	}

}
