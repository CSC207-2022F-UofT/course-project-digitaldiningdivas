package APP_Business_Rules;

import APP_Business_Rules.SearchUseCase.SearchResponseModel;

public interface OutputBoundary {
    void update(SearchResponseModel searchResponseModel);
}
