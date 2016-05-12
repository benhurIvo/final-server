package final1.ws;


import final1.domain.Goal;
import final1.domain.Healthprofile;
import final1.domain.Person;
import final1.domain.Type;
import final1.mtds.GoalMtd;
import final1.mtds.HealthMtd;
import final1.mtds.PersonMtd;
import final1.mtds.TypeMtd;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import javax.jws.WebService;

//Service Implementation

@WebService(endpointInterface = "final1.ws.People",
    serviceName="PeopleService")
public class PeopleImpl implements People {

    @Override
    public Person getPersonById(int pid) {
	return PersonMtd.getPersonById(pid);
    }

    @Override
    public List<Person> getAll() {
	return PersonMtd.getAll();
    }

    @Override
    public Person savePerson(Person person) {
	try{
	System.out.println("pers "+person.getFirstname() + " "+person.getLastname());
	}catch(Exception ex){
	    System.out.println("hmmmm exceptn \n\n\n\n");
	    ex.printStackTrace();
	}
	return PersonMtd.savePerson(person);
    }

    @Override
    public Person updatePerson(Person person) {
	return PersonMtd.updatePerson(person);
    }

    @Override
    public List<Person> removePerson(Person p) {
	 PersonMtd.removePerson(p);
	 return PersonMtd.getAll();
    }

    @Override
    public List<Healthprofile> getHProfByPrsnMeasure(int pid, String mes) {
	return PersonMtd.getHProfByPrsnMeasure(pid, mes);
    }

    @Override
    public List<Healthprofile> getHealthprofByPid(int pid) {
	return PersonMtd.getHealthprofByPid(pid);
    }

    @Override
    public Healthprofile getHealthProfByPidTid(int pid, int mid) {
	return PersonMtd.getHealthProfByPidTid(pid, mid);
    }

    @Override
    public Healthprofile getHealthById(int hid) {
	return HealthMtd.getHealthById(hid);
    }

    @Override
    public Healthprofile saveHealthprofile(Healthprofile hprof) {
	return  HealthMtd.saveHealthprofile(hprof);
    }

    @Override
    public Healthprofile updateHealth(Healthprofile hprof) {
	return HealthMtd.updateHealth(hprof);
    }

    @Override
    public Healthprofile removeHealth(Healthprofile hprof) {
	HealthMtd.removeHealth(hprof);
	return HealthMtd.getAllHP().get(0);
    }

    @Override
    public List<Type> getAllType() {
	return TypeMtd.getAllType();
    }

    @Override
    public Type getTypeById(int tid) {
	return TypeMtd.getTypeById(tid);
    }

    @Override
    public List<Type> getTypeByString(String mes) {
	return TypeMtd.getTypeByString(mes);
		}

    @Override
    public Type saveType(Type typ) {
	    return TypeMtd.saveType(typ);
		    }

    @Override
    public Type updateType(Type typ) {
	return TypeMtd.updateType(typ);
    }

    @Override
    public Type removeType(Type typ) {
	TypeMtd.removeType(typ);
	return TypeMtd.getAllType().get(0);
    }

    @Override
    public List<Goal> getAllGoal() {
	return GoalMtd.getAllGoal();
    }

    @Override
    public Goal saveGoal(Goal gol) {
	return GoalMtd.saveGoal(gol);
    }

    @Override
    public Goal getGoalById(int gid) {
	return GoalMtd.getGoalById(gid);
    }

    @Override
    public Goal updateGoal(Goal g) {
	return GoalMtd.updateGoal(g);
    }

    @Override
    public Goal getGolByPidTid(int pid, int tid) {
	return GoalMtd.getGolByPidTid(tid, pid).get(0);
    }

    @Override
    public List<Goal> deleteGoal(Goal g) {
	GoalMtd.removeGoal(g);
	return GoalMtd.getAllGoal();
    }

    @Override
    public List<Goal> getGoalByPid(int pid) {
	return GoalMtd.getGoalByPid(pid);
    }
 
}