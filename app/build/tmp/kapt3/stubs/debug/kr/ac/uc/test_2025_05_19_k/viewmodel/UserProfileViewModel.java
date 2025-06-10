package kr.ac.uc.test_2025_05_19_k.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fR\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/viewmodel/UserProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "userRepository", "Lkr/ac/uc/test_2025_05_19_k/repository/UserRepository;", "tokenManager", "Lkr/ac/uc/test_2025_05_19_k/repository/TokenManager;", "(Lkr/ac/uc/test_2025_05_19_k/repository/UserRepository;Lkr/ac/uc/test_2025_05_19_k/repository/TokenManager;)V", "_userProfile", "Landroidx/compose/runtime/MutableState;", "Lkr/ac/uc/test_2025_05_19_k/model/UserProfileResponse;", "userProfile", "Landroidx/compose/runtime/State;", "getUserProfile", "()Landroidx/compose/runtime/State;", "loadUserProfile", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class UserProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.TokenManager tokenManager = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState<kr.ac.uc.test_2025_05_19_k.model.UserProfileResponse> _userProfile = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.State<kr.ac.uc.test_2025_05_19_k.model.UserProfileResponse> userProfile = null;
    
    @javax.inject.Inject()
    public UserProfileViewModel(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.TokenManager tokenManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.compose.runtime.State<kr.ac.uc.test_2025_05_19_k.model.UserProfileResponse> getUserProfile() {
        return null;
    }
    
    public final void loadUserProfile() {
    }
}