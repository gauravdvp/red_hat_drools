package com.sample;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

	public static final void main(String[] args) {
		List.of(new Color("green"));
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-rules");
			kSession.getAgenda().getAgendaGroup("similar-group").setFocus();
			List<Employee> emp = List.of(
					new Employee("kumar",
							List.of(new Address("bihar_1", "patna_1"), new Address("bihar_1_1", "patna_1_1"),
									new Address("bihar_1_1_1", "patna_1_1_1"))),
					new Employee("gaurav", List.of(new Address("bihar_2", "patna_2"),
							new Address("bihar_2_1", "patna_2_1"), new Address("bihar_2_1_1", "patna_2_1_1"))));
			kSession.insert(emp);
			kSession.fireAllRules();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private class Color {
		private String color;

		public Color(String color) {
			this.color = color;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
	}

	public static List<Color> getList(List<Color> l, Predicate<Color> p) {
		return l.stream().filter(p).collect(Collectors.toList());

	}
}
