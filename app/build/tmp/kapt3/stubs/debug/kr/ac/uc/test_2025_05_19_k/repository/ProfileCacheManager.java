package kr.ac.uc.test_2025_05_19_k.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0014\u0010\u000f\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/repository/ProfileCacheManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "clear", "", "loadInterests", "", "", "loadProfile", "Lkr/ac/uc/test_2025_05_19_k/repository/CachedProfile;", "saveInterests", "ids", "saveProfile", "profile", "Lkr/ac/uc/test_2025_05_19_k/ui/profile/ProfileState;", "app_debug"})
public final class ProfileCacheManager {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    private final android.content.SharedPreferences prefs = null;
    
    @javax.inject.Inject()
    public ProfileCacheManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void saveProfile(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.ui.profile.ProfileState profile) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final kr.ac.uc.test_2025_05_19_k.repository.CachedProfile loadProfile() {
        return null;
    }
    
    public final void saveInterests(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> ids) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Long> loadInterests() {
        return null;
    }
    
    public final void clear() {
    }
}