package kr.ac.uc.test_2025_05_19_k.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000b0\bH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/repository/GoalRepository;", "", "goalApi", "Lkr/ac/uc/test_2025_05_19_k/network/api/GoalApiService;", "groupApi", "Lkr/ac/uc/test_2025_05_19_k/network/api/GroupApi;", "(Lkr/ac/uc/test_2025_05_19_k/network/api/GoalApiService;Lkr/ac/uc/test_2025_05_19_k/network/api/GroupApi;)V", "getGoalsByGroup", "", "Lkr/ac/uc/test_2025_05_19_k/viewmodel/GoalResponse;", "groupId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getJoinedGroupIds", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GoalRepository {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.network.api.GoalApiService goalApi = null;
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.network.api.GroupApi groupApi = null;
    
    @javax.inject.Inject()
    public GoalRepository(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.api.GoalApiService goalApi, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.api.GroupApi groupApi) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getJoinedGroupIds(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<java.lang.Long>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getGoalsByGroup(long groupId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<kr.ac.uc.test_2025_05_19_k.viewmodel.GoalResponse>> $completion) {
        return null;
    }
}