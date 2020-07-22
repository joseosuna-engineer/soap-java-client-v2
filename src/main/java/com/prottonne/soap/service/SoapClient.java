package com.prottonne.soap.service;

import WSPackage.Input;
import WSPackage.Request;
import WSPackage.Response;
import WSPackage.WSClient;
import WSPackage.WSClientSOAPPortType;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoapClient {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WSClient wSClient;

    public SoapClient() {
        super();
    }

    public Response someAction(String someData) {

        Input input = new Input();
        input.setSomeData(someData);

        Request request = new Request();
        request.setInput(input);

        printCallSoap(request.getClass(), request);

        WSClientSOAPPortType port = wSClient.getWSClientPort();

        Response response = port.method(request);

        printCallSoap(response.getClass(), response);

        return response;

    }

    private void printCallSoap(Class<?> aClass, Object crearRequest) {

        try {
            JAXBContext context = JAXBContext.newInstance(aClass);
            Marshaller marshaller = context.createMarshaller();
            StringWriter stringWriter = new StringWriter();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(crearRequest, stringWriter);
            log.info(stringWriter.toString());
        } catch (JAXBException ex) {
            log.error(null, ex);
        }

    }

}
