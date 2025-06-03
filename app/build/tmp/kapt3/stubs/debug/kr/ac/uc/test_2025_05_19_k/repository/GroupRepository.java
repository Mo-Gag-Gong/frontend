package kr.ac.uc.test_2025_05_19_k.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014H\u0086@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/repository/GroupRepository;", "", "groupApi", "Lkr/ac/uc/test_2025_05_19_k/network/api/GroupApi;", "(Lkr/ac/uc/test_2025_05_19_k/network/api/GroupApi;)V", "applyToGroup", "", "groupId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createGroup", "request", "Lkr/ac/uc/test_2025_05_19_k/model/request/GroupCreateRequest;", "(Lkr/ac/uc/test_2025_05_19_k/model/request/GroupCreateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGroupDetail", "Lkr/ac/uc/test_2025_05_19_k/model/StudyGroupDetail;", "getGroups", "", "Lkr/ac/uc/test_2025_05_19_k/model/StudyGroup;", "region", "", "keyword", "interest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class GroupRepository {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.network.api.GroupApi groupApi = null;
    
    @javax.inject.Inject()
    public GroupRepository(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.api.GroupApi groupApi) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getGroups(@org.jetbrains.annotations.NotNull()
    java.lang.String region, @org.jetbrains.annotations.Nullable()
    java.lang.String keyword, @org.jetbrains.annotations.Nullable()
    java.lang.String interest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<kr.ac.uc.test_2025_05_19_k.model.StudyGroup>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getGroupDetail(long groupId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object applyToGroup(long groupId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createGroup(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.request.GroupCreateRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}