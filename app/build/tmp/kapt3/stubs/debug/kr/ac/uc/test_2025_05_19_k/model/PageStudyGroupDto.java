package kr.ac.uc.test_2025_05_19_k.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0011H\u00c6\u0003J\t\u0010(\u001a\u00020\u0013H\u00c6\u0003J\t\u0010)\u001a\u00020\u0006H\u00c6\u0003J\t\u0010*\u001a\u00020\bH\u00c6\u0003J\t\u0010+\u001a\u00020\u0006H\u00c6\u0003J\t\u0010,\u001a\u00020\u0006H\u00c6\u0003J\t\u0010-\u001a\u00020\fH\u00c6\u0003J\t\u0010.\u001a\u00020\fH\u00c6\u0003J\t\u0010/\u001a\u00020\fH\u00c6\u0003J\t\u00100\u001a\u00020\u0006H\u00c6\u0003J}\u00101\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u00c6\u0001J\u0013\u00102\u001a\u00020\f2\b\u00103\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00104\u001a\u00020\u0006H\u00d6\u0001J\t\u00105\u001a\u000206H\u00d6\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\t\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001c\u00a8\u00067"}, d2 = {"Lkr/ac/uc/test_2025_05_19_k/model/PageStudyGroupDto;", "", "content", "", "Lkr/ac/uc/test_2025_05_19_k/model/StudyGroup;", "totalPages", "", "totalElements", "", "size", "number", "first", "", "last", "empty", "numberOfElements", "pageable", "Lkr/ac/uc/test_2025_05_19_k/model/PageableObject;", "sort", "Lkr/ac/uc/test_2025_05_19_k/model/SortObject;", "(Ljava/util/List;IJIIZZZILkr/ac/uc/test_2025_05_19_k/model/PageableObject;Lkr/ac/uc/test_2025_05_19_k/model/SortObject;)V", "getContent", "()Ljava/util/List;", "getEmpty", "()Z", "getFirst", "getLast", "getNumber", "()I", "getNumberOfElements", "getPageable", "()Lkr/ac/uc/test_2025_05_19_k/model/PageableObject;", "getSize", "getSort", "()Lkr/ac/uc/test_2025_05_19_k/model/SortObject;", "getTotalElements", "()J", "getTotalPages", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "", "app_debug"})
public final class PageStudyGroupDto {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kr.ac.uc.test_2025_05_19_k.model.StudyGroup> content = null;
    private final int totalPages = 0;
    private final long totalElements = 0L;
    private final int size = 0;
    private final int number = 0;
    private final boolean first = false;
    private final boolean last = false;
    private final boolean empty = false;
    private final int numberOfElements = 0;
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.model.PageableObject pageable = null;
    @org.jetbrains.annotations.NotNull()
    private final kr.ac.uc.test_2025_05_19_k.model.SortObject sort = null;
    
    public PageStudyGroupDto(@org.jetbrains.annotations.NotNull()
    java.util.List<kr.ac.uc.test_2025_05_19_k.model.StudyGroup> content, int totalPages, long totalElements, int size, int number, boolean first, boolean last, boolean empty, int numberOfElements, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.PageableObject pageable, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.SortObject sort) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kr.ac.uc.test_2025_05_19_k.model.StudyGroup> getContent() {
        return null;
    }
    
    public final int getTotalPages() {
        return 0;
    }
    
    public final long getTotalElements() {
        return 0L;
    }
    
    public final int getSize() {
        return 0;
    }
    
    public final int getNumber() {
        return 0;
    }
    
    public final boolean getFirst() {
        return false;
    }
    
    public final boolean getLast() {
        return false;
    }
    
    public final boolean getEmpty() {
        return false;
    }
    
    public final int getNumberOfElements() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.model.PageableObject getPageable() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.model.SortObject getSort() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<kr.ac.uc.test_2025_05_19_k.model.StudyGroup> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.model.PageableObject component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.model.SortObject component11() {
        return null;
    }
    
    public final int component2() {
        return 0;
    }
    
    public final long component3() {
        return 0L;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kr.ac.uc.test_2025_05_19_k.model.PageStudyGroupDto copy(@org.jetbrains.annotations.NotNull()
    java.util.List<kr.ac.uc.test_2025_05_19_k.model.StudyGroup> content, int totalPages, long totalElements, int size, int number, boolean first, boolean last, boolean empty, int numberOfElements, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.PageableObject pageable, @org.jetbrains.annotations.NotNull()
    kr.ac.uc.test_2025_05_19_k.model.SortObject sort) {
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