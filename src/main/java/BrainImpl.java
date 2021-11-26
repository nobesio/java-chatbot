import java.util.Comparator;
import java.util.List;

public class BrainImpl implements Brain {
    List<Concept> concepts;

    public static Brain createBrain(List<Concept> concepts) {
        return new BrainImpl(concepts);
    }

    private BrainImpl(List<Concept> concepts) {
        this.concepts = concepts;
    }

    @Override
    public String respond(String message) {
        return concepts.stream().max(new Comparator<Concept>() {
            @Override
            public int compare(Concept c1, Concept c2) {
                Double activationPercentageC1 = c1.getActivationPercentage(message);
                Double activationPercentageC2 = c2.getActivationPercentage(message);
                if (activationPercentageC1 < activationPercentageC2) {
                    return -1;
                } else if(activationPercentageC1 == activationPercentageC2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }).get().getResponse();
    }
}
