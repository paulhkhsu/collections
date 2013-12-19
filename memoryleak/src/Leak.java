import java.util.HashMap;
import java.util.Map;

public class Leak {

	static Map<Integer, CLassA> m = new HashMap<Integer, CLassA>();
    static int cnt = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while (true) {
			for (int i = 0; i < 100000; i++) {

				CLassA c = new CLassA(cnt, cnt + 1, "t" + cnt, "t" + cnt + 1);
				System.out.println(cnt);
				m.put(new Integer(cnt), c);
				cnt++;
			}

			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
