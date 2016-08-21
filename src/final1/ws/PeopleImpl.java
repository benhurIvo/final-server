package final1.ws;


import com.fasterxml.jackson.databind.ObjectMapper;
import final1.domain.Goal;
import final1.domain.Healthprofile;
import final1.domain.Person;
import final1.domain.Type;
import final1.mtds.GoalMtd;
import final1.mtds.HealthMtd;
import final1.mtds.PersonMtd;
import final1.mtds.TypeMtd;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
	return PersonMtd.getAllPeople();
    }

    @Override
    public Person savePerson(String person) {
	Person ob = new Person();
	try {
	    ob = new ObjectMapper().readValue(person, Person.class);
	} catch (IOException ex) {
	    ex.printStackTrace();
	    }
	return PersonMtd.savePerson(ob);
    }

    @Override
    public Person updatePerson(String person) {
	Person ob = new Person();
	try {
	    ob = new ObjectMapper().readValue(person, Person.class);
	} catch (IOException ex) {
	    ex.printStackTrace();
	    }
	return PersonMtd.updatePerson(ob);
    }

    @Override
    public List<Person> removePerson(Person p) {
	
	 PersonMtd.removePerson(p);
	 return PersonMtd.getAllPeople();
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
    public Healthprofile saveHealthprofile(String hprof) {
	Healthprofile ob = new Healthprofile();
	try {
	    ob = new ObjectMapper().readValue(hprof, Healthprofile.class);
	} catch (IOException ex) {
	    ex.printStackTrace();
	    }
	return  HealthMtd.saveHealthprofile(ob);
    }

    @Override
    public Healthprofile updateHealth(String hprof) {
	Healthprofile ob = new Healthprofile();
	try {
	    ob = new ObjectMapper().readValue(hprof, Healthprofile.class);
	} catch (IOException ex) {
	    ex.printStackTrace();
	    }
	return HealthMtd.updateHealth(ob);
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
    public Type saveType(String typ) {
	Type ob = new Type();
	try {
	    ob = new ObjectMapper().readValue(typ, Type.class);
	} catch (IOException ex) {
	    ex.printStackTrace();
	    }
	    return TypeMtd.saveType(ob);
		    }

    @Override
    public Type updateType(String typ) {
	Type ob = new Type();
	try {
	    ob = new ObjectMapper().readValue(typ, Type.class);
	} catch (IOException ex) {
	    ex.printStackTrace();
	    }
	return TypeMtd.updateType(ob);
    }

    @Override
    public Type removeType(String typ) {
	Type ob = new Type();
	try {
	    ob = new ObjectMapper().readValue(typ, Type.class);
	} catch (IOException ex) {
	    ex.printStackTrace();
	    }
	TypeMtd.removeType(ob);
	return TypeMtd.getAllType().get(0);
    }

    @Override
    public List<Goal> getAllGoal() {
	return GoalMtd.getAllGoal();
    }

    @Override
    public Goal saveGoal(String gol) {
	Goal ob = new Goal();
	try {
	    ob = new ObjectMapper().readValue(gol, Goal.class);
	} catch (IOException ex) {
	    ex.printStackTrace();
	    }
	return GoalMtd.saveGoal(ob);
    }

    @Override
    public Goal getGoalById(int gid) {
	return GoalMtd.getGoalById(gid);
    }

    @Override
    public Goal updateGoal(String g) {
	Goal ob = new Goal();
	try {
	    ob = new ObjectMapper().readValue(g, Goal.class);
	} catch (IOException ex) {
	    ex.printStackTrace();
	    }
	return GoalMtd.updateGoal(ob);
    }

    @Override
    public Goal getGolByPidTid(int pid, int tid) {
	return GoalMtd.getGolByPidTid(tid, pid).get(0);
    }

    @Override
    public List<Goal> deleteGoal(String g) {
	Goal ob = new Goal();
	try {
	    ob = new ObjectMapper().readValue(g, Goal.class);
	} catch (IOException ex) {
	    ex.printStackTrace();
	    }
	GoalMtd.removeGoal(ob);
	return GoalMtd.getAllGoal();
    }

    @Override
    public List<Goal> getGoalByPid(int pid) {
	return GoalMtd.getGoalByPid(pid);
    }

    @Override
    public List<Healthprofile> getAllHealth() {
	return HealthMtd.getAllHP();
    }

}