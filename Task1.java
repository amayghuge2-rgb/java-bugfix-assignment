import java.util.*;

public class Task1 {
    public List<LoanAccount> getOverdueLoans(List<LoanAccount> accounts) {
        // FIX: Initialize list to avoid NullPointerException
        List<LoanAccount> result = new ArrayList<>();

        // FIX: Null check for input list
        if (accounts == null) {
            return result;
        }

        for (LoanAccount account : accounts) {
            // FIX: Skip null account and null dueDate
            if (account != null && account.getDueDate() != null) {
                if (account.getDueDate().before(new Date())) {
                    // FIX: Ensure balance > 0
                    if (account.getOutstandingBalance() > 0) {
                        result.add(account);
                    }
                }
            }
        }
        return result;
    }
}
