import java.util.ArrayList;
import java.util.List;

public class StrictMagnification {
    public static List<List<Integer>> getStrictMagnification(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();
        if (arr.length == 0) return result;

        List<Integer> current = new ArrayList<>();
        current.add(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                current.add(arr[i]);
            } else {
                if (current.size() > 1) {
                    result.add(new ArrayList<>(current));
                }
                current.clear();
                current.add(arr[i]);
            }
            if (current.size() > 1) {
                result.add(new ArrayList<>(current));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1, 2, 4, 1, 2};
        List<List<Integer>> increasingSubarrays = getStrictMagnification(arr);
        System.out.println(increasingSubarrays);
    }
}
