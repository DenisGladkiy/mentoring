package booking.utils;

import java.io.IOException;

public interface Converter {
    Object convertToObject(String path) throws IOException;
}
