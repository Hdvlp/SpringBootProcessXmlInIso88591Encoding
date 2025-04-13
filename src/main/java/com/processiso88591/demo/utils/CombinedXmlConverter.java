package com.processiso88591.demo.utils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.MediaType;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class CombinedXmlConverter<T> extends AbstractHttpMessageConverter<T> {

    private final Class<T> targetType;
    private final Unmarshaller unmarshaller;

    public CombinedXmlConverter(Class<T> targetType) throws JAXBException {
        super(MediaType.APPLICATION_XML);
        this.targetType = targetType;

        JAXBContext jaxbContext = JAXBContext.newInstance(targetType);
        this.unmarshaller = jaxbContext.createUnmarshaller();
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return targetType.equals(clazz);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected T readInternal(Class<? extends T> clazz, HttpInputMessage inputMessage) throws IOException {
        try {

            InputStream inputStream = inputMessage.getBody();
            String rawXml = new String(inputStream.readAllBytes(), StandardCharsets.ISO_8859_1);

            // The declaration was
            // <?xml version="1.0"?>
            // when the correct encoding in use
            // was actually ISO-8859-1.

            // The declaration
            // <?xml version="1.0" encoding="ISO-8859-1"?>
            // is explicit and is necessary.

            // <?xml version="1.0"?>
            // should be replaced with
            // <?xml version="1.0" encoding="ISO-8859-1"?>
            // on the fly to make the unmarshal method work.

            String modifiedXml = rawXml.replace("<?xml version=\"1.0\"?>", "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>");

            return (T) unmarshaller.unmarshal(new java.io.StringReader(modifiedXml));
        } catch (JAXBException e) {
            throw new IOException("Error unmarshalling XML to Java class", e);
        }
    }

    @Override
    protected void writeInternal(T t, HttpOutputMessage outputMessage) throws IOException {
        throw new UnsupportedOperationException("Write operation is not supported");
    }
}
