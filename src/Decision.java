import java.util.Date;

public interface Decision {
  Action getAction();
  Context getContext();
  Double getAwarenesss();
  Date getDate();
}
