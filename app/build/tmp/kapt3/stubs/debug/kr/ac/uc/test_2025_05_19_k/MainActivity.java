package kr.ac.uc.test_2025_05_19_k;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "tokenManager", "Lkr/ac/uc/test_2025_05_19_k/repository/TokenManager;", "getTokenManager", "()Lkr/ac/uc/test_2025_05_19_k/repository/TokenManager;", "setTokenManager", "(Lkr/ac/uc/test_2025_05_19_k/repository/TokenManager;)V", "userPreference", "Lkr/ac/uc/test_2025_05_19_k/data/local/UserPreference;", "getUserPreference", "()Lkr/ac/uc/test_2025_05_19_k/data/local/UserPreference;", "setUserPreference", "(Lkr/ac/uc/test_2025_05_19_k/data/local/UserPreference;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class MainActivity extends androidx.activity.ComponentActivity {
    @javax.inject.Inject()
    public kr.ac.uc.test_2025_05_19_k.data.local.UserPreference userPreference;
    @javax.inject.Inject()
    public kr.ac.uc.test_2025_05_19_k.repository.TokenManager tokenManager;
    
    public MainActivity() {
        super(0);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.data.local.UserPreference getUserPreference() {
        return null;
    }
    
    public final void setUserPreference(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.data.local.UserPreference p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.repository.TokenManager getTokenManager() {
        return null;
    }
    
    public final void setTokenManager(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.TokenManager p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}