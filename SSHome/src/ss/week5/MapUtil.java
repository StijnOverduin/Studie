package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {

	//@ ensures \result == (\forall V v,v1; map.values().contains(v) && map.values().contains(v1) && v != v1; map.get(v) != map.get(v1));
	/*@ pure*/public static <K, V> boolean isOneOnOne(Map<K, V> map) {
		boolean result = true;
		for (V v : map.values()) {
			int count = 0;
			for (V v1 : map.values()) {
				if (v == v1) {
					count++;
				}
			}
			if (count != 1) {
				result = false;
			}
		}
		return result;
	}

	//@ ensures \result == (\forall V v; range.contains(v); \exists K k; map.keySet().contains(k); map.get(v) == k);
	public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
		boolean result = true;
		for (V v : range) {
			boolean key = false;
			for (K k : map.keySet()) {
				if (map.get(k) == v) {
					key = true;
				}
			}
			result = result && key;
		}
		return result;
	}
	
	//@ ensures \forall K k; map.keySet().contains(k); (\result.get(map.get(k))).contains(k);
	public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
		Map<V, Set<K>> mapk = new HashMap<V, Set<K>>();
		for (K k : map.keySet()) {
			Set<K> set = mapk.get(map.get(k));
			if (set == null) {
				set = new HashSet<K>();
			}
			set.add(k);
			mapk.put(map.get(k), set);
		}
		return mapk;

	}

	//@ requires isOneOnOne(map);
	//@ ensures \forall K k; map.keySet().contains(k); \result.get(map.get(k)).equals(k);
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> mapk = new HashMap<V, K>();
		for (K k : map.keySet()) {
			mapk.put(map.get(k), k);
		}
		return mapk;
	}
	
	//@ ensures \result == (\forall K k; f.keySet().contains(k); g.containsKey(f.get(k)));
	/*@ pure*/public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
		boolean ans = true;
		for (V v : f.values()) {
			if (!g.containsKey(v)) {
				ans = false;
			}
		}
		return ans;
	}

	//@ requires compatible(f, g);
	//@ ensures \forall K k; f.keySet().contains(k); \result.keySet().contains(k); \result.get(k) == g.get(f.get(k));
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
		Map<K, W> map = new HashMap<K, W>();
		if (compatible(f, g)) {
			for (K k : f.keySet()) {
				map.put(k, g.get(f.get(k)));
			}
		}
		return map;
	}
}
