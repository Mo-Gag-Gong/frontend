package kr.ac.uc.test_2025_05_19_k.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J(\u00100\u001a\u0002012\f\u00102\u001a\b\u0012\u0004\u0012\u000201032\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020105J\u000e\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\u0006J\u0010\u00108\u001a\u0002012\b\u00109\u001a\u0004\u0018\u00010\u0006J\u000e\u0010:\u001a\u0002012\u0006\u0010;\u001a\u00020\u0006J\u000e\u0010<\u001a\u0002012\u0006\u0010=\u001a\u00020\u0006J\u000e\u0010>\u001a\u0002012\u0006\u0010?\u001a\u00020\u0006J\u0014\u0010@\u001a\u0002012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020)0(R+\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR/\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR/\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR+\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u00168F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR+\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\r\u001a\u0004\b\u001d\u0010\t\"\u0004\b\u001e\u0010\u000bR+\u0010 \u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b#\u0010\r\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000bR+\u0010$\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\'\u0010\r\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R7\u0010*\u001a\b\u0012\u0004\u0012\u00020)0(2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020)0(8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b/\u0010\r\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.\u00a8\u0006B"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/viewmodel/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "repository", "Lkr/ac/uc/test_2025_05_19_k/repository/ProfileRepository;", "(Lkr/ac/uc/test_2025_05_19_k/repository/ProfileRepository;)V", "<set-?>", "", "birthYear", "getBirthYear", "()Ljava/lang/String;", "setBirthYear", "(Ljava/lang/String;)V", "birthYear$delegate", "Landroidx/compose/runtime/MutableState;", "errorMessage", "getErrorMessage", "setErrorMessage", "errorMessage$delegate", "gender", "getGender", "setGender", "gender$delegate", "", "isLoading", "()Z", "setLoading", "(Z)V", "isLoading$delegate", "locationName", "getLocationName", "setLocationName", "locationName$delegate", "name", "getName", "setName", "name$delegate", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "phoneNumber$delegate", "", "", "selectedInterestIds", "getSelectedInterestIds", "()Ljava/util/List;", "setSelectedInterestIds", "(Ljava/util/List;)V", "selectedInterestIds$delegate", "submitProfile", "", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "updateBirthYear", "newBirth", "updateGender", "newGender", "updateLocationName", "newLocation", "updateName", "newName", "updatePhoneNumber", "newNumber", "updateSelectedInterests", "newIds", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ProfileViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.repository.ProfileRepository repository = null;
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
    private final androidx.compose.runtime.MutableState selectedInterestIds$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState isLoading$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState errorMessage$delegate = null;
    
    @javax.inject.Inject()
    public ProfileViewModel(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.ProfileRepository repository) {
        super();
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Long> getSelectedInterestIds() {
        return null;
    }
    
    public final void setSelectedInterestIds(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> p0) {
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
    
    public final void updateSelectedInterests(@org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Long> newIds) {
    }
    
    public final void submitProfile(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onError) {
    }
}