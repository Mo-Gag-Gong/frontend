package kr.ac.uc.test_2025_05_19_k.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001a\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f0\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/viewmodel/OnboardingViewModel;", "Landroidx/lifecycle/ViewModel;", "api", "Lkr/ac/uc/test_2025_05_19_k/network/ApiService;", "(Lkr/ac/uc/test_2025_05_19_k/network/ApiService;)V", "<set-?>", "", "onboardingCompleted", "getOnboardingCompleted", "()Ljava/lang/Boolean;", "setOnboardingCompleted", "(Ljava/lang/Boolean;)V", "onboardingCompleted$delegate", "Landroidx/compose/runtime/MutableState;", "checkOnboardingStatus", "", "onResult", "Lkotlin/Function1;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class OnboardingViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.network.ApiService api = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState onboardingCompleted$delegate = null;
    
    @javax.inject.Inject()
    public OnboardingViewModel(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.ApiService api) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Boolean getOnboardingCompleted() {
        return null;
    }
    
    private final void setOnboardingCompleted(java.lang.Boolean p0) {
    }
    
    /**
     * 서버에서 온보딩(프로필 입력) 완료 여부를 조회
     * @param onResult true: 온보딩 완료 → 홈으로, false: 미완료 → 로그인/온보딩
     */
    public final void checkOnboardingStatus(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> onResult) {
    }
}