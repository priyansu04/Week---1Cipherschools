import java.util.Stack;

public class updatenum
{
    public static void main(String[] args) {
        int N = 5;
        int[] arr = {4, 2, 1, 5, 3};

        int[] result = updateNextSmaller(N, arr);

        for (int value : result) {
            System.out.print(value + " ");
        }
    }

    private static int[] updateNextSmaller(int N, int[] arr) {
        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                int poppedIndex = stack.pop();
                result[poppedIndex] = arr[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int remainingIndex = stack.pop();
            result[remainingIndex] = -1;
        }

        return result;
    }
}
