
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Admin
 */
public class MyCar implements ICar {

    @Override
    public int f1(List<Car> t) {
        int sum = 0;
        for (int i = 0; i < t.size(); i++) {
            sum += t.get(i).getRate();

        }
        return sum / t.size();
    }

    @Override
    public void f2(List<Car> t) {
        int max = t.get(0).getRate(), min = t.get(0).getRate();
        int maxIndex = 0, minIndex = 0;
        for (int i = 0; i < t.size(); i++) {
            if (min > t.get(i).getRate()) {
                min = t.get(i).getRate();
                minIndex = i;
            }
            if (max < t.get(i).getRate()) {
                max = t.get(i).getRate();
                maxIndex = i;
            }
        }
        Car temp = t.get(minIndex);
        t.set(minIndex, t.get(maxIndex));
        t.set(maxIndex, temp);
    }

    @Override
    public void f3(List<Car> t) {
        for (int i = 0; i < t.size() - 1; i++) {
            String minMk = t.get(i).getMaker();
            int minInd = i;
            for (int j = i + 1; j < t.size(); j++) {
                if (minMk.compareTo(t.get(j).getMaker()) > 0) {
                    minMk = t.get(j).getMaker();
                    minInd = j;
                } else if (minMk.equals(t.get(j).getMaker())) {
                    if (t.get(minInd).getRate() < t.get(j).getRate()) {
                        minMk = t.get(j).getMaker();
                        minInd = j;
                    }
                }
            }
            Car temp = t.get(minInd);
            t.set(minInd, t.get(i));
            t.set(i, temp);
        }
    }

}
