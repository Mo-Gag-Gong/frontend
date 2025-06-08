package kr.ac.uc.test_2025_05_19_k.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010?\u001a\u00020@J\b\u0010A\u001a\u00020@H\u0002J(\u0010B\u001a\u00020@2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020@0D2\u0012\u0010E\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020@0FJ\u000e\u0010G\u001a\u00020@2\u0006\u0010H\u001a\u00020:J\u000e\u0010I\u001a\u00020@2\u0006\u0010J\u001a\u00020\bJ\u000e\u0010K\u001a\u00020@2\u0006\u0010L\u001a\u00020\bJ\u000e\u0010M\u001a\u00020@2\u0006\u0010N\u001a\u00020\bJ\u000e\u0010O\u001a\u00020@2\u0006\u0010P\u001a\u00020\bJ\u000e\u0010Q\u001a\u00020@2\u0006\u0010R\u001a\u00020\bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\rR+\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR/\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u000f\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR+\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\"\u0010\u000f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R7\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020$0#8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b*\u0010\u000f\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R+\u0010+\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001c8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b-\u0010\u000f\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010!R+\u0010.\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b1\u0010\u000f\u001a\u0004\b/\u0010\u000b\"\u0004\b0\u0010\rR+\u00102\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b5\u0010\u000f\u001a\u0004\b3\u0010\u000b\"\u0004\b4\u0010\rR+\u00106\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b9\u0010\u000f\u001a\u0004\b7\u0010\u000b\"\u0004\b8\u0010\rR7\u0010;\u001a\b\u0012\u0004\u0012\u00020:0#2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020:0#8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b>\u0010\u000f\u001a\u0004\b<\u0010\'\"\u0004\b=\u0010)\u00a8\u0006S"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/viewmodel/ProfileInputViewModel;", "Landroidx/lifecycle/ViewModel;", "cacheManager", "Lkr/ac/uc/test_2025_05_19_k/repository/ProfileCacheManager;", "api", "Lkr/ac/uc/test_2025_05_19_k/network/ApiService;", "(Lkr/ac/uc/test_2025_05_19_k/repository/ProfileCacheManager;Lkr/ac/uc/test_2025_05_19_k/network/ApiService;)V", "<set-?>", "", "birthYear", "getBirthYear", "()Ljava/lang/String;", "setBirthYear", "(Ljava/lang/String;)V", "birthYear$delegate", "Landroidx/compose/runtime/MutableState;", "errorMessage", "getErrorMessage", "setErrorMessage", "errorMessage$delegate", "gender", "getGender", "setGender", "gender$delegate", "interestError", "getInterestError", "setInterestError", "interestError$delegate", "", "interestLoading", "getInterestLoading", "()Z", "setInterestLoading", "(Z)V", "interestLoading$delegate", "", "Lkr/ac/uc/test_2025_05_19_k/model/Interest;", "interests", "getInterests", "()Ljava/util/List;", "setInterests", "(Ljava/util/List;)V", "interests$delegate", "isLoading", "setLoading", "isLoading$delegate", "locationName", "getLocationName", "setLocationName", "locationName$delegate", "name", "getName", "setName", "name$delegate", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "phoneNumber$delegate", "", "selectedInterestIds", "getSelectedInterestIds", "setSelectedInterestIds", "selectedInterestIds$delegate", "loadInterests", "", "saveProfileToCache", "submitProfile", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "toggleInterest", "id", "updateBirthYear", "newBirth", "updateGender", "newGender", "updateLocation", "newLoc", "updateName", "newName", "updatePhoneNumber", "newNum", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ProfileInputViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.ProfileCacheManager cacheManager = null;
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.network.ApiService api = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState interests$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState interestLoading$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState interestError$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState selectedInterestIds$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState name$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState gender$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState phoneNumber$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState birthYear$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState locationName$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isLoading$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState errorMessage$delegate = null;
    
    @javax.inject.Inject()
    public ProfileInputViewModel(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.ProfileCacheManager cacheManager, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.ApiService api) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kr.ac.uc.test_2025_05_19_k.model.Interest> getInterests() {
        return null;
    }
    
    public final void setInterests(@org.jetbrains.annotations.NotNull()
    java.util.List<kr.ac.uc.test_2025_05_19_k.model.Interest> p0) {
    }
    
    public final boolean getInterestLoading() {
        return false;
    }
    
    public final void setInterestLoading(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getInterestError() {
        return null;
    }
    
    public final void setInterestError(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Long> getSelectedInterestIds() {
        return null;
    }
    
    public final void setSelectedInterestIds(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getName() {
        return null;
    }
    
    public final void setName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGender() {
        return null;
    }
    
    public final void setGender(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPhoneNumber() {
        return null;
    }
    
    public final void setPhoneNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getBirthYear() {
        return null;
    }
    
    public final void setBirthYear(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLocationName() {
        return null;
    }
    
    public final void setLocationName(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final void setLoading(boolean p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    public final void setErrorMessage(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    /**
     * 관심사 목록 불러오기 - 서버에서 가져옴
     */
    public final void loadInterests() {
    }
    
    /**
     * 관심사 선택/해제
     */
    public final void toggleInterest(long id) {
    }
    
    public final void updateName(@org.jetbrains.annotations.NotNull()
    java.lang.String newName) {
    }
    
    public final void updateGender(@org.jetbrains.annotations.NotNull()
    java.lang.String newGender) {
    }
    
    public final void updatePhoneNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String newNum) {
    }
    
    public final void updateBirthYear(@org.jetbrains.annotations.NotNull()
    java.lang.String newBirth) {
    }
    
    public final void updateLocation(@org.jetbrains.annotations.NotNull()
    java.lang.String newLoc) {
    }
    
    private final void saveProfileToCache() {
    }
    
    public final void submitProfile(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
}