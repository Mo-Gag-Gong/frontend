// Generated by Dagger (https://dagger.dev).
package kr.ac.uc.test_2025_05_19_k.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;
import kr.ac.uc.test_2025_05_19_k.repository.GroupRepository;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class NoticeCreateViewModel_Factory implements Factory<NoticeCreateViewModel> {
  private final Provider<GroupRepository> groupRepositoryProvider;

  public NoticeCreateViewModel_Factory(Provider<GroupRepository> groupRepositoryProvider) {
    this.groupRepositoryProvider = groupRepositoryProvider;
  }

  @Override
  public NoticeCreateViewModel get() {
    return newInstance(groupRepositoryProvider.get());
  }

  public static NoticeCreateViewModel_Factory create(
      Provider<GroupRepository> groupRepositoryProvider) {
    return new NoticeCreateViewModel_Factory(groupRepositoryProvider);
  }

  public static NoticeCreateViewModel newInstance(GroupRepository groupRepository) {
    return new NoticeCreateViewModel(groupRepository);
  }
}
