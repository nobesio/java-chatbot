import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConceptImpl implements Concept {

    final String response;
    final List<String> stimuli;

    public static Concept createConcept(String response, List<String> stimuli) {
        return new ConceptImpl(response, stimuli);
    }

    private ConceptImpl(String response, List<String> stimuli) {
        this.response = response;
        this.stimuli = stimuli;
    }

    @Override
    public String getResponse() {
        return response;
    }

    @Override
    public Double getActivationPercentage(String externalStimulus) {
        Double totalNumberUniqueWords = 0.0;
        Double interceptionNumberUniquerWords = 0.0;

        Set<String> externalStimulusUniqueWords = Set.of(externalStimulus.split(" "));
        totalNumberUniqueWords+= externalStimulusUniqueWords.size();
        for (String stimulus: this.stimuli) {
            Set<String> internalStimulusUniqueWords = new HashSet<String>(Arrays.asList(stimulus.split(" ")));
            totalNumberUniqueWords+= internalStimulusUniqueWords.size();

            internalStimulusUniqueWords.retainAll(externalStimulusUniqueWords);
            interceptionNumberUniquerWords += internalStimulusUniqueWords.size();
        }

        return interceptionNumberUniquerWords / totalNumberUniqueWords;
    }
}
