package booking.utils.impl;

import booking.utils.Converter;
import org.springframework.oxm.Unmarshaller;

import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.IOException;

public class XmlConverter implements Converter {

    private Unmarshaller unmarshaller;

    public Object convertToObject(String path) throws IOException {

        FileInputStream is = null;
        try {
            is = new FileInputStream(path);
            return unmarshaller.unmarshal(new StreamSource(is));
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
}
