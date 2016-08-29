package final1.ws;

import final1.domain.Goal;
import final1.domain.Healthprofile;
import final1.domain.Person;
import final1.domain.Type;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

//Methods used in the webservice
@WebService
@SOAPBinding(style = Style.DOCUMENT, use=Use.LITERAL) //optional
public interface People {
    @WebMethod(operationName="getPersonById")
//    @WebResult(name="person") 
    public Person getPersonById(@WebParam(name="pid") int pid);
 
    @WebMethod(operationName="getAllPeople")
//    @WebResult(name="person") 
    public List<Person> getAll();
 
    @WebMethod(operationName="savePerson")
//    @WebResult(name="person") 
    public Person savePerson(@WebParam(name="person") String person);
 
    @WebMethod(operationName="updatePerson")
//    @WebResult(name="person") 
    public Person updatePerson(@WebParam(name="person") String person);
    
    @WebMethod(operationName="removePerson")
//    @WebResult(name="person") 
    public List<Person> removePerson(@WebParam(name="pid") int pid);
    
 @WebMethod(operationName="getHProfByPrsnMeasure")
//    @WebResult(name="measure") 
    public List<Healthprofile> getHProfByPrsnMeasure(@WebParam(name="pid") int pid,@WebParam(name="measure") String mes);  
    
    
    @WebMethod(operationName="getHealthprofByPid")
//    @WebResult(name="measure") 
    public List<Healthprofile> getHealthprofByPid(@WebParam(name="pid") int pid);
    
 @WebMethod(operationName="getHealthProfByPidTid")
//    @WebResult(name="measure") 
    public Healthprofile getHealthProfByPidTid(@WebParam(name="pid") int pid,@WebParam(name="mid") int mid);  
        

@WebMethod(operationName="getHealthById")
//    @WebResult(name="measure") 
    public Healthprofile getHealthById(@WebParam(name="hid") int hid);    
    
@WebMethod(operationName="saveHealthprofile")
//    @WebResult(name="measure") 
    public Healthprofile saveHealthprofile(@WebParam(name="hprof") String hprof);
    
@WebMethod(operationName="updateHealth")
//    @WebResult(name="measure") 
    public Healthprofile updateHealth(@WebParam(name="hprof") String hprof);

@WebMethod(operationName="removeHealth")
//    @WebResult(name="measure") 
    public Healthprofile removeHealth(@WebParam(name="hid") int hid);
      
@WebMethod(operationName="getAllHealth")
//    @WebResult(name="measuretype") 
    public List<Healthprofile> getAllHealth();
    
    
    @WebMethod(operationName="getAllType")
//    @WebResult(name="measuretype") 
    public List<Type> getAllType();
    
@WebMethod(operationName="getTypeById")
//    @WebResult(name="measure") 
    public Type getTypeById(@WebParam(name="tid") int tid);    
    
@WebMethod(operationName="getTypeByString")
//    @WebResult(name="measure") 
    public List<Type> getTypeByString(@WebParam(name="mes") String mes);    
    
    @WebMethod(operationName="saveType")
//    @WebResult(name="measuretype") 
    public Type saveType(@WebParam(name="typ") String typ);  
    
   @WebMethod(operationName="updateType")
//    @WebResult(name="measuretype") 
    public Type updateType(@WebParam(name="typ") String typ);
    
   @WebMethod(operationName="removeType")
//    @WebResult(name="measuretype") 
    public Type removeType(@WebParam(name="typ") String typ);

    @WebMethod(operationName="getAllGoal")
//    @WebResult(name="person") 
    public List<Goal> getAllGoal();
 
    @WebMethod(operationName="saveGoal")
//    @WebResult(name="person") 
    public Goal saveGoal(@WebParam(name="gol") String gol);
    
    @WebMethod(operationName="getGoalById")
//    @WebResult(name="person") 
    public Goal getGoalById(@WebParam(name="gid") int gid);
 
@WebMethod(operationName="getGoalByPid")
//    @WebResult(name="measure") 
    public List<Goal> getGoalByPid(@WebParam(name="pid") int pid);
    
    
    @WebMethod(operationName="updateGoal")
//    @WebResult(name="person") 
    public Goal updateGoal(@WebParam(name="goal") String g);
    
    @WebMethod(operationName="getGolByPidTid")
//    @WebResult(name="person") 
    public Goal getGolByPidTid(@WebParam(name="pid") int pid,@WebParam(name="tid") int tid);
    
    @WebMethod(operationName="deleteGoal")
//    @WebResult(name="person") 
    public List<Goal> deleteGoal(@WebParam(name="Goal") int g);
    
  
}