package kr.ac.uc.test_2025_05_19_k.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/repository/UserRepository;", "", "userApi", "Lkr/ac/uc/test_2025_05_19_k/network/api/UserApi;", "userApiService", "Lkr/ac/uc/test_2025_05_19_k/network/api/UserApiService;", "(Lkr/ac/uc/test_2025_05_19_k/network/api/UserApi;Lkr/ac/uc/test_2025_05_19_k/network/api/UserApiService;)V", "getMyProfile", "Lkr/ac/uc/test_2025_05_19_k/model/AuthUserProfile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserProfile", "Lkr/ac/uc/test_2025_05_19_k/model/UserProfileResponse;", "userId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class UserRepository {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.network.api.UserApi userApi = null;
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.network.api.UserApiService userApiService = null;
    
    @javax.inject.Inject()
    public UserRepository(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.api.UserApi userApi, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.api.UserApiService userApiService) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMyProfile(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.AuthUserProfile> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUserProfile(long userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.UserProfileResponse> $completion) {
        return null;
    }
}