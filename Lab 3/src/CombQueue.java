public class CombQueue<T> {
    public static PQueue<String> pQueue;
    public static WQueue[] wQueues;

    CombQueue(double[] weights) {
        pQueue = new PQueue<>();
        wQueues = new WQueue[weights.length];
        for(int i = 0; i < weights.length; i++) {
            int indexOfMax = findMax(weights);
            wQueues[i] = new WQueue(weights[indexOfMax]);
            weights[indexOfMax] = -1;
        }
    }

    private int findMax(double[] weights) {
        double max = weights[0];
        int indexOfMax = 0;
        for(int i = 1; i < weights.length; i++) {
            if(max < weights[i]) {
                indexOfMax = i;
                max = weights[i];
            }
        }
        return indexOfMax;
    }
}
