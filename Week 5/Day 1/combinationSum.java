import java.util.ArrayList;
import java.util.List;

public class combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalCombinations = new ArrayList<>();
        findSubsets(candidates, target, 0, 0, new ArrayList<>(), finalCombinations);
        return finalCombinations;
    }

    private void findSubsets(int[] pool, int limit, int pointer, int runningSum, 
                             List<Integer> bucket, List<List<Integer>> masterList) {
        if (runningSum == limit) {
            masterList.add(new ArrayList<>(bucket));
            return;
        }

        if (pointer >= pool.length || runningSum > limit) {
            return;
        }

        bucket.add(pool[pointer]);
        findSubsets(pool, limit, pointer, runningSum + pool[pointer], bucket, masterList);
        
        bucket.remove(bucket.size() - 1);

        findSubsets(pool, limit, pointer + 1, runningSum, bucket, masterList);
    }
}
