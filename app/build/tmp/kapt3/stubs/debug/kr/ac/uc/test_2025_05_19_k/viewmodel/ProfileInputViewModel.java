package kr.ac.uc.test_2025_05_19_k.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010A\u001a\u00020BJ\b\u0010C\u001a\u00020BH\u0002J\b\u0010D\u001a\u00020BH\u0002J(\u0010E\u001a\u00020B2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020B0G2\u0012\u0010H\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020B0IJ\u000e\u0010J\u001a\u00020B2\u0006\u0010K\u001a\u00020<J\u000e\u0010L\u001a\u00020B2\u0006\u0010M\u001a\u00020\nJ\u0010\u0010N\u001a\u00020B2\b\u0010O\u001a\u0004\u0018\u00010\nJ\u000e\u0010P\u001a\u00020B2\u0006\u0010Q\u001a\u00020\nJ\u000e\u0010R\u001a\u00020B2\u0006\u0010S\u001a\u00020\nJ\u000e\u0010T\u001a\u00020B2\u0006\u0010U\u001a\u00020\nR+\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u000fR/\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u0011\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR/\u0010\u001a\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u0011\u001a\u0004\b\u001b\u0010\r\"\u0004\b\u001c\u0010\u000fR+\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u001e8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b$\u0010\u0011\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R7\u0010\'\u001a\b\u0012\u0004\u0012\u00020&0%2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020&0%8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b,\u0010\u0011\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R+\u0010-\u001a\u00020\u001e2\u0006\u0010\t\u001a\u00020\u001e8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b/\u0010\u0011\u001a\u0004\b-\u0010!\"\u0004\b.\u0010#R+\u00100\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b3\u0010\u0011\u001a\u0004\b1\u0010\r\"\u0004\b2\u0010\u000fR+\u00104\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b7\u0010\u0011\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000fR+\u00108\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b;\u0010\u0011\u001a\u0004\b9\u0010\r\"\u0004\b:\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R7\u0010=\u001a\b\u0012\u0004\u0012\u00020<0%2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020<0%8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b@\u0010\u0011\u001a\u0004\b>\u0010)\"\u0004\b?\u0010+\u00a8\u0006V"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/viewmodel/ProfileInputViewModel;", "Landroidx/lifecycle/ViewModel;", "profileRepository", "Lkr/ac/uc/test_2025_05_19_k/repository/ProfileRepository;", "interestRepository", "Lkr/ac/uc/test_2025_05_19_k/repository/InterestRepository;", "cacheManager", "Lkr/ac/uc/test_2025_05_19_k/repository/ProfileCacheManager;", "(Lkr/ac/uc/test_2025_05_19_k/repository/ProfileRepository;Lkr/ac/uc/test_2025_05_19_k/repository/InterestRepository;Lkr/ac/uc/test_2025_05_19_k/repository/ProfileCacheManager;)V", "<set-?>", "", "birthYear", "getBirthYear", "()Ljava/lang/String;", "setBirthYear", "(Ljava/lang/String;)V", "birthYear$delegate", "Landroidx/compose/runtime/MutableState;", "errorMessage", "getErrorMessage", "setErrorMessage", "errorMessage$delegate", "gender", "getGender", "setGender", "gender$delegate", "interestError", "getInterestError", "setInterestError", "interestError$delegate", "", "interestLoading", "getInterestLoading", "()Z", "setInterestLoading", "(Z)V", "interestLoading$delegate", "", "Lkr/ac/uc/test_2025_05_19_k/model/Interest;", "interests", "getInterests", "()Ljava/util/List;", "setInterests", "(Ljava/util/List;)V", "interests$delegate", "isLoading", "setLoading", "isLoading$delegate", "locationName", "getLocationName", "setLocationName", "locationName$delegate", "name", "getName", "setName", "name$delegate", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "phoneNumber$delegate", "", "selectedInterestIds", "getSelectedInterestIds", "setSelectedInterestIds", "selectedInterestIds$delegate", "loadInterests", "", "saveInterestsToCache", "saveProfileToCache", "submitProfile", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "toggleInterest", "interestId", "updateBirthYear", "newBirth", "updateGender", "newGender", "updateLocationName", "newLocation", "updateName", "newName", "updatePhoneNumber", "newNumber", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ProfileInputViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.ProfileRepository profileRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.InterestRepository interestRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.ProfileCacheManager cacheManager = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState interests$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState interestError$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState interestLoading$delegate = null;
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
    kr.ac.uc.test_2025_05_19_k.repository.ProfileRepository profileRepository, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.InterestRepository interestRepository, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.ProfileCacheManager cacheManager) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kr.ac.uc.test_2025_05_19_k.model.Interest> getInterests() {
        return null;
    }
    
    public final void setInterests(@org.jetbrains.annotations.NotNull()
    java.util.List<kr.ac.uc.test_2025_05_19_k.model.Interest> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getInterestError() {
        return null;
    }
    
    public final void setInterestError(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final boolean getInterestLoading() {
        return false;
    }
    
    public final void setInterestLoading(boolean p0) {
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getGender() {
        return null;
    }
    
    public final void setGender(@org.jetbrains.annotations.Nullable()
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
     * 관심사 목록 불러오기
     */
    public final void loadInterests() {
    }
    
    /**
     * 관심사 토글 선택
     */
    public final void toggleInterest(long interestId) {
    }
    
    private final void saveInterestsToCache() {
    }
    
    public final void updateName(@org.jetbrains.annotations.NotNull()
    java.lang.String newName) {
    }
    
    public final void updateGender(@org.jetbrains.annotations.Nullable()
    java.lang.String newGender) {
    }
    
    public final void updatePhoneNumber(@org.jetbrains.annotations.NotNull()
    java.lang.String newNumber) {
    }
    
    public final void updateBirthYear(@org.jetbrains.annotations.NotNull()
    java.lang.String newBirth) {
    }
    
    public final void updateLocationName(@org.jetbrains.annotations.NotNull()
    java.lang.String newLocation) {
    }
    
    private final void saveProfileToCache() {
    }
    
    /**
     * 프로필 저장 (관심사 포함)
     */
    public final void submitProfile(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
}