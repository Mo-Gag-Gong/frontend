package kr.ac.uc.test_2025_05_19_k.ui.gps;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a@\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\b2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007\u001a\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a(\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012H\u0086@\u00a2\u0006\u0002\u0010\u0014\u001a\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u0010\u0017\u001a\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0016\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\t\u001a\u000e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t\u00a8\u0006\u001e"}, d2 = {"PreviewRegionSettingScreen", "", "RegionSettingScreen", "navController", "Landroidx/navigation/NavController;", "onBack", "Lkotlin/Function0;", "onDone", "Lkotlin/Function1;", "", "viewModel", "Lkr/ac/uc/test_2025_05_19_k/viewmodel/RegionSettingViewModel;", "RememberedNavStack", "", "getCityNameFromLocation", "context", "Landroid/content/Context;", "latitude", "", "longitude", "(Landroid/content/Context;DDLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentLocation", "Landroid/location/Location;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isLocationEnabled", "", "saveLocationToPrefs", "cityName", "simplifyCityName", "city", "app_debug"})
public final class RegionSettingScreenKt {
    
    @androidx.compose.runtime.Composable()
    @org.jetbrains.annotations.NotNull()
    public static final java.util.List<java.lang.String> RememberedNavStack(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController) {
        return null;
    }
    
    public static final void saveLocationToPrefs(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String cityName) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object getCurrentLocation(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super android.location.Location> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public static final java.lang.Object getCityNameFromLocation(@org.jetbrains.annotations.NotNull()
    android.content.Context context, double latitude, double longitude, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    public static final boolean isLocationEnabled(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    @androidx.compose.runtime.Composable()
    public static final void RegionSettingScreen(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController navController, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onBack, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onDone, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.viewmodel.RegionSettingViewModel viewModel) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String simplifyCityName(@org.jetbrains.annotations.NotNull()
    java.lang.String city) {
        return null;
    }
    
    @androidx.compose.ui.tooling.preview.Preview(showBackground = true, widthDp = 387, heightDp = 812)
    @androidx.compose.runtime.Composable()
    public static final void PreviewRegionSettingScreen() {
    }
}