package kr.ac.uc.test_2025_05_19_k.network;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000b\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u000f\u001a\u00020\fH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u000e\u0010\u0010\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\nJ\u001e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\b\b\u0001\u0010\u0015\u001a\u00020\u0016H\u00a7@\u00a2\u0006\u0002\u0010\u0017J\u0018\u0010\u0018\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00132\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u00a7@\u00a2\u0006\u0002\u0010\u001c\u00a8\u0006\u001d"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/network/ApiService;", "", "addInterest", "Lokhttp3/ResponseBody;", "id", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllInterests", "", "Lkr/ac/uc/test_2025_05_19_k/model/InterestDto;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentUser", "Lkr/ac/uc/test_2025_05_19_k/model/UserProfileResponse;", "getMyInterests", "Lkr/ac/uc/test_2025_05_19_k/model/Interest;", "getMyProfile", "getOnboardingStatus", "Lkr/ac/uc/test_2025_05_19_k/model/OnboardingStatusResponse;", "refreshToken", "Lretrofit2/Response;", "Lkr/ac/uc/test_2025_05_19_k/model/auth/TokenResponse;", "refreshTokenRequest", "Lkr/ac/uc/test_2025_05_19_k/model/RefreshTokenRequest;", "(Lkr/ac/uc/test_2025_05_19_k/model/RefreshTokenRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeInterest", "updateProfile", "profileRequest", "Lkr/ac/uc/test_2025_05_19_k/model/ProfileUpdateRequest;", "(Lkr/ac/uc/test_2025_05_19_k/model/ProfileUpdateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface ApiService {
    
    @retrofit2.http.GET(value = "/api/users/profile")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMyProfile(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.UserProfileResponse> $completion);
    
    @retrofit2.http.PUT(value = "/api/users/profile")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateProfile(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.ProfileUpdateRequest profileRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kr.ac.uc.test_2025_05_19_k.model.UserProfileResponse>> $completion);
    
    @retrofit2.http.GET(value = "/api/users/onboarding-status")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getOnboardingStatus(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.OnboardingStatusResponse> $completion);
    
    @retrofit2.http.GET(value = "/api/users/my-interests")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMyInterests(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<kr.ac.uc.test_2025_05_19_k.model.Interest>> $completion);
    
    @retrofit2.http.GET(value = "/api/users/interests")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllInterests(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<kr.ac.uc.test_2025_05_19_k.model.InterestDto>> $completion);
    
    @retrofit2.http.POST(value = "/api/users/interests/{interestId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object addInterest(@retrofit2.http.Path(value = "interestId")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super okhttp3.ResponseBody> $completion);
    
    @retrofit2.http.DELETE(value = "/api/users/interests/{interestId}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object removeInterest(@retrofit2.http.Path(value = "interestId")
    int id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super okhttp3.ResponseBody> $completion);
    
    @retrofit2.http.GET(value = "/api/auth/me")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getCurrentUser(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.UserProfileResponse> $completion);
    
    @retrofit2.http.POST(value = "/api/auth/token/refresh")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshToken(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.RefreshTokenRequest refreshTokenRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kr.ac.uc.test_2025_05_19_k.model.auth.TokenResponse>> $completion);
}