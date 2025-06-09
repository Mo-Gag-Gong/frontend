package kr.ac.uc.test_2025_05_19_k.ui.group;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000B\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001aA\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00040\u00102\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0014H\u0007\u001a\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\"\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\u001a\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0007\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"adminDetailTabs", "", "", "AdminChatScreen", "", "navController", "Landroidx/navigation/NavController;", "groupId", "", "AdminGoalsScreen", "AdminMeetingsScreen", "AdminMembersScreen", "AdminNoticeCard", "notice", "Lkr/ac/uc/test_2025_05_19_k/model/GroupNoticeDto;", "onEdit", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onDelete", "Lkotlin/Function0;", "AdminNoticesScreen", "viewModel", "Lkr/ac/uc/test_2025_05_19_k/viewmodel/GroupAdminDetailViewModel;", "GroupAdminDetailScreen", "app_debug"})
public final class GroupAdminDetailScreenKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> adminDetailTabs = null;
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void GroupAdminDetailScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, long groupId, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.viewmodel.GroupAdminDetailViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AdminNoticesScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, long groupId, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.viewmodel.GroupAdminDetailViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AdminNoticeCard(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.GroupNoticeDto notice, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super kr.ac.uc.test_2025_05_19_k.model.GroupNoticeDto, kotlin.Unit> onEdit, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDelete) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AdminNoticesScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, long groupId) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AdminMembersScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, long groupId) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AdminGoalsScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, long groupId) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AdminChatScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, long groupId) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void AdminMeetingsScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, long groupId) {
    }
}