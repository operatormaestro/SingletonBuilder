import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int treshold;

    public Filter(int treshold) {
        this.treshold = treshold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();
        for (int z : source) {
            if (z >= treshold) {
                logger.log("Элемент \"" + z + "\"" + "проходит");
                result.add(z);
            }else {
                logger.log("Элемент \"" + z + "\"" + "не проходит");
            }
        }
        return result;
    }
}
