package gate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapTest {
	public static void main(String args[]) {
		// Map<String, String> map = new ConcurrentHashMap<>();
		// map.get("hello");
		// map.put("hello", "world");

		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Integer r = new Random().nextInt(2);
			//if (r == 0) {
				System.out.println(r);
		//	}

		}
		System.out.println(a.size());
		System.out.println(b.size());

	}
}
