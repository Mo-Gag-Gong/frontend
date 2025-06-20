// Generated by Dagger (https://dagger.dev).
package kr.ac.uc.test_2025_05_19_k.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kr.ac.uc.test_2025_05_19_k.network.api.UserApi;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NetworkModule_ProvideUserApiFactory implements Factory<UserApi> {
  private final Provider<Retrofit> retrofitProvider;

  public NetworkModule_ProvideUserApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public UserApi get() {
    return provideUserApi(retrofitProvider.get());
  }

  public static NetworkModule_ProvideUserApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new NetworkModule_ProvideUserApiFactory(retrofitProvider);
  }

  public static UserApi provideUserApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideUserApi(retrofit));
  }
}
