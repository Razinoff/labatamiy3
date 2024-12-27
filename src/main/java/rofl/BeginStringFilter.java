package rofl;

public class BeginStringFilter implements Filter {
    private final String pattern;

    public BeginStringFilter(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean apply(String str) {
        if (str == null) return false;
        return str.startsWith(pattern);
    }
}