package kr.ac.uc.test_2025_05_19_k.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\tH\u0007\u00a8\u0006\n"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/di/RepositoryModule;", "", "()V", "provideGroupRepository", "Lkr/ac/uc/test_2025_05_19_k/repository/GroupRepository;", "api", "Lkr/ac/uc/test_2025_05_19_k/network/api/GroupApi;", "provideUserRepository", "Lkr/ac/uc/test_2025_05_19_k/repository/UserRepository;", "Lkr/ac/uc/test_2025_05_19_k/network/api/UserApi;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class RepositoryModule {
    @org.jetbrains.annotations.NotNull()
    public static final kr.ac.uc.test_2025_05_19_k.di.RepositoryModule INSTANCE = null;
    
    private RepositoryModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.repository.GroupRepository provideGroupRepository(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.api.GroupApi api) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.repository.UserRepository provideUserRepository(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.api.UserApi api) {
        return null;
    }
}