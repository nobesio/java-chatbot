import java.util.Comparator;
import java.util.List;

public class Brain {
    List<Concept> concepts;

    public static Brain createBrain(List<Concept> concepts) {
        return new Brain(concepts);
    }

    private Brain(List<Concept> concepts) {
        this.concepts = concepts;
    }

    public String respond(String message) {
        return concepts.stream().max(new Comparator<Concept>() {
            @Override
            public int compare(Concept c1, Concept c2) {
                Double similarityC1 = c1.getPercentageIntersectionUniqueWords(message);
                Double similarityC2 = c2.getPercentageIntersectionUniqueWords(message);
                if (similarityC1 < similarityC2) {
                    return -1;
                } else if(similarityC1 == similarityC2) {
                    return 0;
                } else {
                    return 1;
                }
            }
        }).get().getResponse();
    }
}
