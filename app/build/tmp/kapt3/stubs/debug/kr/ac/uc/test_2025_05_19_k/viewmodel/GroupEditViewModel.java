package kr.ac.uc.test_2025_05_19_k.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010=\u001a\u00020>H\u0002J\b\u0010?\u001a\u00020>H\u0002J\u000e\u0010@\u001a\u00020>2\u0006\u0010A\u001a\u00020\u000bJ\u000e\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u000bJ\u000e\u0010D\u001a\u00020>2\u0006\u0010E\u001a\u00020\u000bJ\u000e\u0010F\u001a\u00020>2\u0006\u0010G\u001a\u00020\u000bJ\u000e\u0010H\u001a\u00020>2\u0006\u0010I\u001a\u00020\u000bJ(\u0010J\u001a\u00020>2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020>0L2\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020>0NR\u0016\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00120\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0019\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0019\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u0011\u0010#\u001a\u00020$\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010 R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00120\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010 R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00120\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010 R+\u0010+\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b.\u0010\u001c\u001a\u0004\b,\u0010\u0018\"\u0004\b-\u0010\u001aR+\u0010/\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b2\u0010\u001c\u001a\u0004\b0\u0010\u0018\"\u0004\b1\u0010\u001aR/\u00103\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b6\u0010\u001c\u001a\u0004\b4\u0010\u0018\"\u0004\b5\u0010\u001aR+\u00107\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b:\u0010\u001c\u001a\u0004\b8\u0010\u0018\"\u0004\b9\u0010\u001aR\u0017\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00120\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010 \u00a8\u0006O"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/viewmodel/GroupEditViewModel;", "Landroidx/lifecycle/ViewModel;", "groupRepository", "Lkr/ac/uc/test_2025_05_19_k/repository/GroupRepository;", "interestRepository", "Lkr/ac/uc/test_2025_05_19_k/repository/InterestRepository;", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "(Lkr/ac/uc/test_2025_05_19_k/repository/GroupRepository;Lkr/ac/uc/test_2025_05_19_k/repository/InterestRepository;Landroidx/lifecycle/SavedStateHandle;)V", "_errorMessage", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_groupDetail", "Lkr/ac/uc/test_2025_05_19_k/model/StudyGroupDetail;", "_interests", "", "Lkr/ac/uc/test_2025_05_19_k/model/Interest;", "_isLoading", "", "_isUpdating", "_updateSuccess", "<set-?>", "description", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "description$delegate", "Landroidx/compose/runtime/MutableState;", "errorMessage", "Lkotlinx/coroutines/flow/StateFlow;", "getErrorMessage", "()Lkotlinx/coroutines/flow/StateFlow;", "groupDetail", "getGroupDetail", "groupId", "", "getGroupId", "()J", "interests", "getInterests", "isLoading", "isUpdating", "maxMembers", "getMaxMembers", "setMaxMembers", "maxMembers$delegate", "requirements", "getRequirements", "setRequirements", "requirements$delegate", "selectedInterestName", "getSelectedInterestName", "setSelectedInterestName", "selectedInterestName$delegate", "title", "getTitle", "setTitle", "title$delegate", "updateSuccess", "getUpdateSuccess", "fetchAllInterests", "", "fetchGroupDetails", "onDescriptionChange", "newDescription", "onInterestChange", "newInterestName", "onMaxMembersChange", "newMaxMembers", "onRequirementsChange", "newRequirements", "onTitleChange", "newTitle", "updateGroupInfo", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class GroupEditViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.GroupRepository groupRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.InterestRepository interestRepository = null;
    private final long groupId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail> _groupDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<kr.ac.uc.test_2025_05_19_k.model.StudyGroupDetail> groupDetail = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.util.List<kr.ac.uc.test_2025_05_19_k.model.Interest>> _interests = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<kr.ac.uc.test_2025_05_19_k.model.Interest>> interests = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState title$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState description$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState requirements$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState selectedInterestName$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState maxMembers$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _isUpdating = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isUpdating = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _updateSuccess = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> updateSuccess = null;
    
    @javax.inject.Inject()
    public GroupEditViewModel(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.GroupRepository groupRepository, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.InterestRepository interestRepository, @org.jetbrains.annotations.NotNull()
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
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<kr.ac.uc.test_2025_05_19_k.model.Interest>> getInterests() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    public final void setTitle(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    public final void setDescription(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRequirements() {
        return null;
    }
    
    public final void setRequirements(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSelectedInterestName() {
        return null;
    }
    
    public final void setSelectedInterestName(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMaxMembers() {
        return null;
    }
    
    public final void setMaxMembers(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> isUpdating() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getUpdateSuccess() {
        return null;
    }
    
    private final void fetchAllInterests() {
    }
    
    private final void fetchGroupDetails() {
    }
    
    public final void updateGroupInfo(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
    
    public final void onTitleChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newTitle) {
    }
    
    public final void onDescriptionChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newDescription) {
    }
    
    public final void onRequirementsChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newRequirements) {
    }
    
    public final void onInterestChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newInterestName) {
    }
    
    public final void onMaxMembersChange(@org.jetbrains.annotations.NotNull()
    java.lang.String newMaxMembers) {
    }
}