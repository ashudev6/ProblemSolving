package queues;

import java.util.ArrayList;
import java.util.List;

public class GasStationsTravel {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 && cost.length == 0) return -1;
        if (gas.length == 1 && cost.length == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }
        if (gas.length > 1 && cost.length > 1 && gas.length == cost.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < gas.length; i++) {
                if (gas[i] > cost[i]) {
                    list.add(i);
                }
            }
            for (Integer k : list) {
                int j = 0;
                if (k < gas.length - 1) {
                    j = k + 1;
                } else {
                    j = (k + 1) % gas.length;
                }
                int gas_amt = gas[k] - cost[k];
                while (j != k && gas_amt > 0) {
                    gas_amt = gas_amt + gas[j] - cost[j];
                    if (j < gas.length - 1) {
                        j = j + 1;
                    } else {
                        j = (j + 1) % gas.length;
                    }
                }
                if (j == k && gas_amt >= 0) return j;

            }
        }
        return -1;


    }


}
