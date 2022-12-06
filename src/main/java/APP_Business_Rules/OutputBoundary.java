package APP_Business_Rules;

import APP_Business_Rules.search_use_case.SearchResponseModel;

public interface OutputBoundary {
    void update(SearchResponseModel searchResponseModel);
}
