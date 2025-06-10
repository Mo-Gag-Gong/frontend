package kr.ac.uc.test_2025_05_19_k.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/repository/ProfileRepository;", "", "apiService", "Lkr/ac/uc/test_2025_05_19_k/network/ApiService;", "(Lkr/ac/uc/test_2025_05_19_k/network/ApiService;)V", "updateProfile", "Lretrofit2/Response;", "Lkr/ac/uc/test_2025_05_19_k/model/UserProfileResponse;", "profileRequest", "Lkr/ac/uc/test_2025_05_19_k/model/ProfileUpdateRequest;", "(Lkr/ac/uc/test_2025_05_19_k/model/ProfileUpdateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class ProfileRepository {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.network.ApiService apiService = null;
    
    @javax.inject.Inject()
    public ProfileRepository(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.ApiService apiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateProfile(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.ProfileUpdateRequest profileRequest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kr.ac.uc.test_2025_05_19_k.model.UserProfileResponse>> $completion) {
        return null;
    }
}