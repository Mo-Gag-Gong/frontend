// Generated by Dagger (https://dagger.dev).
package kr.ac.uc.test_2025_05_19_k.viewmodel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.internal.lifecycle.HiltViewModelMap.KeySet")
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class GroupManagementViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<String> {
  @Override
  public String get() {
    return provide();
  }

  public static GroupManagementViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provide() {
    return Preconditions.checkNotNullFromProvides(GroupManagementViewModel_HiltModules.KeyModule.provide());
  }

  private static final class InstanceHolder {
    private static final GroupManagementViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new GroupManagementViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
