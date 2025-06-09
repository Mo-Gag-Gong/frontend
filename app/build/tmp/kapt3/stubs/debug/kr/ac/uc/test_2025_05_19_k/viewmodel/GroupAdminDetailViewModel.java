package kr.ac.uc.test_2025_05_19_k.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010%\u001a\u00020&2\u0012\u0010\'\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020&0(J\b\u0010*\u001a\u00020&H\u0002J\u0006\u0010+\u001a\u00020&J\u0010\u0010,\u001a\u00020&2\u0006\u0010-\u001a\u00020\u0012H\u0002J\u0006\u0010.\u001a\u00020&J\u000e\u0010/\u001a\u00020&2\u0006\u00100\u001a\u00020\u0018R\u0016\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0012\u0010 \u001a\u0004\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0004\n\u0002\u0010!R\u000e\u0010\"\u001a\u00020\u0012X\u0082D\u00a2\u0006\u0002\n\u0000R\u0017\u0010#\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016\u00a8\u00061"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/viewmodel/GroupAdminDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "groupRepository", "Lkr/ac/uc/test_2025_05_19_k/repository/GroupRepository;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lkr/ac/uc/test_2025_05_19_k/repository/GroupRepository;Landroidx/lifecycle/SavedStateHandle;)V", "_groupDetail", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lkr/ac/uc/test_2025_05_19_k/model/StudyGroupDetail;", "_groupNotices", "", "Lkr/ac/uc/test_2025_05_19_k/model/GroupNoticeDto;", "_isLoading", "", "_isLoadingNotices", "_showDeleteConfirmDialog", "currentNoticePage", "", "groupDetail", "Lkotlinx/coroutines/flow/StateFlow;", "getGroupDetail", "()Lkotlinx/coroutines/flow/StateFlow;", "groupId", "", "getGroupId", "()J", "groupNotices", "getGroupNotices", "isLastNoticePage", "isLoading", "isLoadingNotices", "noticeIdToDelete", "Ljava/lang/Long;", "noticePageSize", "showDeleteConfirmDialog", "getShowDeleteConfirmDialog", "deleteNotice", "", "onError", "Lkotlin/Function1;", "", "fetchGroupDetails", "fetchNoticesFirstPage", "fetchNoticesPage", "page", "onDismissDeleteDialog", "onOpenDeleteDialog", "noticeId", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class GroupAdminDetailViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.GroupRepository groupRepository = null;
    private final long groupId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail> _groupDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail> groupDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<kr.ac.uc.test_2025_05_19_k.model.GroupNoticeDto>> _groupNotices = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<kr.ac.uc.test_2025_05_19_k.model.GroupNoticeDto>> groupNotices = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoadingNotices = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoadingNotices = null;
    private int currentNoticePage = 0;
    private final int noticePageSize = 20;
    private boolean isLastNoticePage = false;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _showDeleteConfirmDialog = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> showDeleteConfirmDialog = null;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Long noticeIdToDelete;
    
    @javax.inject.Inject()
    public GroupAdminDetailViewModel(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.GroupRepository groupRepository, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        super();
    }
    
    public final long getGroupId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail> getGroupDetail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<kr.ac.uc.test_2025_05_19_k.model.GroupNoticeDto>> getGroupNotices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoadingNotices() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getShowDeleteConfirmDialog() {
        return null;
    }
    
    private final void fetchGroupDetails() {
    }
    
    public final void fetchNoticesFirstPage() {
    }
    
    private final void fetchNoticesPage(int page) {
    }
    
    public final void onOpenDeleteDialog(long noticeId) {
    }
    
    /**
     * 삭제 확인 대화상자를 닫습니다.
     */
    public final void onDismissDeleteDialog() {
    }
    
    /**
     * 저장된 noticeIdToDelete를 사용하여 공지사항을 삭제합니다.
     */
    public final void deleteNotice(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
}