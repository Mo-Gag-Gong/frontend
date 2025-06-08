package kr.ac.uc.test_2025_05_19_k.data.local;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\bJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010\r\u001a\u00020\nJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000fJ\u0006\u0010\u0010\u001a\u00020\nJ\u0006\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\nJ\u000e\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\nJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/data/local/UserPreference;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "prefs", "Landroid/content/SharedPreferences;", "addRecentSearch", "", "query", "", "clearOnboardingAndLocation", "clearRecentSearches", "getLocation", "getRecentSearches", "", "getRegion", "isOnboardingCompleted", "", "removeRecentSearch", "saveLocation", "location", "saveRegion", "region", "setOnboardingCompleted", "completed", "Companion", "app_debug"})
public final class UserPreference {
    @org.jetbrains.annotations.NotNull()
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String USER_PREFERENCES_NAME = "user_prefs";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_ONBOARDING_COMPLETED = "onboarding_completed";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_LOCATION = "location_name";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String KEY_RECENT_SEARCHES = "recent_searches";
    private static final int MAX_RECENT_SEARCHES = 5;
    @org.jetbrains.annotations.NotNull()
    public static final kr.ac.uc.test_2025_05_19_k.data.local.UserPreference.Companion Companion = null;
    
    @javax.inject.Inject()
    public UserPreference(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    /**
     * 사용자의 온보딩 완료 상태를 저장합니다.
     * @param completed 온보딩 완료 여부 (true: 완료, false: 미완료)
     */
    public final void setOnboardingCompleted(boolean completed) {
    }
    
    /**
     * 사용자의 온보딩 완료 상태를 조회합니다.
     * @return 온보딩 완료 여부. 저장된 값이 없으면 false를 반환합니다.
     */
    public final boolean isOnboardingCompleted() {
        return false;
    }
    
    public final void saveLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String location) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocation() {
        return null;
    }
    
    public final void clearOnboardingAndLocation() {
    }
    
    public final void addRecentSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getRecentSearches() {
        return null;
    }
    
    public final void removeRecentSearch(@org.jetbrains.annotations.NotNull()
    java.lang.String query) {
    }
    
    public final void clearRecentSearches() {
    }
    
    public final void saveRegion(@org.jetbrains.annotations.NotNull()
    java.lang.String region) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRegion() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/data/local/UserPreference$Companion;", "", "()V", "KEY_LOCATION", "", "KEY_ONBOARDING_COMPLETED", "KEY_RECENT_SEARCHES", "MAX_RECENT_SEARCHES", "", "USER_PREFERENCES_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}