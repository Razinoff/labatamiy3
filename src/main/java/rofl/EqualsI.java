package rofl;

public class EqualsI implements Filter {
    private final String pattern;

    public EqualsI(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean apply(String str) {
        if (str == null) return false;
        return str.equals(pattern);
    }
}