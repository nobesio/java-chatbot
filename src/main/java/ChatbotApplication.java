import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ChatbotApplication {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Brain duke = initializeDukeBrain();
        while(true) {
            String message = getMessageFromReader();
            System.out.println(duke.respond(message));
        }
    }

    private static String getMessageFromReader() throws IOException {
        return reader.readLine();
    }

    private static Brain initializeDukeBrain() {
        List<Concept> concepts = new ArrayList<>();
        concepts.add(ConceptImpl.createConcept("James Gosling", List.of(
            "who is the author of java ?",
            "who created java ?",
            "who wrote java ?",
            "name java author"
        )));
        concepts.add(ConceptImpl.createConcept("1995", List.of(
            "when was java released for the first time ?",
            "when was java created ?",
            "when was java written ?",
            "java creation date"
        )));
        concepts.add(ConceptImpl.createConcept("17", List.of(
            "what is java latest version ?",
            "what is the latest version of java ?",
            "what is the last number java version ?",
            "java version number"
        )));

        Brain duke = BrainImpl.createBrain(concepts);
        return duke;
    }

}
