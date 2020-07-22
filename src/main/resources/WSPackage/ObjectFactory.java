package WSPackage;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {

    public ObjectFactory() {
    }

    public Response createResponse() {
        return new Response();
    }

    public Request createRequest() {
        return new Request();
    }

}
