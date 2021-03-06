package WSPackage;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 *
 */
@WebServiceClient(name = "WSClient", targetNamespace = "data", wsdlLocation = "data")
public class WSClient
        extends Service {

    public WSClient(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    @WebEndpoint(name = "WSClientPort")
    public WSClientSOAPPortType getWSClientPort() {
        return super.getPort(new QName("data", "WSClientPort"), WSClientSOAPPortType.class);
    }

}
