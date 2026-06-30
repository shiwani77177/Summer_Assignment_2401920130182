import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), k, n, 1);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int k, int target, int start) {
        if (current.size() == k) {
            if (target == 0) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        for (int i = start; i <= 9; i++) {
            if (i > target) {
                break;
            }

            current.add(i);
            backtrack(result, current, k, target - i, i + 1);
            current.remove(current.size() - 1);
        }
    }
}