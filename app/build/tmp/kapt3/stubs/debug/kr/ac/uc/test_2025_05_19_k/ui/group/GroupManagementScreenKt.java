package kr.ac.uc.test_2025_05_19_k.ui.group;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000:\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001aL\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00012\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u00022\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011H\u0007\u001a\u001a\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"tabs", "", "", "CreatedGroupsTabContent", "", "navController", "Landroidx/navigation/NavController;", "viewModel", "Lkr/ac/uc/test_2025_05_19_k/viewmodel/GroupManagementViewModel;", "GroupListContent", "groups", "Lkr/ac/uc/test_2025_05_19_k/model/StudyGroup;", "isLoading", "", "errorMessage", "emptyListMessage", "onGroupClick", "Lkotlin/Function1;", "", "GroupManagementScreen", "app_debug"})
public final class GroupManagementScreenKt {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<java.lang.String> tabs = null;
    
    @kotlin.OptIn(markerClass = {androidx.compose.material3.ExperimentalMaterial3Api.class})
    @androidx.compose.runtime.Composable()
    public static final void GroupManagementScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.viewmodel.GroupManagementViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void CreatedGroupsTabContent(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.viewmodel.GroupManagementViewModel viewModel) {
    }
    
    @androidx.compose.runtime.Composable()
    public static final void GroupListContent(@org.jetbrains.annotations.NotNull()
    java.util.List<kr.ac.uc.test_2025_05_19_k.model.StudyGroup> groups, boolean isLoading, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage, @org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    java.lang.String emptyListMessage, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Long, kotlin.Unit> onGroupClick) {
    }
}