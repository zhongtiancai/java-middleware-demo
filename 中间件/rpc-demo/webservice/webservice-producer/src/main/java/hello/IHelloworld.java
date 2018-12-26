package hello;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public interface IHelloworld {
  @WebMethod
  public String sayHello();
}
