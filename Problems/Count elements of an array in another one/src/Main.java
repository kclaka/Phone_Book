import java.util.*;

public class Main {

    public static int[] countOccurrences(int[] first, int[] second) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> lst = new ArrayList<>();


        for (int i : second) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }


        for (int i : first){
           lst.add(map.getOrDefault(i, 0));
        }

        int[] arr = new int[lst.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lst.get(i);
        }

        return arr;




    }

    /* Do not change code below */
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int[] first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        final int[] second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        final String result = Arrays.toString(countOccurrences(first, second))
                .replace(", ", " ")
                .replace("[", "")
                .replace("]", "");
        System.out.println(result);
    }
}