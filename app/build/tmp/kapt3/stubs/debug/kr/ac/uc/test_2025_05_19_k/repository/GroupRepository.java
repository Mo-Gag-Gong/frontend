package kr.ac.uc.test_2025_05_19_k.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u0016\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\rJ\u001e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ&\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0019J:\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010 J\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0086@\u00a2\u0006\u0002\u0010$J\u0014\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0086@\u00a2\u0006\u0002\u0010$J4\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"2\u0006\u0010\u001e\u001a\u00020\u001d2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0086@\u00a2\u0006\u0002\u0010\'J$\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130)2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010*R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/repository/GroupRepository;", "", "groupApi", "Lkr/ac/uc/test_2025_05_19_k/network/api/GroupApi;", "(Lkr/ac/uc/test_2025_05_19_k/network/api/GroupApi;)V", "applyToGroup", "", "groupId", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createGroup", "request", "Lkr/ac/uc/test_2025_05_19_k/model/request/GroupCreateRequest;", "(Lkr/ac/uc/test_2025_05_19_k/model/request/GroupCreateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createNotice", "Lkr/ac/uc/test_2025_05_19_k/model/GroupNoticeDto;", "Lkr/ac/uc/test_2025_05_19_k/model/request/GroupNoticeCreateRequest;", "(JLkr/ac/uc/test_2025_05_19_k/model/request/GroupNoticeCreateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGroupDetail", "Lkr/ac/uc/test_2025_05_19_k/model/StudyGroupDetail;", "getGroupNotices", "Lkr/ac/uc/test_2025_05_19_k/model/PageGroupNoticeDto;", "page", "", "size", "(JIILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGroups", "Lkr/ac/uc/test_2025_05_19_k/model/PageStudyGroupDto;", "region", "", "keyword", "interest", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyJoinedGroups", "", "Lkr/ac/uc/test_2025_05_19_k/model/StudyGroup;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getMyOwnedGroups", "searchGroups", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateGroup", "Lretrofit2/Response;", "(JLkr/ac/uc/test_2025_05_19_k/model/request/GroupCreateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
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
    java.lang.String interest, int page, int size, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.PageStudyGroupDto> $completion) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object searchGroups(@org.jetbrains.annotations.NotNull()
    java.lang.String keyword, @org.jetbrains.annotations.Nullable()
    java.lang.Integer page, @org.jetbrains.annotations.Nullable()
    java.lang.Integer size, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<kr.ac.uc.test_2025_05_19_k.model.StudyGroup>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMyJoinedGroups(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<kr.ac.uc.test_2025_05_19_k.model.StudyGroup>> $completion) {
        return null;
    }
    
    /**
     * 현재 사용자가 생성한 스터디 그룹 목록을 가져옵니다.
     */
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMyOwnedGroups(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<kr.ac.uc.test_2025_05_19_k.model.StudyGroup>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateGroup(long groupId, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.request.GroupCreateRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getGroupNotices(long groupId, int page, int size, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.PageGroupNoticeDto> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object createNotice(long groupId, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.request.GroupNoticeCreateRequest request, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kr.ac.uc.test_2025_05_19_k.model.GroupNoticeDto> $completion) {
        return null;
    }
}