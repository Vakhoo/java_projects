public enum Level {
    LOW(1){
        @Override
        public String asLowerCase() {
            return this.toString().toLowerCase();
        }
    },
    MEDIUM(2){
        @Override
        public String asLowerCase() {
            return this.toString().toLowerCase();
        }
    };

    private final int code;

    Level(int code){
        this.code = code;
    }

    public abstract String asLowerCase();
}
