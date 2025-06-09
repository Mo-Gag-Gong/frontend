package kr.ac.uc.test_2025_05_19_k.di;

/**
 * 네트워크 및 API DI 모듈
 * 싱글톤 객체로 Gson, OkHttp, Retrofit, ApiService, TokenManager 등 제공
 */
@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nH\u0007J\u0018\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012H\u0007J\u0012\u0010\u0019\u001a\u00020\f2\b\b\u0001\u0010\u001a\u001a\u00020\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/di/NetworkModule;", "", "()V", "BASE_URL", "", "provideApiService", "Lkr/ac/uc/test_2025_05_19_k/network/ApiService;", "retrofit", "Lretrofit2/Retrofit;", "provideAuthInterceptor", "Lkr/ac/uc/test_2025_05_19_k/network/AuthInterceptor;", "tokenManager", "Lkr/ac/uc/test_2025_05_19_k/repository/TokenManager;", "apiService", "Ldagger/Lazy;", "provideGroupApi", "Lkr/ac/uc/test_2025_05_19_k/network/api/GroupApi;", "provideGson", "Lcom/google/gson/Gson;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "authInterceptor", "provideRetrofit", "client", "gson", "provideTokenManager", "context", "Landroid/content/Context;", "provideUserApi", "Lkr/ac/uc/test_2025_05_19_k/network/api/UserApi;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String BASE_URL = "http://springboot-developer-env.eba-mikwqecm.ap-northeast-2.elasticbeanstalk.com/";
    @org.jetbrains.annotations.NotNull()
    public static final kr.ac.uc.test_2025_05_19_k.di.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
        super();
    }
    
    /**
     * Gson 객체 제공 (JSON 파싱에 사용)
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    /**
     * TokenManager 싱글톤 제공 (앱 전체 인증 토큰 관리)
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.repository.TokenManager provideTokenManager(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
    
    /**
     * AuthInterceptor 싱글톤 제공 (모든 HTTP 요청에 토큰 자동 추가)
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.network.AuthInterceptor provideAuthInterceptor(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.repository.TokenManager tokenManager, @org.jetbrains.annotations.NotNull()
    dagger.Lazy<kr.ac.uc.test_2025_05_19_k.network.ApiService> apiService) {
        return null;
    }
    
    /**
     * OkHttpClient 싱글톤 제공 (인터셉터 포함, 타임아웃 30초)
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.network.AuthInterceptor authInterceptor) {
        return null;
    }
    
    /**
     * Retrofit 싱글톤 제공 (기본 URL, Gson 컨버터, OkHttp 클라이언트 사용)
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient client, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
    
    /**
     * ApiService 싱글톤 제공 (통합 서버 API)
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.network.ApiService provideApiService(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    /**
     * UserApi 싱글톤 제공 (유저 전용 API)
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.network.api.UserApi provideUserApi(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    /**
     * GroupApi 싱글톤 제공 (그룹 전용 API)
     */
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.network.api.GroupApi provideGroupApi(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
}