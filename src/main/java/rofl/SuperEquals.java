package rofl;

public class SuperEquals implements Filter {
    private final String pattern;

    public SuperEquals(String pattern) {
        this.pattern = pattern;
    }

    @Override
    public boolean apply(String str) {
        if (str == null) return false;
        str = str.toUpperCase();
        return str.equals(pattern);
    }
}