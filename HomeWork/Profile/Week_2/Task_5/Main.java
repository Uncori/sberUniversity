package Task_5;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"day", "the", "is", "sunny", "the", "the", "the", "sunny", "is", "is", "day"};
        int k = 4;
        System.out.println(Arrays.toString(method(words, k)));
        // test
        System.out.println(Arrays.toString(method(words, 0)));
        System.out.println(Arrays.toString(method(words, 1)));
        System.out.println(Arrays.toString(method(words, 2)));
        System.out.println(Arrays.toString(method(words, 3)));
        System.out.println(Arrays.toString(method(words, 4)));
        System.out.println(Arrays.toString(method(words, 5)));
    }

    public static String[] method(String[] words, int k) {
        String[] res = new String[k];
        Set<String> set = new HashSet<>(List.of(words));
        ArrayList<Integer> counts = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (String iter : set) {
            int count = 0;
            for (String reit : words) {
                if (iter.compareTo(reit) == 0) {
                    ++count;
                }
            }
            counts.add(count);
            map.put(iter, count);
        }
        Iterator<Integer> iterator = counts.iterator();
        try {
            for (int i = 0; i < k; ++i) {
                res[i] = getKey(map, iterator.next());
            }
        } catch (NoSuchElementException ex) {
            System.out.println("Количество совпадений меньше переданного значения");
            System.out.println("Всего найдено " + set.size() + " одинаковых совпадений");
        }

        return res;
    }

    public static <K, V> K getKey(Map<K, V> map, V value) {
        for (K key : map.keySet()) {
            if (value.equals(map.get(key))) {
                map.remove(key);
                return key;
            }
        }
        return null;
    }
}
