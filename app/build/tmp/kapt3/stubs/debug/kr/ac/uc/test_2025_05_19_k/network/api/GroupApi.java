package kr.ac.uc.test_2025_05_19_k.network.api;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\u00032\b\b\u0001\u0010\b\u001a\u00020\tH\u00a7@\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\u00020\f2\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J6\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\b\b\u0001\u0010\u0010\u001a\u00020\u00112\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u00112\n\b\u0001\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/network/api/GroupApi;", "", "applyToGroup", "", "groupId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createGroup", "request", "Lkr/ac/uc/test_2025_05_19_k/model/request/GroupCreateRequest;", "(Lkr/ac/uc/test_2025_05_19_k/model/request/GroupCreateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGroupDetail", "Lkr/ac/uc/test_2025_05_19_k/model/StudyGroupDetail;", "getGroups", "", "Lkr/ac/uc/test_2025_05_19_k/model/StudyGroup;", "region", "", "keyword", "interest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface GroupApi {
    
    @retrofit2.http.GET(value = "/api/groups")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGroups(@retrofit2.http.Query(value = "region")
    @org.jetbrains.annotations.NotNull()
    java.lang.String region, @retrofit2.http.Query(value = "keyword")
    @org.jetbrains.annotations.Nullable()
    java.lang.String keyword, @retrofit2.http.Query(value = "interest")
    @org.jetbrains.annotations.Nullable()
    java.lang.String interest, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<kr.ac.uc.test_2025_05_19_k.model.StudyGroup>> $completion);
    
    @retrofit2.http.GET(value = "/api/groups/{id}")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getGroupDetail(@retrofit2.http.Path(value = "id")
    long groupId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail> $completion);
    
    @retrofit2.http.POST(value = "/api/groups/{groupId}/apply")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object applyToGroup(@retrofit2.http.Path(value = "groupId")
    long groupId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @retrofit2.http.POST(value = "/api/groups")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object createGroup(@retrofit2.http.Body()
    @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.request.GroupCreateRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}