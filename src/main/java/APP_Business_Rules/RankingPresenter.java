package APP_Business_Rules;

import entities.Account;

public interface RankingPresenter {
    Account[] returnUsersSorted(Account[] list);
}
