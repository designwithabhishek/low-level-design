package splitwise;

import java.util.List;

public interface SplittingStrategy {
    List<Split> validateAndComputeSplitAmount(Expense expense);
}
