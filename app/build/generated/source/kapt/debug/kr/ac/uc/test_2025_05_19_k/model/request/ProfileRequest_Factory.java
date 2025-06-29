// Generated by Dagger (https://dagger.dev).
package kr.ac.uc.test_2025_05_19_k.model.request;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kr.ac.uc.test_2025_05_19_k.network.ApiService;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class ProfileRequest_Factory implements Factory<ProfileRequest> {
  private final Provider<ApiService> apiProvider;

  public ProfileRequest_Factory(Provider<ApiService> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public ProfileRequest get() {
    return newInstance(apiProvider.get());
  }

  public static ProfileRequest_Factory create(Provider<ApiService> apiProvider) {
    return new ProfileRequest_Factory(apiProvider);
  }

  public static ProfileRequest newInstance(ApiService api) {
    return new ProfileRequest(api);
  }
}
