import java.util.List;

public class EthicalQuestion {

  public Frequency shouldOnePerformAction(FutureAction possibleAction, Context context) {
    Double goodFaithEstimateOfSufferingCreated = possibleAction.getGoodFaithEstimateOfSufferingCreated(context);
    Double goodFaithEstimateOfOptionality = possibleAction.getGoodFaithEstimateOfOptionality(context);

    if (goodFaithEstimateOfSufferingCreated <= MagicConstants.AS_CLOSE_TO_ZERO_AS_CAN_BE_DETERMINED) {
      return Frequency.WHENEVER_ONE_WANTS;
    } else if (goodFaithEstimateOfSufferingCreated > MagicConstants.AS_CLOSE_TO_ZERO_AS_CAN_BE_DETERMINED && goodFaithEstimateOfSufferingCreated <= MagicConstants.MORE_THAN_A_LITTLE_BIT) {
      if (goodFaithEstimateOfOptionality >= MagicConstants.MORE_THAN_A_LITTLE_BIT) {
        return Frequency.LESS_OFTEN;
      } else {
        return Frequency.WHENEVER_ONE_HAS_TO;
      }
    } else  {
      return Frequency.AS_CLOSE_TO_NEVER_AS_ONE_CAN;
    }
  }

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

  //todo: is this right? Basically 0% chance it is.
  public Double getPersonBadness(Life life) {
    double badness = 0.0D;
    List<Decision> decisions = life.getDecisions();
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
