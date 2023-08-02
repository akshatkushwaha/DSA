import java.util.ArrayList;

public class SumOfSubsets {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(3);
        ArrayList<Integer> result = sumOfSubsets(numbers);
        System.out.println(result);
    }

    private static ArrayList<Integer> sumOfSubsets(ArrayList<Integer> numbers) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(0);
        for (int i = 0; i < numbers.size(); ++i) {
            int sum = 0;
            for (int j = i; j < numbers.size(); ++j) {
                sum += numbers.get(j);
                result.add(sum);
            }
        }
        // Collections.sort(result);

        return result;
    }
}