package com.sample;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

//Your drools project starts from here
public class DroolsTest {
	// KIE Configuration
	private final static KieServices ks = KieServices.Factory.get();
	private final static KieContainer kContainer = ks.getKieClasspathContainer();
	private final static KieSession kSession = kContainer.newKieSession("ksession-rules");

	// resource initializer
	private final static List<Object> resources = new ArrayList<>();

	// main method
	public static void main(String[] args) {
		//wantGlobalResources(kSession, 0);
		//kSession.insert(new AccumulateBuiltInFunction(12));
		//kSession.insert(new AccumulateBuiltInFunction(12));
		//kSession.insert(new AccumulateBuiltInFunction(12));
		// setFocusAndFire(kSession, "dot operator for multi attribute selection");
		//kSession.insert(new Employee(null,null, 12,new SkillSet("java","javascript"),null));
		wantGlobalResources(kSession,0);
		setFocusAndFire(kSession, "single accumulate function return data");

	}

	// initialize all resources which you want to use in drl file.
	static {
		// resource number - 0
		resources.add(List.of(//list of employee : name, address list, age and skillset
				/*--------------------- employee-1 ------------------------*/
				new Employee(
						"kumar",
						List.of(
								new Address("bihar", "patna"), 
								new Address("up", "vila"),
								new Address("jharkhand", "ranchi")
								),
						12, 
						new SkillSet(
								"java", 
								"javascript"
								),
						List.of(3453,23213)),
				/*--------------------- employee-2 ------------------------*/
				new Employee(
						"gaurav",
						List.of(
								new Address("tamil nadu", "coimbatore"), 
								new Address("gujarat", "surat"),
								new Address("maharashtra", "nagpur")
								),
						34, 
						new SkillSet(
								"c++", 
								"nodeJS"
								),
						List.of(9876,5768)),
				/*--------------------- employee-3 ------------------------*/
				new Employee(
						"verma", 
						List.of(
								new Address("kerala", "kochi"), 
								new Address("kerala", "thrissur"),
								new Address("bihar", "danapur")), 
						44, 
						new SkillSet(
								"visual basic", 
								"typescript"
								),
						List.of(45655,32783)))
				);

		// resource number - 1
		resources.add(new int[] { 1, 2, 3, 4, 5 });
	}

	public static void wantGlobalResources(KieSession kSession, int... resourceNumber) {
		if (resourceNumber == null)
			return;
		for (int i : resourceNumber)
			kSession.insert(resources.get(i));

	}

	public static <T> void genericFunction(KieSession kSession, T t) {
		kSession.insert(t);
	}

	// accumulate function
	// 1.drl----------------------------------------------------------------
	public static void setFocusAndFire(KieSession kSession, String agendaGroup) {
		kSession.getAgenda().getAgendaGroup(agendaGroup).setFocus();
		kSession.fireAllRules();
		kSession.dispose();
		kSession.getAgenda().getAgendaGroup(agendaGroup).clear();
	}

	// accumulate function
	// 2.drl----------------------------------------------------------------
	public static void accumulate_function_2(KieSession kSession, String agendaGroup) {
		kSession.getAgenda().getAgendaGroup(agendaGroup).setFocus();
		wantGlobalResources(kSession, 1);
		kSession.fireAllRules();
		kSession.getAgenda().getAgendaGroup(agendaGroup).clear();
	}

	// accumulate function
	// 3.drl----------------------------------------------------------------
	public static void accumulate_function_3(KieSession kSession, String agendaGroup) {
		kSession.getAgenda().getAgendaGroup(agendaGroup).setFocus();

		kSession.fireAllRules();
		kSession.getAgenda().getAgendaGroup(agendaGroup).clear();
	}
}
