import java.util.List;

public class EthicalQuestion {

  public Double getActionWrongness(Action action, Context context) {
    return action.getSufferingCreated(context) * action.getOptionality(context);
  }

  public Double getDecisionWrongness(Decision decision) {
    return getActionWrongness(decision.getAction(),decision.getContext()) * decision.getAwarenesss();
  }

  //basic sigmoid curve with 0.0 origin that intersects 1,1
  public static Double getDecisionWeight(Double unitInterval) {
    return 3 * Math.pow(unitInterval,2) - Math.pow(2*unitInterval,3);
  }

  //todo: is this right?
  public Double getPersonBadness(List<Decision> decisions) {
    double badness = 0.0D;
    for (int i = 0, decisionsSize = decisions.size(); i < decisionsSize; i++) {
      Decision decision = decisions.get(i);
      Double decisionWrongness = getDecisionWrongness(decision);

      Double decisionRecentness = (double) (i / decisionsSize);
      Double decisionWeight = getDecisionWeight(decisionRecentness);

      badness += (decisionWrongness * decisionWeight);
    }
    return badness / decisions.size();
  }
}
