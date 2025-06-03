package kr.ac.uc.test_2025_05_19_k.network.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\bH\u00a7@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u000b2\b\b\u0001\u0010\u0007\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\r\u00a8\u0006\u000e"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/network/api/UserApi;", "", "getMyProfile", "Lkr/ac/uc/test_2025_05_19_k/model/AuthUserProfile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "login", "Lkr/ac/uc/test_2025_05_19_k/model/auth/TokenResponse;", "request", "Lkr/ac/uc/test_2025_05_19_k/model/auth/LoginRequest;", "(Lkr/ac/uc/test_2025_05_19_k/model/auth/LoginRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "register", "Ljava/lang/Void;", "Lkr/ac/uc/test_2025_05_19_k/model/auth/RegisterRequest;", "(Lkr/ac/uc/test_2025_05_19_k/model/auth/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface UserApi {
    
    @retrofit2.http.POST(value = "/api/users/login")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object login(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.auth.LoginRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.auth.TokenResponse> $completion);
    
    @retrofit2.http.POST(value = "/api/users/join")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object register(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.auth.RegisterRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Void> $completion);
    
    @retrofit2.http.GET(value = "/api/auth/me")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMyProfile(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.AuthUserProfile> $completion);
}