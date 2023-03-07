public interface Map< K, V> {
    /* Make nessecary abstract method defns */
    abstract void get();
    abstract void contains();
    abstract void put();
    abstract void remove();
    abstract void replace();
}