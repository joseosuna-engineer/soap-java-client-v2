package WSPackage;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

@WebService(name = "WSClientSOAPPortType", targetNamespace = "data")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WSClientSOAPPortType {

    @WebMethod(action = "data")
    @WebResult(name = "data", targetNamespace = "data", partName = "parameters")
    public Response method(
            @WebParam(name = "data", targetNamespace = "data", partName = "parameters") Request parameters);

}
