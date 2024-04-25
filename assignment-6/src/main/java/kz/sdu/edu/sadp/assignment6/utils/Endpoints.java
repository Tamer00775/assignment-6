package kz.sdu.edu.sadp.assignment6.utils;

public interface Endpoints {
    public static class BookControllerPath {
        public final static String BASE_PATH = "/api/book";
        public final static String GET_ALL = BASE_PATH;
        public final static String GET_BY_ID = BASE_PATH + "/{id}";
        public final static String SEARCH = BASE_PATH + "/search";
        public final static String CREATE = BASE_PATH;
        public final static String UPDATE = BASE_PATH + "/{id}";
        public final static String DELETE = BASE_PATH + "/{id}";
    }
}
