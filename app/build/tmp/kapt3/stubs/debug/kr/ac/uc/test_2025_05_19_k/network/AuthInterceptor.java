package kr.ac.uc.test_2025_05_19_k.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u000eR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/network/AuthInterceptor;", "Lokhttp3/Interceptor;", "tokenManager", "Lkr/ac/uc/test_2025_05_19_k/repository/TokenManager;", "apiService", "Ldagger/Lazy;", "Lkr/ac/uc/test_2025_05_19_k/network/ApiService;", "(Lkr/ac/uc/test_2025_05_19_k/repository/TokenManager;Ldagger/Lazy;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "refreshTokenIfNeeded", "", "(Lkr/ac/uc/test_2025_05_19_k/repository/TokenManager;Lkr/ac/uc/test_2025_05_19_k/network/ApiService;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AuthInterceptor implements okhttp3.Interceptor {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.TokenManager tokenManager = null;
    @org.jetbrains.annotations.NotNull()
    private final dagger.Lazy<kr.ac.uc.test_2025_05_19_k.network.ApiService> apiService = null;
    
    public AuthInterceptor(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.TokenManager tokenManager, @org.jetbrains.annotations.NotNull()
    dagger.Lazy<kr.ac.uc.test_2025_05_19_k.network.ApiService> apiService) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public okhttp3.Response intercept(@org.jetbrains.annotations.NotNull()
    okhttp3.Interceptor.Chain chain) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object refreshTokenIfNeeded(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.TokenManager tokenManager, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.ApiService apiService, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
}