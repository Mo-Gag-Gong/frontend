package kr.ac.uc.test_2025_05_19_k.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010R&\u0010\u0005\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u000b\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\u00070\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/viewmodel/GoalViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lkr/ac/uc/test_2025_05_19_k/repository/GoalRepository;", "(Lkr/ac/uc/test_2025_05_19_k/repository/GoalRepository;)V", "_goalMap", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Ljava/time/LocalDate;", "", "Lkr/ac/uc/test_2025_05_19_k/viewmodel/GoalResponse;", "goalMap", "Lkotlinx/coroutines/flow/StateFlow;", "getGoalMap", "()Lkotlinx/coroutines/flow/StateFlow;", "loadGoalsFromMyGroups", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class GoalViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.GoalRepository repository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.Map<java.time.LocalDate, java.util.List<kr.ac.uc.test_2025_05_19_k.viewmodel.GoalResponse>>> _goalMap = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.time.LocalDate, java.util.List<kr.ac.uc.test_2025_05_19_k.viewmodel.GoalResponse>>> goalMap = null;
    
    @javax.inject.Inject()
    public GoalViewModel(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.GoalRepository repository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.Map<java.time.LocalDate, java.util.List<kr.ac.uc.test_2025_05_19_k.viewmodel.GoalResponse>>> getGoalMap() {
        return null;
    }
    
    public final void loadGoalsFromMyGroups() {
    }
}