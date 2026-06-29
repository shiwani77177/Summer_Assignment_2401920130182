import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> configurations = new ArrayList<>();
        Arrays.sort(candidates);
        assemble(candidates, target, 0, new ArrayList<>(), configurations);
        return configurations;
    }

    private void assemble(int[] inventory, int deficit, int index, 
                          List<Integer> bin, List<List<Integer>> structures) {
        if (deficit == 0) {
            structures.add(new ArrayList<>(bin));
            return;
        }

        for (int cursor = index; cursor < inventory.length; cursor++) {
            if (inventory[cursor] > deficit) {
                break;
            }
            
            if (cursor > index && inventory[cursor] == inventory[cursor - 1]) {
                continue;
            }

            bin.add(inventory[cursor]);
            assemble(inventory, deficit - inventory[cursor], cursor + 1, bin, structures);
            bin.remove(bin.size() - 1);
        }
    }
}
