package kr.ac.uc.test_2025_05_19_k.model;

/**
 * Spring Pageable 객체에 대한 정보를 담는 DTO
 * API 명세에 따라 필드 정의
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00c6\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\n2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001J\t\u0010!\u001a\u00020\"H\u00d6\u0001R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013\u00a8\u0006#"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/model/PageableObject;", "", "pageNumber", "", "pageSize", "sort", "Lkr/ac/uc/test_2025_05_19_k/model/SortObject;", "offset", "", "paged", "", "unpaged", "(IILkr/ac/uc/test_2025_05_19_k/model/SortObject;JZZ)V", "getOffset", "()J", "getPageNumber", "()I", "getPageSize", "getPaged", "()Z", "getSort", "()Lkr/ac/uc/test_2025_05_19_k/model/SortObject;", "getUnpaged", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class PageableObject {
    private final int pageNumber = 0;
    private final int pageSize = 0;
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.model.SortObject sort = null;
    private final long offset = 0L;
    private final boolean paged = false;
    private final boolean unpaged = false;
    
    public PageableObject(int pageNumber, int pageSize, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.SortObject sort, long offset, boolean paged, boolean unpaged) {
        super();
    }
    
    public final int getPageNumber() {
        return 0;
    }
    
    public final int getPageSize() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.model.SortObject getSort() {
        return null;
    }
    
    public final long getOffset() {
        return 0L;
    }
    
    public final boolean getPaged() {
        return false;
    }
    
    public final boolean getUnpaged() {
        return false;
    }
    
    public final int component1() {
        return 0;
    }
    
    public final int component2() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.model.SortObject component3() {
        return null;
    }
    
    public final long component4() {
        return 0L;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.model.PageableObject copy(int pageNumber, int pageSize, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.SortObject sort, long offset, boolean paged, boolean unpaged) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}